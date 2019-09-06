package kr.or.ddit.atta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.service.AttaServiceImpl;
import kr.or.ddit.atta.service.IAttaService;

/**
 * Servlet implementation class AttaDeleteController
 */
@WebServlet("/attaDelete")
public class AttaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(AttaDeleteController.class);
	private IAttaService attaService;
	
	@Override
	public void init() throws ServletException {
		attaService = AttaServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int atta_no = Integer.parseInt(request.getParameter("atta_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		int deleteCnt = attaService.deleteAtta(atta_no);
		
		response.sendRedirect(request.getContextPath()+"/postUpdate?post_no=" + post_no + "&board_no=" + board_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
