package kr.or.ddit.atta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atta.vo.AttaVO;

public interface IAttaService {
	/**
	* Method : getAttaList
	* 작성자 : PC-21
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	public List<AttaVO> getAttaList(int post_no);
	
	/**
	* Method : insertAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param attaVo
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	public int insertAtta(AttaVO attaVo);
	
	/**
	* Method : deleteAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param atta_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	public int deleteAtta(int atta_no);
	
	/**
	* Method : getAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param atta_no
	* @return
	* Method 설명 : 첨부파일 조회
	*/
	public AttaVO getAtta(int atta_no);
}
