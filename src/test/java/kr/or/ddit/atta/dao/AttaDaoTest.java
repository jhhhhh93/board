package kr.or.ddit.atta.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.vo.AttaVO;
import kr.or.ddit.util.MybatisUtil;

public class AttaDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AttaDaoTest.class);
	private IAttaDao attaDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("AttaDaoTestBefore()");
		attaDao = AttaDaoImpl.getInstance();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		logger.debug("AttaDaoTestAfter()");
		sqlSession.close();
	}

	@Test
	public void getAttaListTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		List<AttaVO> attaList = attaDao.getAttaList(sqlSession, post_no);
		
		/***Then***/
		assertEquals(1, attaList.size());
	}
	
	@Test
	public void insertAttaTest() {
		/***Given***/
		AttaVO attaVo = new AttaVO();
		attaVo.setAtta_nm("첨부파일추가테스트");
		attaVo.setAtta_path("첨부파일경로추가테스트");
		attaVo.setPost_no(1);
		
		/***When***/
		int insertCnt = attaDao.insertAtta(sqlSession, attaVo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttaTest() {
		/***Given***/
		int atta_no = 2;
		
		/***When***/
		int deleteCnt = attaDao.deleteAtta(sqlSession, atta_no);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getAttaTest() {
		/***Given***/
		int atta_no = 5;
		
		/***When***/
		AttaVO attaVo = attaDao.getAtta(sqlSession, atta_no);

		/***Then***/
		assertEquals("brown.png", attaVo.getAtta_nm());
	}

}
