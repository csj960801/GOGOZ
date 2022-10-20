package com.myapp.Daoimpl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.DAO.MemberDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.MemberVO;
import com.myapp.VO.UpdateVO;

@Repository("com.myapp.dao.MemberDAO")
public class MemberDaoImpl implements MemberDAO {

	private Logger MemberDaolog = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	private SqlSession session;

	/**
	 * 회원가입
	 */
	@Override
	public boolean MemberRegister(MemberVO memberRegvo) {
		// TODO Auto-generated method stub
		int memberReg = session.insert("MemberRegister", memberRegvo);
		if (memberReg > 0) {
			//session.commit();
			return true;
		}
		return false;
	}

	/**
	 * 로그인
	 */
	@Override
	public boolean MemberLog(MemberVO logvo) {
		// TODO Auto-generated method stub
		MemberVO member = session.selectOne("memberlog", logvo);
		if (member != null) {
			return true;
		}
		return false;
	}

	/**
	 * 회원가입(구버전)
	 * 
	 * @Override public boolean MemberRegister(MemberVO vo) { boolean check = false;
	 * 
	 *           int insertMember = session.insert("MemberRegister", vo); if
	 *           (insertMember > 0) { MemberDaolog.info("회원가입성공!");
	 *           session.commit(); check = true; }
	 * 
	 *           return check; }// end of MemberRegister
	 */

	/**
	 * 로그인(구버전)
	 * 
	 * @Override public boolean MemberLog(MemberVO vo) { MemberVO login =
	 *           session.selectOne("memberlog", vo);
	 * 
	 *           boolean logCheck = false; if (login != null) {
	 *           MemberDaolog.info("============================");
	 *           MemberDaolog.info("로그인 이름:" + login.getName());
	 *           MemberDaolog.info("로그인 이메일:" + login.getEmail());
	 *           MemberDaolog.info("============================"); logCheck = true;
	 *           } return logCheck; }
	 */

	/**
	 * 회원중복검사
	 */
	@Override
	public boolean MemberDuplicateCheck(MemberVO vo) {
		MemberVO duplicate = session.selectOne("memberduplicate", vo);

		boolean duplicateflag = false;
		if (duplicate != null) {
			duplicateflag = true;
		}
		return duplicateflag;
	}

	/**
	 * 회원삭제
	 */
	@Override
	public boolean MemberDelete(String email) {
		int delCheck = session.delete("memberdel", email);

		boolean del = false;
		if (delCheck > 0) {
			MemberDaolog.info("============================");
			MemberDaolog.info("삭제된 이메일:" + email);
			MemberDaolog.info("============================");
			//session.commit();
			del = true;
		}
		return del;
	}

	/**
	 * 회원 이메일 수정
	 */
	@Override
	public boolean MemberUpdate(UpdateVO vo) {
		int update = session.update("memberupdate", vo);

		boolean updateflag = false;
		if (update > 0) {
			//session.commit();
			MemberDaolog.info("============================");
			MemberDaolog.info("수정전 이메일:" + vo.getOriginEmail());
			MemberDaolog.info("수정된 이메일:" + vo.getModifyEmail());
			MemberDaolog.info("============================");
			updateflag = true;
		}
		return updateflag;
	}

}