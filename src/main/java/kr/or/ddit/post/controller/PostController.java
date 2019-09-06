package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.service.AttaServiceImpl;
import kr.or.ddit.atta.service.IAttaService;
import kr.or.ddit.atta.vo.AttaVO;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;
import kr.or.ddit.reply.vo.ReplyVO;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	private IPostService postService;
	private IAttaService attaService;
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		postService = PostServiceImpl.getInstance();
		attaService = AttaServiceImpl.getInstance();
		replyService = ReplyServiceImpl.getInstance();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		PostVO postVo = new PostVO();
		postVo.setPost_no(post_no);
		postVo.setBoard_no(board_no);
		
		PostVO resultPost = postService.getPost(postVo);
		
		request.setAttribute("post", resultPost);
		
		List<AttaVO> attaList = attaService.getAttaList(post_no);
		
		request.setAttribute("attaList", attaList);
		
		List<ReplyVO> replyList = replyService.getReplyList(post_no);
		
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("/jsp/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
