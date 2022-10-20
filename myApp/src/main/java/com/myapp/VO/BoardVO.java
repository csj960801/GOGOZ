package com.myapp.VO;

public class BoardVO {

	private String title;
	private String writer;
	private String date;
	private String content;
	private String OriginContent;

	public BoardVO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOriginContent() {
		return OriginContent;
	}

	public void setOriginContent(String originContent) {
		OriginContent = originContent;
	}

}
