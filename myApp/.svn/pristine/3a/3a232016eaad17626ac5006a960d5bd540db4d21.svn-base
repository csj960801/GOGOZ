package com.myapp.DAO;

import java.util.List;

import com.myapp.VO.MusicVO;

public interface MusicDAO {

	// 업로드된 파일타입 검사 함수
	boolean FileType(MusicVO mvo);

	// 파일 업로드
	int FileUpload(MusicVO mvo);

	// 업로드된 음악파일 중복검사
	boolean duplicateCheck(MusicVO mvo);
	
	// 업로드된 파일 데이터 출력
	List<Object> FileList(MusicVO mvo);
	
}
