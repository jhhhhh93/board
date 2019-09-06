package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	private IBoardService boardService;
	
	@Before
	public void setup() {
		logger.debug("BoardServiceTestBefore()");
		boardService = BoardServiceImpl.getInstance();
	}

	@Test
	public void getBoardListTest() {
		/***Given***/
		
		/***When***/
		List<BoardVO> boardList = boardService.getBoardList();

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
		int insertCnt = boardService.insertBoard(boardVo);

		/***Then***/
		logger.debug(insertCnt+"");
		assertEquals(insertCnt, 1);
	}
	
	@Test
	public void deleteBoardTest() {
		/***Given***/
		int board_no = 12;
		
		/***When***/
		int deleteCnt = boardService.deleteBoard(board_no);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_no(2);
		boardVo.setBoard_status("n");
		
		/***When***/
		int updateCnt = boardService.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}

}
