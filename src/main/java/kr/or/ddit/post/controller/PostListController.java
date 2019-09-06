package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

@WebServlet("/postList")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostListController.class);
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = PostServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String pageValue = request.getParameter("page");
		String pageSizeValue = request.getParameter("page_size");
		
		int page = pageValue == null ? 1 : Integer.parseInt(pageValue);
		int page_size = pageSizeValue == null ? 10 : Integer.parseInt(pageSizeValue);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_no", board_no);
		map.put("page", page);
		map.put("page_size", page_size);
		
		Map<String, Object> resultMap = postService.getpostList(map, board_no);
		
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("board_no", board_no);
		request.setAttribute("page", page);
		request.setAttribute("page_size", page_size);
		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/jsp/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
