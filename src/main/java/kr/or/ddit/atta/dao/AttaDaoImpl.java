package kr.or.ddit.atta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atta.vo.AttaVO;

public class AttaDaoImpl implements IAttaDao {
	
	private static IAttaDao attaDao;
	
	public static IAttaDao getInstance() {
		if(attaDao == null) {
			attaDao = new AttaDaoImpl();
		}
		return attaDao;
	}
	
	private AttaDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AttaVO> getAttaList(SqlSession sqlSession, int post_no) {
		return sqlSession.selectList("atta.getAttaList", post_no);
	}

	@Override
	public int insertAtta(SqlSession sqlSession, AttaVO attaVo) {
		return sqlSession.insert("atta.insertAtta", attaVo);
	}

	@Override
	public int deleteAtta(SqlSession sqlSession, int atta_no) {
		return sqlSession.delete("atta.deleteAtta", atta_no);
	}

	@Override
	public AttaVO getAtta(SqlSession sqlSession, int atta_no) {
		return sqlSession.selectOne("atta.getAtta", atta_no);
	}

}
