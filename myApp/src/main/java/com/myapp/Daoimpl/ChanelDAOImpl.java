package com.myapp.Daoimpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.DAO.ChanelDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.ChanelVO;

@Repository("com.myapp.DAO.ChanelDAO")
public class ChanelDAOImpl implements ChanelDAO {

	@Autowired
	private SqlSession session;

	/**
	 * 채널 데이터 생성
	 */
	@Override
	public int ChanelCreate(ChanelVO cvo) {
		// 채널 중복 확인
		if (findDuplicateChanel(cvo) > -1) {
			int chanelCreate = session.insert("chanelinsert", cvo);
			if (chanelCreate > 0) {
				// session.commit();
				return chanelCreate;
			}
		}
		return -1;
	}

	/**
	 * 채널 데이터 중복 확인
	 */
	@Override
	public int findDuplicateChanel(ChanelVO cvo) {
		ChanelVO chanelvo = session.selectOne("findDuplicateChanel", cvo);
		if (chanelvo == null) {
			return 1;
		}
		return -1;
	}

	/**
	 * 생성된 전체 포트 가져오기
	 * 
	 * @param pvo
	 * @return
	 */
	@Override
	public List<ChanelVO> getChanelList(ChanelVO cvo) {
		List<ChanelVO> portlist = session.selectList("chanelList", cvo);
		return portlist;
	}

}