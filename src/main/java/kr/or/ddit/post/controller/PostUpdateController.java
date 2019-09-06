package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.service.AttaServiceImpl;
import kr.or.ddit.atta.service.IAttaService;
import kr.or.ddit.atta.vo.AttaVO;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostUpdateController.class);
	private IPostService postService;
	private IAttaService attaService;
	
	@Override
	public void init() throws ServletException {
		postService = PostServiceImpl.getInstance();
		attaService = AttaServiceImpl.getInstance();
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
		
		request.getRequestDispatcher("/jsp/postUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		String post_title = request.getParameter("post_title");
		String post_cont = request.getParameter("post_cont");
		
		PostVO postVo = new PostVO();
		postVo.setPost_no(post_no);
		postVo.setPost_title(post_title);
		postVo.setPost_cont(post_cont);
		
		int updateCnt = postService.updatePost(postVo);
		
		List<Part> parts = (List<Part>) request.getParts();
		
		
		for(Part part : parts) {
			if(part.getName().equals("atta")) {
				String atta_nm = "";
				String atta_path = "";
				if(part.getSize() > 0) {
					atta_nm = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
					String realfilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));
					atta_path = FileuploadUtil.getPath() + realfilename + ext;
					part.write(atta_path);
					
					AttaVO attaVo = new AttaVO();
					attaVo.setAtta_nm(atta_nm);
					attaVo.setAtta_path(atta_path);
					attaVo.setPost_no(post_no);
					int atinsertCnt = attaService.insertAtta(attaVo);
				}
				
				
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/post?board_no=" + board_no + "&post_no=" + post_no);
		
	}

}
