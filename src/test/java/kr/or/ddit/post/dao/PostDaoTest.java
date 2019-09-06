package kr.or.ddit.post.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.vo.PostVO;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private IPostDao postDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("PostDaoTestBefore()");
		postDao = PostDaoImpl.getInstance();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		logger.debug("PostDaoTestAfter()");
		sqlSession.close();
	}

	@Test
	public void getPostListTest() {
		/***Given***/
		int board_no = 2;
		int page = 1;
		int page_size = 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_no", board_no);
		map.put("page", page);
		map.put("page_size", page_size);
		
		/***When***/
		List<PostVO> postList = postDao.getpostList(sqlSession, map);

		/***Then***/
		assertEquals(2, postList.size());

	}
	
	@Test
	public void getPostTotalCnt() {
		/***Given***/
		int board_no = 2;
		
		/***When***/
		int postTotalCnt = postDao.getPostTotalCnt(sqlSession, board_no); 

		/***Then***/
		assertEquals(2, postTotalCnt);
	}
	
	@Test
	public void getPostTest() {
		/***Given***/
		PostVO postVo = new PostVO();
		postVo.setBoard_no(2);
		postVo.setPost_no(3);
		
		/***When***/
		PostVO resultPost = postDao.getPost(sqlSession, postVo);

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
		postVo.setPost_gn(1);
		
		/***When***/
		int insertCnt = postDao.insertPost(sqlSession, postVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		PostVO postVo = new PostVO();
		postVo.setPost_no(1);
		postVo.setPost_title("제목수정테스트");
		postVo.setPost_cont("테스트");
		
		/***When***/
		int updateCnt = postDao.updatePost(sqlSession, postVo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		int deleteCnt = postDao.deletePost(sqlSession, post_no);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
