package kr.or.ddit.atta.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.service.AttaServiceImpl;
import kr.or.ddit.atta.service.IAttaService;
import kr.or.ddit.atta.vo.AttaVO;

/**
 * Servlet implementation class AttaDownloadController
 */
@WebServlet("/attaDownload")
public class AttaDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(AttaDownloadController.class);
	private IAttaService attaService;
	
	@Override
	public void init() throws ServletException {
		attaService = AttaServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int atta_no = Integer.parseInt(request.getParameter("atta_no"));
		
		AttaVO attaVo = attaService.getAtta(atta_no);
		
		String atta_path = attaVo.getAtta_path();
		
		ServletOutputStream sos = response.getOutputStream();
		
		File file = new File(atta_path);
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff,0,512)) != -1) {
			sos.write(buff, 0, len);
		}
		
		fis.close();
	}
}
