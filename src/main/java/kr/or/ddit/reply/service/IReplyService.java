package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.vo.ReplyVO;

public interface IReplyService {
	/**
	* Method : getReplyList
	* 작성자 : PC-21
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	List<ReplyVO> getReplyList(int post_no);
	
	/**
	* Method : insertReply
	* 작성자 : PC-21
	* 변경이력 :
	* @param replyVO
	* @return
	* Method 설명 : 댓글 추가
	*/
	int insertReply(ReplyVO replyVo);
	
	/**
	* Method : deleteReply
	* 작성자 : PC-21
	* 변경이력 :
	* @param reply_no
	* @return
	* Method 설명 : 댓글 삭제
	*/
	int deleteReply(int reply_no);
}
