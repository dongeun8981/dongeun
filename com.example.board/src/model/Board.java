package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	private int bid;
	private String subject;
	private String writer;
	private int visit;
	private Date regdate;
	private String content;
	private String filename;
	private String fileOriName;
	private String fileSize;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Board() {}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileOriName() {
		return fileOriName;
	}

	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		String str = "게시물 번호 : " + getBid();
		str += "\t제목 : " + getSubject();
		str += "\t작성자 : " + getWriter();
		str += "\t조회수 : " + getVisit();
		str += "\t등록일 : " + sdf.format(getRegdate());
		
		return str;
	}	
}
