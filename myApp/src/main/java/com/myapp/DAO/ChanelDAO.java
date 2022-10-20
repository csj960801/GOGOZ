package com.myapp.DAO;

import java.util.List;
import java.util.Map;

import com.myapp.VO.ChanelVO;

/**
 * 채널 담당
 * 
 * @author CSJ
 *
 */
public interface ChanelDAO {
	public int ChanelCreate(ChanelVO cvo); // 채널 생성

	public int findDuplicateChanel(ChanelVO cvo);
	
	public List<ChanelVO> getChanelList(ChanelVO cvo);// 생성된 모든 채널리스트
}