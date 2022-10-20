package com.myapp.Daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.DAO.MusicDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.MusicVO;

@Repository("com.myapp.DAO.MusicDAO")
public class MusicDAOImpl implements MusicDAO {

	private Logger musiclog = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession session;
	
	/**
	 * 업로드된 파일타입 검사 함수(mp3형식이 아닐경우 false)
	 */
	@Override
	public boolean FileType(MusicVO mvo) {
		boolean fileTypeFlag = false;
		if (mvo.getUploadMusic().indexOf("mp3") <= -1) {
			fileTypeFlag = false;
			musiclog.info("=====================");
			musiclog.info("mp3형식파일이 아닙니다.");
			musiclog.info("=====================");
		} else {
			fileTypeFlag = true;
			musiclog.info("=====================");
			musiclog.info("mp3형식파일 확인되었습니다.");
			musiclog.info("=====================");
		}
		return fileTypeFlag;
	}

	/**
	 * 업로드 데이터 저장(insert)
	 */
	@Override
	public int FileUpload(MusicVO mvo) {
		int uploadInfo = 0;
		if (FileType(mvo)) {
			uploadInfo = session.insert("musicinsert", mvo);
		}
		return uploadInfo;
	}

	/**
	 * 업로드 파일 중복검사
	 */
	@Override
	public boolean duplicateCheck(MusicVO mvo) {
		MusicVO duplicate = session.selectOne("duplicateFile", mvo);

		boolean duplicateFlag = false;
		if (duplicate != null) {
			duplicateFlag = true;
		}
		return duplicateFlag;
	}

	/**
	 * 파일 목록 출력
	 */
	@Override
	public List<Object> FileList(MusicVO mvo) {
		List<Object> filelist = new ArrayList<Object>();

		List<MusicVO> musicData = session.selectList("fileselect", mvo);
		filelist.add(musicData);

		return filelist;
	}
}