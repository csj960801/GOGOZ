package com.myapp.Controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.myapp.ServiceImpl.AdminServiceImpl;
import com.myapp.ServiceImpl.BoardServiceImpl;
import com.myapp.ServiceImpl.MemberServiceImpl;
import com.myapp.VO.BoardVO;
import com.myapp.VO.MemberVO;
import com.myapp.VO.UpdateVO;

@Controller
public class AppController {

	@Autowired
	// 회원 관련 서비스
	private MemberServiceImpl memberService;

	@Autowired
	// 게시판 관련 서비스
	private BoardServiceImpl boardService;

	@Autowired
	// 관리자 관련 서비스
	private AdminServiceImpl adminService;

	// System.out.println은 실프로젝트에서 사용하면 하드디스크io에 무리를 가할 수있으므로
	// 웬만하면 logging을 사용하도록 합시다
	private Logger log = LoggerFactory.getLogger(AppController.class);

	/**
	 * 메인
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/index.do")
	public String home(HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
		log.info("--------------------");
		log.info("메인으로 이동합니다.");
		log.info("--------------------");
		return "index";
	}// end of home()

	/**
	 * 회원가입
	 */
	@RequestMapping(value = "/MemberReg/MemberReg.do", method = RequestMethod.POST)
	public String MemberReg(MemberVO memberRegvo) {

		Map<String, Object> regMap = new HashMap<String, Object>();
		if (!MemberDuplicateCheck(memberRegvo)) {
			regMap.put("MemberReg", memberService.MemberRegister(memberRegvo));
		} else {
			regMap.put("duplicated", true);
		}
		return "redirect:/MemberLogin/login";
	}

	/**
	 * 회원중복 여부(vo test)
	 */
	public boolean MemberDuplicateCheck(MemberVO vo) {
		boolean duplicateMember = memberService.MemberDuplicateCheck(vo);
		return duplicateMember;
	}

	/**
	 * 로그인
	 */
	@RequestMapping(value = "/MemberLog/MemberLog.do", method = RequestMethod.POST)
	public Map<String, Object> MemberLog(MemberVO loginvo, HttpServletRequest req, HttpServletResponse res) {

		Map<String, Object> logMap = new HashMap<String, Object>();
		boolean login = memberService.MemberLog(loginvo);
		// boolean login = memberService.MemberLog(user);
		logMap.put("login", login);

		// 로그인이 정상적으로 진행되었을 때 session생성
		if (login) {
			HttpSession session = req.getSession();
			session.setAttribute("loginName", loginvo.getName());
			session.setAttribute("loginEmail", loginvo.getEmail());
		}
		return logMap;
	}

	/**
	 * 로그아웃
	 */
	@RequestMapping("/MemberLogout.do")
	public String logOut(HttpServletRequest req, String rememberName) {
		HttpSession session = req.getSession();
		session.invalidate();

		if (rememberName != null) {
			log.info("==============================");
			log.info("쿠키생성되었습니다!: " + rememberName);
			log.info("==============================");
		}

		return "index";
	}

	/**
	 * 회원탈퇴
	 */
	@RequestMapping("/MemberDel/MemberDel.do")
	public Map<String, Object> MemberDelete(MemberVO vo, HttpServletRequest req) {
		Map<String, Object> delMap = new HashMap<String, Object>();

		boolean delete = memberService.MemberDelete(vo.getEmail());
		if (delete) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		delMap.put("del", delete);
		return delMap;
	}

	/**
	 * 회원수정
	 */
	@RequestMapping("/MemberUpdate/MemberUpdate.do")
	public Map<String, Object> MemberUpdate(UpdateVO updatevo) {
		Map<String, Object> updateMap = new HashMap<String, Object>();

		boolean update = memberService.MemberUpdate(updatevo);

		updateMap.put("update", update);
		return updateMap;
	}

	/**
	 * 질문 게시판
	 */
	@RequestMapping(value = "/InquiryBoard/Inquiry.do", method = RequestMethod.POST)
	// @ResponseBody
	public Map<String, Object> InquiryBoard(BoardVO bvo, HttpServletRequest req) {
		Map<String, Object> boardMap = new HashMap<String, Object>();

		HttpSession session = req.getSession();

		// 만약 BoardForm.jsp에서 readonly가 적용되어있는 이름 데이터를 개발자도구로 수정해서 업로드 할 경우를 대비
		if (session.getAttribute("loginName").equals(bvo.getWriter())) {
			int inquiryCnt = boardService.InquiryBoard(bvo);
			if (inquiryCnt > 0) {
				log.info("===================================");
				log.info("게시글 업로드 되었습니다.");
				log.info("===================================");
				boardMap.put("inquiry", inquiryCnt);
			}
		} else {
			boardMap.put("inquiryFail", -1);
			log.info("===================================");
			log.info("게시자명이 일치하지않음.");
			log.info("===================================");
		}

		return boardMap;
	}

	/**
	 * 질문한 게시글 데이터 수정
	 * 
	 * @param bvo
	 * @param updateType
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/InquiryBoard/InquiryRevisionList.do")
	public Map<String, Object> InquiryBoardRevisionList(BoardVO bvo, @RequestParam("updateType") String updateType,
			HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 게시글 데이터 리스트 저장 map
		Map<String, Object> boardMap = new HashMap<String, Object>();

		// 전송받은 파라미터 저장 map
		Map<String, Object> paramMap = new HashMap<String, Object>();

		switch (updateType) {
		// 회원 이름으로 작성된 게시글 데이터들을 출력한다.
		case "client":
			String userName = req.getParameter("userName");
			paramMap.put("userName", userName);
			List<BoardVO> memberBoardList = boardService.userBoard(paramMap);
			boardMap.put("memberBoardList", memberBoardList);
			break;

		// 수정 성공 여부
		case "server":
			// String updateContent = req.getParameter("updateContent");
			int inquiryUpdate = boardService.InquiryUpdate(bvo);
			boardMap.put("inquirySuccess", inquiryUpdate);
			break;

		}
		return boardMap;
	}

	/**
	 * 수정할 게시글 데이터를 불러 온다.
	 * 
	 * @param updateData
	 * @return
	 */
	@RequestMapping("/InquiryBoard/InquiryRevision.do")
	public Map<String, Object> InquiryUpdate(@RequestParam("updateData") String updateData) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("updateData", updateData);

		Map<String, Object> boardMap = new HashMap<String, Object>();

		BoardVO memberBoardUpdate = boardService.userBoardUpdate(paramMap);
		log.info("가져온데이터: " + memberBoardUpdate.getTitle());
		log.info("가져온데이터: " + memberBoardUpdate.getWriter());
		log.info("가져온데이터: " + memberBoardUpdate.getDate());
		log.info("가져온데이터: " + memberBoardUpdate.getContent());

		boardMap.put("memberBoardUpdate", memberBoardUpdate);
		boardMap.put("title", memberBoardUpdate.getTitle());
		boardMap.put("writer", memberBoardUpdate.getWriter());
		boardMap.put("date", memberBoardUpdate.getDate());
		boardMap.put("content", memberBoardUpdate.getContent());
		return boardMap;
	}

	/**
	 * 관리자 전용 데이터 관리
	 */
	@RequestMapping("/Admin/Admin.do")
	public List<BoardVO> adminList(BoardVO adminvo, MemberVO mvo, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("adminSession", "Admin");

		// 게시판 데이터 리스트 출력
		List<BoardVO> InquiryBoard = adminService.InquiryList(adminvo);

		// 회원 데이터 리스트 출력
		List<MemberVO> memberlist = adminService.memberList(mvo);

		model.addAttribute("Inquirylist", InquiryBoard);
		model.addAttribute("memberlist", memberlist);

		return InquiryBoard;
	}

	/**
	 * 관리자 전용 문의글 혹은 회원 삭제
	 */
	@RequestMapping("/Admin/AdminDel.do")
	public Map<String, Object> InquiryDel(@RequestParam("titleparam") String titleparam,
			@RequestParam("delParam") String delParam) {
		Map<String, Object> delMap = new HashMap<String, Object>();

		// 게시글 삭제
		int inquirydel = adminService.InquiryDel(titleparam);

		// 회원 삭제
		int memberdel = adminService.memberDel(titleparam);

		if (inquirydel > 0 && delParam.equals("board")) {

			inquirydel = 1;
			delMap.put("admindel", inquirydel);

		} else if (memberdel > 0 && delParam.equals("member")) {

			memberdel = 2;
			delMap.put("admindel", memberdel);

		}
		return delMap;
	}

	/**
	 * 관리자전용 회원 정보 수정
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/Admin/AdminUpdate.do", method = RequestMethod.POST)
	public Map<String, Object> Update(@RequestParam("updateType") String updateType, MemberVO mvo,
			HttpServletResponse res) throws IOException {
		Map<String, Object> updateMap = new HashMap<String, Object>();

		// 관리자 전용 수정 페이지로 이동
		if (updateType.equals("client")) {

			updateMap.put("UpdateName", mvo.getName());
			updateMap.put("UpdateEmail", mvo.getEmail());

		}
		// 관리자 전용 수정 완료
		else if (updateType.equals("server")) {

			int memberUpdate = adminService.memberUpdate(mvo);
			if (memberUpdate > 0) {
				updateMap.put("memberUpdate", memberUpdate);
			}

		}

		return updateMap;
	}

}// end of class