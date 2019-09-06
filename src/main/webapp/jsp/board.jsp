<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-Main-basicLib</title>

<%@include file="/commonJsp/basicLib.jsp" %>

<style>
	.postTr:hover{
		background : lime;
	}
</style>

<script>
	$(function(){
		$(".postTr").on("click", function(){
			var userid = "${userid}";
			if(userid == ""){
				alert("로그인이 필요합니다.")
				return false;
			}
			var post_no = $(this).children().eq(0).text();
			var board_no = $(this).children().eq(1).text();
			
			$("#post_no").val(post_no);
			$("#board_no").val(board_no);
			
			$("#getPost").submit();
		})
		
		$("#insertPost").on("click", function(){
			var userid = "${userid}";
			if(userid == ""){
				alert("로그인이 필요합니다.")
				return false;
			}
			$("#insertPostForm").submit();
		})
	})
</script>
</head>

<body>
	
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/commonJsp/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<form id="getPost" action="${cp }/post" method="get">
					<input id="post_no" type="hidden" name="post_no">
					<input id="board_no" type="hidden" name="board_no">
				</form>
				
				<table class="table table-bordered">
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>작성자 아이디</th>
						<th>작성일시</th>
					</tr>
					
					<c:forEach items="${postList }" var="post">
						<c:choose>
							<c:when test="${post.post_status == 'n'}">
								<tr class="deleteTr">
									<td>${post.post_no}</td>
									<td style="display:none;">${post.board_no }</td>
									<td>
										<c:forEach begin="0" end="${post.level}" var="i">
											<c:if test="${i > 0}">
												&nbsp;&nbsp;&nbsp;
											</c:if>
										</c:forEach>
										<c:if test="${post.level > 0}">
											<span class="glyphicon glyphicon-chevron-down"></span>
										</c:if>
										삭제된 게시물 입니다.
									</td>
									<td>${post.userid}</td>
									<td>${post.post_date_fmt}</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="postTr">
									<td>${post.post_no}</td>
									<td style="display:none;">${post.board_no }</td>
									<td>
										<c:forEach begin="0" end="${post.level}" var="i">
											<c:if test="${i > 0}">
												&nbsp;&nbsp;&nbsp;
											</c:if>
										</c:forEach>
										<c:if test="${post.level > 0}">
											<span class="glyphicon glyphicon-chevron-down"></span>
										</c:if>
										${post.post_title}
									</td>
									<td>${post.userid}</td>
									<td>${post.post_date_fmt}</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
				
				<button id="insertPost" type="button" class="btn btn-default pull-right">새글 등록</button>
				<form id="insertPostForm" action="${cp}/insertPost" method="get">
					<input type="hidden" name="board_no" value="${board_no}">
				</form>
<%-- 				<a href="${cp}/insertPost?board_no=${board_no}" class="btn btn-default pull-right">새글 등록</a> --%>

				<div class="text-center">
					<ul class="pagination">
						<c:choose>
							<c:when test="${page == 1}">
								<li class="disabled">
								    <a href="#" aria-label="Previous">
								    	<span aria-hidden="true">&laquo;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postList?page=1&page_size=10&board_no=${board_no}" aria-label="Previous">
								    	<span aria-hidden="true">&laquo;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${page == 1}">
								<li class="disabled">
								    <a href="#" aria-label="Previous">
								    	<span aria-hidden="true">&lt;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postList?page=${page-1}&page_size=10&board_no=${board_no}" aria-label="Previous">
								    	<span aria-hidden="true">&lt;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						
					    
						<c:forEach begin="1" end="${paginationSize}" var="selectpage">
							<c:choose>
								<c:when test="${selectpage == page }">
									<li class="active"><span>${selectpage}</span></li>
								</c:when>
								<c:otherwise>
									<li><a href="${cp}/postList?page=${selectpage}&page_size=10&board_no=${board_no}">${selectpage}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${page == paginationSize}">
								<li class="disabled">
								    <a href="#" aria-label="Next">
								    	<span aria-hidden="true">&gt;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postList?page=${page+1}&page_size=10&board_no=${board_no}" aria-label="Next">
								    	<span aria-hidden="true">&gt;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${page == paginationSize}">
								<li class="disabled">
								    <a href="#" aria-label="Next">
								    	<span aria-hidden="true">&raquo;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postList?page=${paginationSize}&page_size=10&board_no=${board_no}" aria-label="Next">
								    	<span aria-hidden="true">&raquo;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
