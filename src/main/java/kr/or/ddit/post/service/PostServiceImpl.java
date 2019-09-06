package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atta.dao.AttaDaoImpl;
import kr.or.ddit.atta.dao.IAttaDao;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.vo.PostVO;
import kr.or.ddit.util.MybatisUtil;

public class PostServiceImpl implements IPostService {
	
	private static IPostService postService;
	
	public static IPostService getInstance() {
		if(postService == null) {
			postService = new PostServiceImpl();
		}
		return postService;
	}
	
	private IPostDao postDao;
	
	private PostServiceImpl() {
		postDao = PostDaoImpl.getInstance();
	}

	@Override
	public Map<String, Object> getpostList(Map<String, Integer> map, int board_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<PostVO> postList = postDao.getpostList(sqlSession, map);
		int postTotalCnt = postDao.getPostTotalCnt(sqlSession, board_no);
		sqlSession.close();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", postList);
		resultMap.put("paginationSize", (int) Math.ceil((double)postTotalCnt/map.get("page_size")));
		
		return resultMap;
	}

	@Override
	public PostVO getPost(PostVO postVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		PostVO resultPost = postDao.getPost(sqlSession, postVo);
		sqlSession.close();
		return resultPost;
	}

	@Override
	public int updatePost(PostVO postVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = postDao.updatePost(sqlSession, postVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deletePost(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = postDao.deletePost(sqlSession, post_no);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int insertPost(PostVO postVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		postDao.insertPost(sqlSession, postVo);
		int post_no = postVo.getPost_no();
		sqlSession.commit();
		sqlSession.close();
		return post_no;
	}

}
