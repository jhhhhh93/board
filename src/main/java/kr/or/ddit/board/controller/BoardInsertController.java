package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class InsertBoardController
 */
@WebServlet("/insertBoard")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardInsertController.class);
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = BoardServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardVO> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/jsp/insertBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_nm = request.getParameter("board_nm");
		String board_status = request.getParameter("board_status");
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		logger.debug("userid : {}", userid);
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_nm(board_nm);
		boardVo.setBoard_status(board_status);
		boardVo.setUserid(userid);
		
		try {
			int insertCnt = boardService.insertBoard(boardVo);
			response.sendRedirect(request.getContextPath()+"/insertBoard");
		} catch (Exception e) {
			doGet(request, response);
		}
		
	}

}
