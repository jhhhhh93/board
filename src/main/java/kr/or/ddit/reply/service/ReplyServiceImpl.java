package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoImpl;
import kr.or.ddit.reply.vo.ReplyVO;
import kr.or.ddit.util.MybatisUtil;

public class ReplyServiceImpl implements IReplyService {
	
	private static IReplyService replyService;
	
	public static IReplyService getInstance() {
		if(replyService == null) {
			replyService = new ReplyServiceImpl();
		}
		return replyService;
	}
	
	private IReplyDao replyDao;
	
	private ReplyServiceImpl() {
		replyDao = ReplyDaoImpl.getInstance();
	}

	@Override
	public List<ReplyVO> getReplyList(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<ReplyVO> replyList = replyDao.getReplyList(sqlSession, post_no);
		sqlSession.close();
		return replyList;
	}

	@Override
	public int insertReply(ReplyVO replyVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = replyDao.insertReply(sqlSession, replyVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteReply(int reply_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = replyDao.deleteReply(sqlSession, reply_no);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

}
