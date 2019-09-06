package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.vo.ReplyVO;

public interface IReplyDao {
	/**
	* Method : getReplyList
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	List<ReplyVO> getReplyList(SqlSession sqlSession, int post_no);
	
	/**
	* Method : insertReply
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param replyVO
	* @return
	* Method 설명 : 댓글 추가
	*/
	int insertReply(SqlSession sqlSession, ReplyVO replyVo);
	
	/**
	* Method : deleteReply
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param reply_no
	* @return
	* Method 설명 : 댓글 삭제
	*/
	int deleteReply(SqlSession sqlSession, int reply_no);
}
