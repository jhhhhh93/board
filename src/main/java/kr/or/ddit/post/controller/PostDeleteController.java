package kr.or.ddit.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet("/postDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostDeleteController.class);
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = PostServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		int deleteCnt = postService.deletePost(post_no);
		
		response.sendRedirect(request.getContextPath() + "/postList?board_no=" + board_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
