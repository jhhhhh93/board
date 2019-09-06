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
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script>
	var fileSizeCheck = true;

	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
	
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});
	
		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	
				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#post_cont").val($("#smarteditor").val());
					
					if(fileSizeCheck){
						$("#postUpdateForm").submit();
					}else{
						alert("첨부파일 갯수는 최대 5개까지 입니다.");
					}
					
					
				}
			}
		})
		
		// 필수값 Check
		function validation(){
			var contents = $.trim(oEditors[0].getContents());
			if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
				alert("내용을 입력하세요.");
				oEditors.getById['smarteditor'].exec('FOCUS');
				return false;
			}
		
			return true;
		}
		
		$("input[type=file]").change(function () {
			fileSizeCheck = true;
			
            var fileInput = document.getElementById("atta");
              
            var files = fileInput.files;
            
            var count = (files.length + ${attaList.size()});
            
			$('#counter').html("첨부파일 갯수:" + count + " / 최대 5개"); //글자수 실시간 카운팅


            if(count > 5){
            	alert("최대5개")
//             	alert("최대 5개 까지 첨부할 수 있습니다.");
//             	$("#atta").val("");
//             	var length = 0; 
//             	$('#counter').html("첨부파일 갯수:" + length + " / 최대 5개");
            	fileSizeCheck = false;
            }
        });
		
	});
	
	
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
				<form id="postUpdateForm"class="form-horizontal" role="form" action="${cp}/postUpdate" method="post" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="post_title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="hidden" value="${post.post_no}" name="post_no">
							<input type="hidden" value="${post.board_no}" name="board_no">
							<input type="text" class="form-control" id="post_title" name="post_title"
								placeholder="제목" value="${post.post_title}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="post_cont" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<textarea name="post_cont" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">
								${post.post_cont}
							</textarea> 
							<input type="hidden" name="post_cont" id="post_cont">
						</div>
					</div>
					
					<div class="form-group">
						<label for="atta" class="col-sm-2 control-label">첨부파일</label>
						<div id="attadiv" class="col-sm-10">
							<c:forEach items="${attaList}" var="atta">
								<label class="control-label">${atta.atta_nm}</label>
								<a href="${cp}/attaDelete?post_no=${post.post_no}&board_no=${post.board_no}&atta_no=${atta.atta_no}">
						        	<span class="glyphicon glyphicon-remove"></span>
						        </a>
						        <br>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<label for="picture" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="atta" name="atta" 
								placeholder="첨부파일" maxlength="5" multiple="multiple">
							<span style="color:#aaa;" id="counter">첨부파일 갯수 : ${attaList.size()} / 최대 5개</span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="savebutton" class="btn btn-default">저장</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
