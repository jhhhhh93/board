package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.vo.PostVO;

public interface IPostDao {
	/**
	* Method : getpost
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param map
	* @return
	* Method 설명 : 게시글 리스트 조회
	*/
	public List<PostVO> getpostList(SqlSession sqlSession, Map<String, Integer> map);
	
	/**
	* Method : getPostTotalCnt
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param board_no
	* @return
	* Method 설명 : 게시글 총 수량 조회
	*/
	public int getPostTotalCnt(SqlSession sqlSession, int board_no);
	
	/**
	* Method : insertPost
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	public int insertPost(SqlSession sqlSession, PostVO postVo);
	
	/**
	* Method : getPost
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 조회
	*/
	public PostVO getPost(SqlSession sqlSession, PostVO postVo);
	
	/**
	* Method : updatePost
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int updatePost(SqlSession sqlSession, PostVO postVo);
	
	/**
	* Method : deletePost
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제 (테이블에서 삭제 X / board_status = 'n' -> 미사용 변경)
	*/
	public int deletePost(SqlSession sqlSession, int post_no);
}
