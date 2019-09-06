<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp}/js/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$.ajax({
			url : "/boardList",
			dataType : 'json',
			success : function(datas){
				var code = "";
				$(datas).each(function(i,v){
					if(v.board_status == "y"){
						code += '<li class="active"><a href="' + "${cp}/postList?board_no="+ v.board_no + '">' + v.board_nm + '<span class="sr-only">(current)</span></a></li>';
					}
				})
				$("#ultag").append(code);
			},
			error : function(xhr){
				alert(xhr.status);
			}
		})
	})
</script>
</head>
<body>
	<form id="frm" action="${cp }/boardList" method="get"></form>
	<ul id="ultag" class="nav nav-sidebar">
		<li class="active"><a href="${cp }/insertBoard">게시판생성<span class="sr-only">(current)</span></a></li>
	</ul>
</body>
</html>