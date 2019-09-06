package kr.or.ddit.common.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ContextPathServlet
 */
@WebServlet(urlPatterns = "/contextPathInit", loadOnStartup = 1)
public class ContextPathInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ContextPathInitServlet.class);
       
	@Override
		public void init(ServletConfig config) throws ServletException {
			ServletContext application = config.getServletContext();
			String contextPath = application.getContextPath();
			
			application.setAttribute("cp", contextPath);
			logger.debug("ContextPathInitServlet init() : {}", application.getContextPath()); 
		}
}
