package kr.or.ddit.atta.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atta.vo.AttaVO;

public class AttaServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AttaServiceTest.class);
	private IAttaService attaService;
	
	@Before
	public void setup() {
		attaService = AttaServiceImpl.getInstance();
	}

	@Test
	public void getAttaListTest() {
		/***Given***/
		int post_no = 1;
		
		/***When***/
		List<AttaVO> attaList = attaService.getAttaList(post_no);
		
		/***Then***/
		assertEquals(1, attaList.size());
	}
	
	@Test
	public void insertAttaTest() {
		/***Given***/
		AttaVO attaVo = new AttaVO();
		attaVo.setAtta_nm("첨부파일추가테스트");
		attaVo.setAtta_path("첨부파일경로추가테스트");
//		attaVo.setPost_no(1);
		
		/***When***/
		int insertCnt = attaService.insertAtta(attaVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttaTest() {
		/***Given***/
		int atta_no = 3;
		
		/***When***/
		int deleteCnt = attaService.deleteAtta(atta_no);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getAttaTest() {
		/***Given***/
		int atta_no = 5;
		
		/***When***/
		AttaVO attaVo = attaService.getAtta(atta_no);

		/***Then***/
		assertEquals("brown.png", attaVo.getAtta_nm());
	}

}
