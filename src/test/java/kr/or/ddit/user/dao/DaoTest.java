package kr.or.ddit.user.dao;


import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.MybatisUtil;

public class DaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);
	private IUserDao userDao;
	private SqlSession sqlSession;
	
	// 테스트에 공통적으로 필요한 자원을 생성/ 초기화
	   @Before
	   public void setup() {
	      logger.debug("UserDaoTestBefore()");
	      userDao = UserDaoImpl.getInstance();
	      sqlSession = MybatisUtil.getSession();
	      
	   }
	   
	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("UserDaoTestAfter()");
	      sqlSession.close();
	   }

	@Test
	public void loginTest() {
		/***Given***/
		UserVO userVo = new UserVO();
		
		String userid = "brown";
		String pass = "c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44";
		
		userVo.setUserid(userid);
		userVo.setPass(pass);
		
		/***When***/
		UserVO loginUser = userDao.login(sqlSession, userVo);

		/***Then***/
		assertEquals("brown", loginUser.getUserid());
	}

}
