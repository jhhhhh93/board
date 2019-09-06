package kr.or.ddit.board.vo;

import java.util.Date;

public class BoardVO {
	private int board_no    ;
	private String board_nm    ;
	private Date board_date  ;
	private String board_status;
	private String userid;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int board_no, String board_nm, Date board_date, String board_status, String userid) {
		super();
		this.board_no = board_no;
		this.board_nm = board_nm;
		this.board_date = board_date;
		this.board_status = board_status;
		this.userid = userid;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_nm() {
		return board_nm;
	}

	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getBoard_status() {
		return board_status;
	}

	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_nm=" + board_nm + ", board_date=" + board_date
				+ ", board_status=" + board_status + ", userid=" + userid + "]";
	}
	
	
}
