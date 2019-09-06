package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.vo.PostVO;

public interface IPostService {
	/**
	* Method : getpost
	* 작성자 : PC-21
	* 변경이력 :
	* @param map
	* @param board_no
	* @return
	* Method 설명 : 게시글 리스트 조회
	*/
	public Map<String, Object> getpostList(Map<String, Integer> map, int board_no);
	
	/**
	* Method : getPost
	* 작성자 : PC-21
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 조회
	*/
	public PostVO getPost(PostVO postVo);
	
	/**
	* Method : insertPost
	* 작성자 : PC-21
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	public int insertPost(PostVO postVo);
	
	/**
	* Method : updatePost
	* 작성자 : PC-21
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int updatePost(PostVO postVo);
	
	/**
	* Method : deletePost
	* 작성자 : PC-21
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제 (테이블에서 삭제 X / board_status = 'n' -> 미사용 변경)
	*/
	public int deletePost(int post_no);
}
