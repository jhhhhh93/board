package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.user.dao.DaoTest;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	private IBoardDao boardDao;
	private SqlSession sqlSession;
	
	// 테스트에 공통적으로 필요한 자원을 생성/ 초기화
	   @Before
	   public void setup() {
	      logger.debug("UserDaoTestBefore()");
	      boardDao = BoardDaoImpl.getInstance();
	      sqlSession = MybatisUtil.getSession();
	   }
	   
	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("UserDaoTestAfter()");
	      sqlSession.close();
	   }

	@Test
	public void getBoardList() {
		/***Given***/
		
		/***When***/
		List<BoardVO> boardList = boardDao.getBoardList(sqlSession);

		/***Then***/
		assertEquals(1, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		
		boardVo.setBoard_nm("테스트게시판");
		boardVo.setBoard_status("y");
		boardVo.setUserid("sally");
		/***When***/
		int insertCnt = boardDao.insertBoard(sqlSession, boardVo);
		sqlSession.commit();

		/***Then***/
		logger.debug(insertCnt+"");
		assertEquals(insertCnt, 1);
	}
	
	@Test
	public void deleteBoardTest() {
		/***Given***/
		int board_no = 10;
		
		/***When***/
		int deleteCnt = boardDao.deleteBoard(sqlSession, board_no);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_no(2);
		boardVo.setBoard_status("y");
		
		/***When***/
		int updateCnt = boardDao.updateBoard(sqlSession, boardVo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
