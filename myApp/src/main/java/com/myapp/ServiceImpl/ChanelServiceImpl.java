package com.myapp.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.Daoimpl.ChanelDAOImpl;
import com.myapp.Service.ChanelService;
import com.myapp.VO.ChanelVO;

@Service("com.myapp.Service.ChanelService")
public class ChanelServiceImpl implements ChanelService {

	@Autowired
	private ChanelDAOImpl chanelDAO;

	/**
	 * 채널생성
	 */
	@Override
	public int ChanelCreate(ChanelVO cvo) {
		// TODO Auto-generated method stub
		return chanelDAO.ChanelCreate(cvo);
	}

	/**
	 * 채널 생성 중복 확인
	 */
	@Override
	public int findDuplicateChanel(ChanelVO cvo) {
		// TODO Auto-generated method stub
		return chanelDAO.findDuplicateChanel(cvo);
	}
	/**
	 * 채널리스트
	 */
	@Override
	public List<ChanelVO> getChanelList(ChanelVO cvo) {
		// TODO Auto-generated method stub
		return chanelDAO.getChanelList(cvo);
	}

}