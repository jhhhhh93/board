package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;

/**
 * Servlet implementation class ReplyDeleteController
 */
@WebServlet("/deleteReply")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(ReplyDeleteController.class);
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = ReplyServiceImpl.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		int deleteCnt = replyService.deleteReply(reply_no);
		
		response.sendRedirect(request.getContextPath()+"/post?post_no=" + post_no + "&board_no=" + board_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
