package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.UserVO;
import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = UserServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		UserVO userVo = new UserVO();
		userVo.setUserid(userid);
		userVo.setPass(pass);
		
		UserVO loginUser = userService.login(userVo);
		
		request.setAttribute("loginUser", loginUser);
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", loginUser.getUserid());
		
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}

}
