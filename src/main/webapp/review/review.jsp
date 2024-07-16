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
	
	.itemInfo a {
 		 text-decoration: none;
 		 color: inherit;
	}	
	
	.qnaWrite p input[type='number'] {
    	-moz-appearance:textfield;
    	width:15px;
    	text-align:center;
	}
	
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	    -webkit-appearance: none;
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
	
	.qnaContents {
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
	
	.itemInfo {
		padding: 5px 0 15px;
		border-bottom: 1px solid #ddd;
	}
	
	.qnaWrite {
		padding: 15px 0 0;
	}
	
	.itemInfo a img {
		width:25%;
	}
	
	.itemInfo a p {
		width:70%;
		display:inline-block;
	}
	
	.imgArea{
		padding-top: 15px;
	}
	
	.uploadImgArea{
		display:table-cell;
		width:120px;
		height:120px;
		background-color:#dddddd;
	}
	.uploadImg {
		display:table-cell;
		width:120px;
	}
	
	.fileBtnArea {
		 padding-left:5px;
		 width:300px;
		 display:table-cell;
		 vertical-align:bottom; 
	}
	
	.file_control{
		width:300px;
	}
</style>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
function closeModal(){
	$('.modalBack').removeClass("show");
	$('.modalQNA').removeClass("show");
}

function selImg(){
	var input = document.getElementById("filePath");
	var fReader = new FileReader();

	fReader.readAsDataURL(input.files[0]);

	fReader.onloadend = function(event){
	    var img = document.getElementById("uploadImg");
	    img.src = event.target.result;
	    
	}
}

</script>
</head>
<body>
	<div class="modalBack"> </div>
	<div class="modalQNA" >
		<form action="${contextPath}/review/reviewInsert"  method="get">
			<div class="qnaContents">	
				<h1 class="qnaPopupTitle">리뷰 작성</h1>
				<div class="itemInfo" >
					<a  href="#">
						<p class="itemInfoTitle">  </p>
					</a>
				</div>
				<div class="qnaWrite" >
					<p class="qnaModalTitle" id="qnaModalTitle">상품 점수 <input type="number" name="grade"  step="1" min="1" max="5" maxlength="1" required>/ 5</p>
					<div class="qnaText">
						<textarea id="qnaText" name="qnaText" placeholder="솔직한 상품 리뷰를 남겨주세요." required></textarea>
					</div>
					<div class="imgArea" >
						<div class="uploadImgArea" >
							<img id="uploadImg"  class="uploadImg"  src=""  alt="이미지 선택">
						</div>
						<div class="fileBtnArea">
							<input type="file" id="filePath" name="filePath" class="file_control"  onchange="selImg()" >
						</div>
						
					</div>	 
					<div class="btnGroup">
						<input type="hidden" id="item_idx" name="item_idx" value="">
						<button type="button"  onclick="closeModal()">취소</button>
						<button type="submit" >등록</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>