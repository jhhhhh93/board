package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;
import kr.or.ddit.reply.vo.ReplyVO;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/insertReply")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyInsertController.class);
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = ReplyServiceImpl.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply_cont = request.getParameter("reply_cont");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no")); 
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		ReplyVO replyVo = new ReplyVO();
		replyVo.setReply_cont(reply_cont);
		replyVo.setPost_no(post_no);
		replyVo.setUserid(userid);
		
		int insertCnt = replyService.insertReply(replyVo);
		
		response.sendRedirect(request.getContextPath()+"/post?post_no=" + post_no + "&board_no=" + board_no);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
