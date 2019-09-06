package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyServiceTest.class);
	private IReplyService replyService;
	
	@Before
	public void setup() {
		logger.debug("ReplyServiceTestBefore()");
		replyService = ReplyServiceImpl.getInstance();
	}

	@Test
	public void getReplyListTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		List<ReplyVO> replyList = replyService.getReplyList(post_no);

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
		int insertCnt = replyService.insertReply(replyVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_no = 6;
		
		/***When***/
		int deleteCnt = replyService.deleteReply(reply_no);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
