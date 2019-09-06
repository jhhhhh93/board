package kr.or.ddit.post.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostVO {
	private int post_no;
	private int board_no   ;
	private String post_title ;
	private String post_cont  ;
	private Date post_date  ;
	private String post_status;
	private String userid  ;
	private int parent_post_no = 0;
	private int post_gn;
	private int level;
	
	public PostVO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPost_gn() {
		return post_gn;
	}

	public void setPost_gn(int post_gn) {
		this.post_gn = post_gn;
	}

	public int getLevel() {
		return level-1;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPost_date_fmt() {
		return new SimpleDateFormat("yyyy-MM-dd").format(post_date);
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_cont() {
		return post_cont;
	}

	public void setPost_cont(String post_cont) {
		this.post_cont = post_cont;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public String getPost_status() {
		return post_status;
	}

	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getParent_post_no() {
		return parent_post_no;
	}

	public void setParent_post_no(int parent_post_no) {
		this.parent_post_no = parent_post_no;
	}

	@Override
	public String toString() {
		return "PostVO [post_no=" + post_no + ", board_no=" + board_no + ", post_title=" + post_title + ", post_cont="
				+ post_cont + ", post_date=" + post_date + ", post_status=" + post_status + ", userid=" + userid
				+ ", parent_post_no=" + parent_post_no + "]";
	}
	
	
}
