package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.MybatisUtil;

public class BoardServiceImpl implements IBoardService {
	
	private static IBoardService boardService;
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	private IBoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}

	@Override
	public List<BoardVO> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<BoardVO> boardList = boardDao.getBoardList(sqlSession);
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = boardDao.insertBoard(sqlSession, boardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteBoard(int board_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = boardDao.deleteBoard(sqlSession, board_no);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = boardDao.updateBoard(sqlSession, boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}
