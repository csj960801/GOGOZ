package com.myapp.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.Daoimpl.MemberDaoImpl;
import com.myapp.Service.MemberCrudService;
import com.myapp.VO.MemberVO;
import com.myapp.VO.UpdateVO;

//@Service는 Repository(DAO)값을 받아 Controller에 주입시킨다
@Service("com.myapp.Service.MemberCrudService")
public class MemberServiceImpl implements MemberCrudService {

	private Logger Servicelog = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberDaoImpl mDao;

	@Override
	public boolean MemberRegister(MemberVO memberRegvo) {
		// TODO Auto-generated method stub
		return mDao.MemberRegister(memberRegvo);
	}
	
	@Override
	public boolean MemberLog(MemberVO logvo) {
		// TODO Auto-generated method stub
		return mDao.MemberLog(logvo);
	}
	/**
	 * @Override public boolean MemberRegister(MemberVO membervo) { return
	 *           mDao.MemberRegister(membervo); }// end of MemberRegister
	 */

	/**
	 * @Override public boolean MemberLog(MemberVO vo) { return mDao.MemberLog(vo);
	 *           }
	 */

	@Override
	public boolean MemberDuplicateCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return mDao.MemberDuplicateCheck(vo);
	}

	@Override
	public boolean MemberDelete(String email) {
		// TODO Auto-generated method stub
		return mDao.MemberDelete(email);
	}

	@Override
	public boolean MemberUpdate(UpdateVO vo) {
		// TODO Auto-generated method stub
		return mDao.MemberUpdate(vo);
	}

}