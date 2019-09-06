package kr.or.ddit.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.vo.UserVO;

public class UserDaoImpl implements IUserDao {
	
	private static IUserDao userDao;
	
	public static IUserDao getInstance() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
	
	private UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserVO login(SqlSession sqlSession, UserVO userVo) {
		return sqlSession.selectOne("user.login", userVo);
	}


}
