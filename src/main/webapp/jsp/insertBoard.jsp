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
		$("#insertBtn").on("click", function(){
			var board_nm = $(this).parent().siblings().find($(".board_nm")).val();
			var board_status = $(this).parent().siblings().find($(".board_status")).val();
			
			if(board_nm == ""){
				alert("게시판 이름을 입력해주세요.");
				return false;
			}
			
			$("#insert .board_nm").val(board_nm);
			$("#insert .board_status").val(board_status);
			
			$("#insert").submit();
		})
		$(".modify").on("click", function(){
			var board_nm = $(this).parent().siblings().find($(".board_nm")).val();
			var board_no = $(this).parent().siblings().find($(".board_no")).val();
			var board_status = $(this).parent().siblings().find($(".board_status")).val();
			
			$("#update .board_no").val(board_no);
			$("#update .board_nm").val(board_nm);
			$("#update .board_status").val(board_status);
			
			$("#update").submit();
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
			
				<form id="insert" action="${cp }/insertBoard" method="post">
					<input class="board_no" type="hidden" name="board_no">
					<input class="board_nm" type="hidden" name="board_nm">
					<input class="board_status" type="hidden" name="board_status">
				</form>
				<form id="update" action="${cp }/updateBoard" method="post">
					<input class="board_no" type="hidden" name="board_no">
					<input class="board_nm" type="hidden" name="board_nm">
					<input class="board_status" type="hidden" name="board_status">
				</form>
				
				<table class="table table-bordered">
					<tr>
						<td style="text-align:center;"><label class="col-sm control-label">게시판 이름</label></td>
						<td>
							<input type="text" class="form-control board_nm">
						</td>
						<td>
							<select class="form-control board_status">
									<option value="y" selected>사용</option>
									<option value="n">미사용</option>
							</select>
						</td>
						<td><button id="insertBtn" type="button" class="btn btn-info">생성</button></td>
					</tr>
					<c:forEach items="${boardList }" var="v">
						<tr>
							<td style="text-align:center;"><label class="col-sm control-label">게시판 이름</label></td>
							<td>
								<input type="text" class="form-control board_nm" value="${v.board_nm}">
								<input type="hidden" class="form-control board_no" value="${v.board_no}">
							</td>
							<td>
								<select class="form-control board_status">
									<c:choose>
										<c:when test="${v.board_status == 'y'}">
											<option value="y" selected>사용</option>
											<option value="n">미사용</option>
										</c:when>
										<c:otherwise>
											<option value="y">사용</option>
											<option value="n" selected>미사용</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
							<td><button type="button" class="btn btn-success modify">수정</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
