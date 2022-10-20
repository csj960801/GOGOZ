package com.function.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.ServiceImpl.ChanelServiceImpl;
import com.myapp.VO.ChanelVO;

/**
 * 채널리스트 관련
 * 
 * @author 160109
 *
 */
@Controller
@RequestMapping(value = "/function")
public class FunctionController {

	@Autowired
	private ChanelServiceImpl chanelService;

	private Logger functionLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 중복된 채널이 아닐시 채널 생성
	 * 
	 * @param chanelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Function/ChanelCreate.bo", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	public Map<String, Object> chanelCreate(@RequestBody ChanelVO cvo) {
		Map<String, Object> chanelcreateMap = new HashMap<String, Object>();

		// 채널 중복 확인
		if (findDuplicateChanel(cvo) > -1) {
			int chanelCreate = chanelService.ChanelCreate(cvo);
			if (chanelCreate > -1) {
				chanelcreateMap.put("chanelMap", chanelCreate);
				functionLog.info("====================================");
				functionLog.info("채널 생성자:" + cvo.getChanelMaker());
				functionLog.info("채널:" + cvo.getChanel());
				functionLog.info("====================================");
			}
		}
		// 채널 중복시
		else if (findDuplicateChanel(cvo) == -1) {
			chanelcreateMap.put("chanelMap", -1);
			functionLog.info("====================================");
			functionLog.info("채널중복:" + cvo.getChanel());
			functionLog.info("====================================");
		}
		return chanelcreateMap;
	}

	/**
	 * 채널 생성 중복체크
	 * 
	 * @param cvo
	 * @return
	 */
	public int findDuplicateChanel(ChanelVO cvo) {
		int findResult = chanelService.findDuplicateChanel(cvo);
		return findResult;
	}

	/**
	 * 채널 리스트 검색 데이터 출력
	 * 
	 * @param pvo
	 * @return
	 */
	@RequestMapping(value = "/Function/ChanelList.bo", method = RequestMethod.POST)
	public ModelAndView PortList(ChanelVO cvo) {

		ModelAndView chanelMAV = new ModelAndView();

		// 저장되어있는 포트들을 클라이언트에서 출력.
		List<ChanelVO> chanelList = chanelService.getChanelList(cvo);
		if (chanelList.size() > 0) {
			chanelMAV.addObject("chanelList", chanelList);
		} else {
			chanelMAV.addObject("chanelList", null);
		}

		chanelMAV.setViewName("/Function/ChanelList");
		// portListMap.put("chanelList", chanelList);
		return chanelMAV;
	}

}