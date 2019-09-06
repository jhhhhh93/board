package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.UserVO;

public class ServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	private IUserService userService;
	
	@Before
	public void setup() {
		logger.debug("UserServiceTest Before()");
		userService = UserServiceImpl.getInstance();
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
		UserVO loginUser = userService.login(userVo);

		/***Then***/
		assertEquals("brown", loginUser.getUserid());
	}
	
	


}
