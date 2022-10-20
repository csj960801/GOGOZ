package com.function.Music;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.ServiceImpl.MusicServiceImpl;
import com.myapp.VO.MusicVO;

/**
 * 음악 업로드, 다운로드 관련
 * 
 * @author 160109
 *
 */
@Controller
@RequestMapping("/Music")
public class MusicDownloadController {

	@Autowired
	private MusicServiceImpl musicservice;

	private Logger musicLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 음악 업로딩 기능(POST방식으로 받을 경우)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/MusicList.music", method = RequestMethod.POST)
	public Map<String, Object> MusicUploader(@ModelAttribute("MusicVO") MusicVO musicvo, HttpServletRequest req) {
		Map<String, Object> musicMap = new HashMap<String, Object>();

		// 중복검사 함수 실행
		boolean dataChecker = musicservice.duplicateCheck(musicvo);
		if (!dataChecker) {
			int FileUpload = musicservice.FileUpload(musicvo);
			if (FileUpload > 0) {
				musicLog.info("=================");
				musicLog.info("업로드 성공!");
				musicLog.info("=================");
				musicMap.put("musicData", FileUpload);

				// 업로드된 데이터들을 출력해서 가져오는 함수.
				musicMap.put("musicList", FileList(musicvo));
			}
		} else {
			musicMap.put("duplicated", dataChecker);
			musicLog.info("=================");
			musicLog.info("업로드된 곡이 중복되었음.");
			musicLog.info("=================");
		}

		return musicMap;
	}

	/**
	 * 음악 리스트 출력기능(GET방식으로 받을 경우)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/MusicList.music", method = RequestMethod.GET)
	public Map<String, Object> MusicDownloader(@ModelAttribute("mvo") MusicVO musicvo) {
		Map<String, Object> toDownloader = new HashMap<String, Object>();

		toDownloader.put("musicList", FileList(musicvo));
		musicLog.info("===============================");
		musicLog.info("다운로드 페이지에 접근하였습니다.");
		musicLog.info("===============================");

		return toDownloader;
	}

	/**
	 * 업로드된 데이터들을 출력해서 가져오는 함수.
	 * 
	 * @param mvo
	 * @return
	 */
	public List<Object> FileList(@ModelAttribute("MusicVO") MusicVO mvo) {
		List<Object> musicList = musicservice.FileList(mvo);
		return musicList;
	}

	/**
	 * MusicDownload.jsp에서 선택한 음악을 다운로드 시키도록
	 */
	@RequestMapping("/MusicDownloadActivate.music")
	public ModelAndView MusicDownloadActivate(@RequestParam(value = "selectedMusic") String musicname,
			HttpServletRequest req) {
		ModelAndView musicmav = new ModelAndView();

		// 국가 코드에 따른 언어 변경
		String forwardPath = req.getParameter("nationLang");
		switch (forwardPath) {
		case "ko-KR":
			forwardPath = "내 PC/다운로드";
			break;

		case "en-US":
			forwardPath = "my Computer/download";
			break;
		}// end of switch()

		String fullPath = forwardPath + "/MusicFile/" + musicname;
		File file = new File(fullPath);
		if (file.mkdir()) {
			musicLog.info("음악다운폴더생성: " + file.mkdir());
		} else {
			musicLog.info("음악다운폴더생성실패");
		}

		// BeanNameViewResolver(downloadView.java에서 다운로드 기능 담당)
		musicmav.setViewName("downloadView");
		musicmav.addObject("downloadFile", file);

		musicLog.info("musicDownload 탔음.");
		musicLog.info("fileName: " + musicname);
		musicLog.info("fullPath: " + fullPath);
		musicLog.info("nation: " + forwardPath);

		return musicmav;
	}
}
