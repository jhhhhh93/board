package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.vo.PostVO;

public class PostDaoImpl implements IPostDao {
	
	private static IPostDao postDao;
	
	public static IPostDao getInstance() {
		if(postDao == null) {
			postDao = new PostDaoImpl();
		}
		return postDao;
	}
	
	private PostDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PostVO> getpostList(SqlSession sqlSession, Map<String, Integer> map) {
		return sqlSession.selectList("post.getpostList", map);
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int board_no) {
		return sqlSession.selectOne("post.getPostTotalCnt", board_no);
	}

	@Override
	public int insertPost(SqlSession sqlSession, PostVO postVo) {
		return sqlSession.insert("post.insertPost", postVo);
	}

	@Override
	public PostVO getPost(SqlSession sqlSession, PostVO postVo) {
		return sqlSession.selectOne("post.getPost", postVo);
	}

	@Override
	public int updatePost(SqlSession sqlSession, PostVO postVo) {
		return sqlSession.update("post.updatePost", postVo);
	}

	@Override
	public int deletePost(SqlSession sqlSession, int post_no) {
		return sqlSession.update("post.deletePost", post_no);
	}

}
