package kr.or.ddit.atta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atta.dao.AttaDaoImpl;
import kr.or.ddit.atta.dao.IAttaDao;
import kr.or.ddit.atta.vo.AttaVO;
import kr.or.ddit.util.MybatisUtil;

public class AttaServiceImpl implements IAttaService {
	
	private static IAttaService attaService;
	
	public static IAttaService getInstance() {
		if(attaService == null) {
			attaService = new AttaServiceImpl();
		}
		return attaService;
	}
	
	private IAttaDao attaDao;
	
	private AttaServiceImpl() {
		attaDao = AttaDaoImpl.getInstance();
	}

	@Override
	public List<AttaVO> getAttaList(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<AttaVO> attaList = attaDao.getAttaList(sqlSession, post_no);
		sqlSession.close();
		return attaList;
	}

	@Override
	public int insertAtta(AttaVO attaVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = attaDao.insertAtta(sqlSession, attaVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteAtta(int atta_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = attaDao.deleteAtta(sqlSession, atta_no);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public AttaVO getAtta(int atta_no) {
		SqlSession sqlSession = MybatisUtil.getSession();
		AttaVO attaVo = attaDao.getAtta(sqlSession, atta_no);
		sqlSession.close();
		return attaVo;
	}

}
