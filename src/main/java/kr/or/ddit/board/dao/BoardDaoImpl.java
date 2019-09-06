package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	
	private static IBoardDao boardDao;
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	private BoardDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BoardVO> getBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("board.getBoardList");
	}

	@Override
	public int insertBoard(SqlSession sqlSession, BoardVO boardVo) {
		return sqlSession.insert("board.insertBoard", boardVo);
	}

	@Override
	public int deleteBoard(SqlSession sqlSession, int board_no) {
		return sqlSession.delete("board.deleteBoard", board_no);
	}

	@Override
	public int updateBoard(SqlSession sqlSession, BoardVO boardVo) {
		return sqlSession.update("board.updateBoard", boardVo);
	}

}
