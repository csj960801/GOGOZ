package com.myapp.VO;

//import org.springframework.web.multipart.MultipartFile;

public class MusicVO {

	private String uploader;
	private String uploadDate;
	private String uploadMusic;

	public MusicVO() {

	}

	public MusicVO(String uploader, String uploadDate, String uploadMusic) {
         this.uploader = uploader;
	     this.uploadDate = uploadDate;
	     this.uploadMusic = uploadMusic;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadMusic() {
		return uploadMusic;
	}

	public void setUploadMusic(String uploadMusic) {
		this.uploadMusic = uploadMusic;
	}
}