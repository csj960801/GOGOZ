package com.myapp.Service;

import java.util.List;
import java.util.Map;

import com.myapp.VO.ChanelVO;

public interface ChanelService {

	public int ChanelCreate(ChanelVO cvo); // 채널 생성

	public int findDuplicateChanel(ChanelVO cvo); // 채널 중복 확인

	public List<ChanelVO> getChanelList(ChanelVO cvo);// 생성된 모든 채널리스트

}