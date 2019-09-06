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
<script>
	$(function(){
		var post_no = "${post.post_no}";
		var board_no = "${post.board_no}";
		var post_gn = "${post.post_gn}";
		$("#post_no").val(post_no);
		$("#board_no").val(board_no);
		$("#post_gn").val(post_gn);
		
		$("#updatePost").on("click", function(){
			$("#postForm").prop("action", "${cp}/postUpdate");
			
			$("#postForm").submit();
		})
		
		$("#deletePost").on("click", function(){
			$("#postForm").prop("action", "${cp}/postDelete");
			
			$("#postForm").submit();
		})
		
		$("#rePost").on("click", function(){
			$("#postForm").prop("action", "${cp}/insertPost");
			
			$("#postForm").submit();
		})
		
		$("#replyInsert").on("click", function(){
			$("#postForm").prop("action", "${cp}/insertReply");
			var reply_cont = $("#textarea").val();
			$("#reply_cont").val(reply_cont);
			
			$("#postForm").submit();
		})
		
		// textarea 글자수 제한
		$('#textarea').on("keyup", function(){
			var content = $(this).val();
			$('#counter').html("(" + content.length + " / 최대 500자)"); //글자수 실시간 카운팅

			if (content.length > 500) {
				alert("최대 500자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 500));
				$('#counter').html("(500 / 최대 500자)");
			}
		});
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
				<form id="postForm" action="" method="get">
					<input id="post_no" type="hidden" name="post_no">
					<input id="board_no" type="hidden" name="board_no">
					<input id="post_gn" type="hidden" name="post_gn">
					<input id="reply_cont" type="hidden" name="reply_cont">
				</form>
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${post.post_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${post.post_cont}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div id="atta" class="col-sm-10">
							<c:forEach items="${attaList}" var="atta">
								<label class="control-label">${atta.atta_nm}</label>
								<a href="${cp}/attaDownload?atta_no=${atta.atta_no}" download="${atta.atta_nm}">
									<span class="glyphicon glyphicon-download-alt"></span>
								</a>
								<br>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${userid == post.userid}">
								<button type="button" id="updatePost" class="btn btn-default">수정</button>
								<button type="button" id="deletePost" class="btn btn-default">삭제</button>
							</c:if>
							<button type="button" id="rePost" class="btn btn-default">답글</button>
						</div>
					</div>
					
					<div class="form-group" style="background:#fefefe; border:1px solid black; padding:5px;">
						<label for="pass" class="col-sm-2 control-label">댓글</label>
						<div id="reply" class="col-sm-10">
							<c:forEach items="${replyList}" var="reply">
								<c:choose>
									<c:when test="${reply.reply_status == 'n'}">
										<label class="control-label">삭제된 댓글입니다.</label>
									</c:when>
									<c:otherwise>
										<label class="control-label">${reply.reply_cont}</label>
									</c:otherwise>
								</c:choose>
								<label class="control-label">[${reply.userid} / ${reply.reply_date_fmt}]</label>
								<c:if test="${userid == reply.userid && reply.reply_status == 'y'}">
									<a href="${cp}/deleteReply?reply_no=${reply.reply_no}&post_no=${reply.post_no}&board_no=${post.board_no}">
							        	<span class="glyphicon glyphicon-remove"></span>
							        </a>
								</c:if>
								<br>
							</c:forEach>
							<textarea id="textarea" rows="3" cols="50"></textarea>
							<span style="color:#aaa;" id="counter">(0 / 최대 500자)</span>

							<button type="button" id="replyInsert" class="btn btn-default" style="vertical-align:top;">댓글 저장</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>
