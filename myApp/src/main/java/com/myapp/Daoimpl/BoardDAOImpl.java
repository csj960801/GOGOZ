package com.myapp.Daoimpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.DAO.BoardDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.BoardVO;

@Repository("com.myapp.DAO.BoardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;

	@Override
	public int InquiryBoard(BoardVO bvo) {

		int inquiry = session.insert("inquiry", bvo);
		return (inquiry > 0) ? 1 : 0;
	}

	/**
	 * 게시글 데이터를 작성했던 유저가 본인이 작성했던 게시글을 볼 수 있도록 함.
	 */
	@Override
	public List<BoardVO> userBoard(Map<String, Object> memberName) {
		// TODO Auto-generated method stub
		List<BoardVO> memberBoardList = session.selectList("memberBoardList", memberName);
		return memberBoardList;
	}

	/**
	 * 수정할 게시글 데이터를 불러 온다.
	 */
	@Override
	public BoardVO userBoardUpdate(Map<String, Object> param) {
		// TODO Auto-generated method stub
		BoardVO memberBoardUpdate = session.selectOne("memberBoardUpdate", param);
		return memberBoardUpdate;
	}

	/**
	 * 게시글 데이터 수정
	 */
	@Override
	public int InquiryUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		int inquiryupdate = session.update("inquiryUpdate", bvo);
		return inquiryupdate;
	}
}
