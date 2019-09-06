package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.vo.PostVO;

public class PostServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	private IPostService postService;
	
	@Before
	public void setup() {
		logger.debug("PostServiceTestBefore()");
		postService = PostServiceImpl.getInstance();
	}

	@Test
	public void getpostListTest() {
		/***Given***/
		int board_no = 2;
		int page = 1;
		int page_size = 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_no", board_no);
		map.put("page", page);
		map.put("page_size", page_size);
		
		/***When***/
		Map<String, Object> resultMap = postService.getpostList(map, board_no);
		
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");
		int paginationSize = (int) resultMap.get("paginationSize");

		/***Then***/
		assertEquals(2, postList.size());
		assertEquals(1, paginationSize);
	}
	
	@Test
	public void getPost() {
		/***Given***/
		PostVO postVo = new PostVO();
		postVo.setBoard_no(2);
		postVo.setPost_no(3);
		
		/***When***/
		PostVO resultPost = postService.getPost(postVo);

		/***Then***/
		assertEquals(1, resultPost.getPost_gn());
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVO postVo = new PostVO();
		postVo.setBoard_no(2);
		postVo.setPost_title("추가테스트제목");
		postVo.setPost_cont("추가테스트내용");
		postVo.setPost_status("y");
		postVo.setUserid("sally");
//		postVo.setPost_gn(1);
		
		/***When***/
		int post_no = postService.insertPost(postVo);

		/***Then***/
		assertEquals(1, post_no);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		PostVO postVo = new PostVO();
		postVo.setPost_no(1);
		postVo.setPost_title("제목수정테스트");
		postVo.setPost_cont("테스트");
		
		/***When***/
		int updateCnt = postService.updatePost(postVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		int deleteCnt = postService.deletePost(post_no);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
