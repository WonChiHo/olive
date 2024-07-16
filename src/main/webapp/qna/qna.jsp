<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	.btnGroup button{
		cursor: pointer;
		border:0;
	}
	.modalQNA {
	    width: 650px;
	    position:absolute;
	    z-index: 999;
	    top: 200px;
	    left: 50%;
	   	margin: 0px 0 0 -325px;
	    display: none;
		background-color: white;
		border-radius: 10px;
	}
	
	.modalQNA.show {
		display: block;	
	}
	
	.modalBack{
		position: fixed;
		background-color: black;
		opacity: 0.4;
		top:0;
		left:0;
		z-index:990;
		width: 100%;
		height: 100%;
		display: none;
	}
	
	.modalBack.show{
		display: block;
	}
	
	.qnaModalContents {
		padding: 0 30px 30px;
	}
	.qnaText {
		width: 100%;
	    margin: 20px 0 0;
	    padding: 10px;
	    border-radius: 5px;
	    border: 1px solid #d0d0d0;
	}
	
	.qnaText textarea {
		width: 100%;
		height: 170px;
		resize: none;
		border: 0;
		outline: none;
	}
	
	
	.qnaPopupTitle{
		padding: 30px 0 15px;
	    border-bottom: 2px solid #000;
	    line-height: 30px;
	}
	
	.btnGroup {
		display: flex;
	    margin-top: 20px;
	    padding-top: 30px;
	    border-top: 1px solid #ddd;
	    justify-content: center;
	}
	
	.btnGroup button {
		width: 100px;
	    height: 38px;
	    margin: 0 3px 0 2px;
	    font-size: 14px;
	}
</style>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
function closeModal(){
	$('.modalBack').removeClass("show");
	$('.modalQNA').removeClass("show");
	$('#qnaText').val("");
	$('#qnaIdx').val("");
}

function selInsertUpdate(){
	if($("#qnaIdx").val() == ""){
		document.location="${contextPath}/qna/qnaInsert?itemIdx="+$("#itemIdx").val()+"&qnaContent="+$("#qnaText").val();
	}else{
		document.location="${contextPath}/qna/qnaUpdate?qnaIdx="+$("#qnaIdx").val()+"&qnaContent="+$("#qnaText").val()+"&itemIdx="+$("#itemIdx").val();
	}	
}

</script>
</head>
<body>
	<div class="modalBack"> </div>
	<div class="modalQNA" >
		<div class="qnaModalContents">
			<h1 class="qnaPopupTitle">상품 Q&A 작성</h1>
			<div class="qnaWrite">
				<p class="qnaModalTitle" id="qnaModalTitle">${item.title}</p>
				<div class="qnaText">
					<textarea id="qnaText" name="qnaText" placeholder="문의 내용을 입력해주세요."></textarea>
				</div>
				<div class="btnGroup">
					<input type="hidden" id="qnaIdx"  value="">
					<input type="hidden" id="itemIdx"  value="${item.idx}">
					<button type="button"  onclick="closeModal()">취소</button>
					<button type="button" onclick="selInsertUpdate()">등록</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>