<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<% 
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList"); 
		for(int i = 0; i < list.size(); i++){
			BoardVO boardVo = list.get(i);
			if(i > 0){ out.print(","); }
	%>
		{
			"board_no" : "<%=boardVo.getBoard_no() %>",
			"board_nm" : "<%=boardVo.getBoard_nm() %>",
			"board_date" : "<%=boardVo.getBoard_date() %>",
			"board_status" : "<%=boardVo.getBoard_status() %>",
			"board_user_id" : "<%=boardVo.getUserid() %>"
		}
	<%} %>
]