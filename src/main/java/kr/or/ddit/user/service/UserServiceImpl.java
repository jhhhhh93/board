package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.MybatisUtil;

public class UserServiceImpl implements IUserService {
	
	private static IUserService userService;
	
	public static IUserService getInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
	private IUserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	

	@Override
	public UserVO login(UserVO userVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		UserVO loginUser = userDao.login(sqlSession, userVo);
		sqlSession.close();
		return loginUser;
	}

}
