package com.myapp.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.Daoimpl.MusicDAOImpl;
import com.myapp.Service.MusicService;
import com.myapp.VO.MusicVO;

@Service("com.myapp.Service.MusicService")
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicDAOImpl musicdao;
	
	@Override
	public int FileUpload(MusicVO mvo) {
		// TODO Auto-generated method stub
		return musicdao.FileUpload(mvo);
	}
	
	@Override
	public boolean duplicateCheck(MusicVO mvo) {
		// TODO Auto-generated method stub
		return musicdao.duplicateCheck(mvo);
	}
	
	@Override
	public List<Object> FileList(MusicVO mvo){
		return musicdao.FileList(mvo);
	}
}
