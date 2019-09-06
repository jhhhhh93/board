package kr.or.ddit.reply.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyVO {
	private String reply_no    ;
	private String reply_cont  ;
	private Date reply_date  ;
	private String reply_status;
	private int post_no;
	private String userid ;
	
	public String getReply_no() {
		return reply_no;
	}
	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_cont() {
		return reply_cont;
	}
	public void setReply_cont(String reply_cont) {
		this.reply_cont = reply_cont;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public String getReply_date_fmt() {
		return new SimpleDateFormat("yyyy-MM-dd").format(reply_date);
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_status() {
		return reply_status;
	}
	public void setReply_status(String reply_status) {
		this.reply_status = reply_status;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
