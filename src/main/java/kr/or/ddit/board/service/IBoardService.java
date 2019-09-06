package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	/**
	* Method : getBoardList
	* 작성자 : PC-21
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 조회
	*/
	public List<BoardVO> getBoardList();
	
	/**
	* Method : insertBoard
	* 작성자 : PC-21
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	public int insertBoard(BoardVO boardVo);
	
	/**
	* Method : deleteBoard
	* 작성자 : PC-21
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 삭제
	*/
	public int deleteBoard(int board_no);
	
	/**
	* Method : updateBoard
	* 작성자 : PC-21
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 정보 수정
	*/
	public int updateBoard(BoardVO boardVo);
}
