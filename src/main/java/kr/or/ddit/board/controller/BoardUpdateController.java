package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/updateBoard")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateController.class);
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = BoardServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_nm = request.getParameter("board_nm");
		String board_status = request.getParameter("board_status");
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_no(board_no);
		boardVo.setBoard_nm(board_nm);
		boardVo.setBoard_status(board_status);
		
		try {
			int updateCnt = boardService.updateBoard(boardVo);
			response.sendRedirect(request.getContextPath()+"/insertBoard");
		} catch (Exception e) {
			request.getRequestDispatcher(request.getContextPath()+"/insertBoard").forward(request, response);
		}
	}

}
