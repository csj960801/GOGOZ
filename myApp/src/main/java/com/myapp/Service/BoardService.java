package com.myapp.Service;

import java.util.List;
import java.util.Map;
import com.myapp.VO.BoardVO;

public interface BoardService {

	// int InquiryBoard(BoardVO vo);
	int InquiryBoard(BoardVO vo);

	// 게시글 데이터를 작성했던 유저가 본인이 작성했던 게시글을 볼 수 있도록 함.
	List<BoardVO> userBoard(Map<String, Object> memberName);

	// 수정할 게시글 데이터를 불러 온다.
	BoardVO userBoardUpdate(Map<String, Object> param);

	// 게시글 데이터 수정
	int InquiryUpdate(BoardVO bvo);

}
