package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.vo.ReplyVO;
import kr.or.ddit.util.MybatisUtil;

public class ReplyDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyDaoTest.class);
	private IReplyDao replyDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("ReplyDaoTestBefore()");
		replyDao = ReplyDaoImpl.getInstance();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

	@Test
	public void getReplyListTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		List<ReplyVO> replyList = replyDao.getReplyList(sqlSession, post_no);

		/***Then***/
		assertEquals(2, replyList.size());
	}
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVO replyVo = new ReplyVO();
		replyVo.setReply_cont("test");
		replyVo.setPost_no(1);
		replyVo.setUserid("sally");
		
		/***When***/
		int insertCnt = replyDao.insertReply(sqlSession, replyVo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_no = 4;
		
		/***When***/
		int deleteCnt = replyDao.deleteReply(sqlSession, reply_no);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
