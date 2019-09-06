package kr.or.ddit.atta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atta.vo.AttaVO;

public interface IAttaDao {
	/**
	* Method : getAttaList
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	public List<AttaVO> getAttaList(SqlSession sqlSession, int post_no);
	
	/**
	* Method : insertAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param attaVo
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	public int insertAtta(SqlSession sqlSession, AttaVO attaVo);
	
	/**
	* Method : deleteAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param atta_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	public int deleteAtta(SqlSession sqlSession, int atta_no);
	
	/**
	* Method : getAtta
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param atta_no
	* @return
	* Method 설명 : 첨부파일 조회
	*/
	public AttaVO getAtta(SqlSession sqlSession, int atta_no);
}
