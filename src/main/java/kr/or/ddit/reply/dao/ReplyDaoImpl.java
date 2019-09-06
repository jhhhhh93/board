package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyDaoImpl implements IReplyDao {
	
	private static IReplyDao replyDao;
	
	public static IReplyDao getInstance() {
		if(replyDao == null) {
			replyDao = new ReplyDaoImpl();
		}
		return replyDao;
	}
	
	private ReplyDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReplyVO> getReplyList(SqlSession sqlSession, int post_no) {
		return sqlSession.selectList("reply.getReplyList", post_no);
	}

	@Override
	public int insertReply(SqlSession sqlSession, ReplyVO replyVo) {
		return sqlSession.insert("reply.insertReply", replyVo);
	}

	@Override
	public int deleteReply(SqlSession sqlSession, int reply_no) {
		return sqlSession.update("reply.deleteReply", reply_no);
	}

}
