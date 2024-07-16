<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olive?ung 상품 상세</title>
<style type="text/css">
		* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		}
		ol, ul {
    		list-style: none;
		}
		
		.qnqTitleTx a {
 		 	text-decoration: none;
 		 	color: inherit;
		}	
	
		
		.btnMP {
			cursor: pointer;
			border: 1px solid;
		}
		
		#c_container {
			width: 100%;
			margin:0 auto; 
			min-width: 1020px;
		}

		.item_detail_area {
			width: 1020px;
			margin:0 auto; 
			text-align: center;
		}

		.item_detail_box .left_area {
    		width: 510px;
    		padding-top: 5px;
    		float:left;
		}
		
		.item_detail_box .right_area {
			padding: 35px 15px 15px;
    		width: 510px;
    		height: 510px;
    		text-align:left;
    		float:right;
		}
	
		.item_detail_box:after {
		   	content: "";
		    display: block;
		    clear: both;
		}
		
		.item_img {
			width: 510px;
    		height: 510px;
    		text-align: center;
		}
		
		
		.item_detail_box .item_img img {
			max-width: 510px;
   			 max-height: 510px;
		}
		
		.tab_detail img {
			width: 100%;
			max-width: 1020px;
		}
		
		.item_detail_tab {
			height: 50px;
    		margin: 30px 0 0;
		}
		
		.item_detail_tab:after {
			content: "";
			position: absolute;
			left:50%;
			margin: 50px 0 0 -50%;
			z-index:-1;
			width:100%;
			border: 1px solid #9bce26;
		    display: block;
		    clear: both;
		}
		
		.item_detail_tab li {
			float: left;
   			width: 33.3333%;
	
		}
		
		.item_detail_tab li a {
			display: block;
		    height: 50px;
		    text-align: center;
		    font-size: 16px;
		    color: #aaa;
		    background: #f5f5f5;
		    padding: 17px 0 0;
		    font-weight: 700;
		    text-decoration: none;
		}
		
		.item_detail_tab li.on a {
			border: 2px solid #9bce26;
	   		height: 51px;
	   		border-bottom: 0;
	    	color: #333;
	   		padding: 15px 0 0;
   			background: #fff;
		}
		 
		.tab_contents {
			    padding: 30px 0 0;
			    display: none;
		}
		
		.tab_contents.show {
			    padding: 30px 0 0;
			    display: block;
		}
		
		
		.btnCart {
			color:white;
			background-color:#ff5555;
			border:0;
			font-size:20px;
			width: 100px;
			height: 50px;
		}
		
		.btnBuy {
			color:white;
			background-color:#ff5555;
			border:0;
			font-size:20px;
			width: 100px;
			height: 50px;
		}
		
		.btnSoldout {
			color:white;
			background-color:lightgray;
			border: 2px solid gray;
			border-radius: 5px;
			font-size:20px;
			width: 100px;
			height: 50px;
		}
		
		.userId {
			font-weight:bold;
			float:left;
			font-size:20px;
			font-weight:bold;
			width:200px;
			height:50px;
			padding: 10px 10px 0;
		}
		
		.reviewContents {
			min-height:200px;
			padding: 10px 10px 0;
			margin-left: 200px;
		}
		
		reviewList_container li {
			
		}
	 	
		reviewList_container li:after {
		   	content: "";
		    display: block;
		    clear: both;
		}
		
		.qnaList li .qnaContents {
			display: none;
		}
		
		.qnaList li.show .qnaContents {
			display: block;
		}
		
		.qnaTitle {
			border-bottom: 1px solid lightgray;
		}
		
		.qnqTitleTx {
			text-align:left;
			vertical-align: middle; 
			display: table-cell;
			width:765px;
		}
		
		.qnqTitleTx a {
			display: inline-block;
		    max-width: 620px;
		    margin-left: 7px;
		    font-size: 16px;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		    vertical-align: middle;
		}
	  
		.btnQNA {
			padding: 0 0 10px;
			border-bottom: 5px solid lightgray;
			text-align:right;
		}
		
		.qnaIcon {
			font-size: 12px;
			width:70px;
			color:white;
			text-align:center;
			display:inline-block;
			background-color: gray;
			border-radius: 10px;
		}
		
		.qnaIcon.answer {
			background-color: #55cc55;
		}
		
		
		.qnaID {
			
		}
		
		.user_Id {
			padding: 5px 0 5px;
			vertical-align: middle; 
			display: table-cell;
			width:160px;
			font-size:16px; 
		}
		
		.qnaDate {
			padding: 0 5px 0 0;
			vertical-align: middle; 
			display: table-cell;
			width:95px;
		}
		
		.qnaContents {
			
			background-color: #fafafa;
			border-bottom: 1px solid lightgray;
		}
		
		.qnaQA {
			padding:30px 20px 20px;
			display:table-cell;
			vertical-align: middle;
			width:865px;
			font-size:20px;
			text-align:left;
			overflow-wrap: break-word;
			word-break:break-all;
		    white-space: normal;
		}
		
		.qnaIconQA{
			padding:30px 0 0;
			font-size: 40px;
			vertical-align: top;
			display:table-cell;
			width:155px;
			heght:80px;
		    text-align: center;
		}
		.areaQA {
			min-height:100px;
		}
		
		.reviewText {
			font-size:20px;
			padding: 10px 0 0;
			text-align:left;
		}
		
		.reviewScore {
			font-size:20px; 
			font-weight:bold;
			height: 40px; 
			text-align:left;
		}
		.tab_review {
			text-align:left;
			border-top: 5px solid lightgray;
		}
		
		.tab_review .reviewList li{
			border-bottom: 1px solid lightgray;
		}
		
		.reviewImg {
		padding: 10px 0 10px;
		}
		
		.btnModalQNA {
			background-color:#55cc55;
			border:0;
			border-radius:5px;
			color:white;
			font-size:16px;
			font-weight:bold;
			width:90px;
			height:25px;
		}
		
		.updateBtnQNA{
			background-color:#55cc55;
			border:0;
			border-radius:5px;
			color:white;
			font-weight:bold;
			width:40px;
			height:25px;
			border-radius: 5px;
		}
		
		.detailInfoTitle{
			margin-bottom:15px;
			text-align:left;
			font-size:30px;
			overflow-wrap: break-word;
			word-break:break-all;
		    white-space: normal;
		}
		
		.detailInfoPrice{
			text-align:left;
		}
		
		.detailInfoSaleIcon {
			padding: 0 15px 0;
			display:inline-block;
			text-align:left;
			background-color:red;
			color:white;
			border-radius:15px;
		}
		
		.price_tx{
			color: gray;
			font-size:20px;
		}
		
		.priceTx{
			color:red;
			font-size:25px;
		}
		
		.numInput{
			text-align:right;
			margin-top:120px;
		}
		
		.price_area{
			text-align:right;
			padding: 10px 10px 10px;
			border-bottom: 1px solid red;
			font-weight:bold;
			font-size: 20px;
		}
		
		.total_price {
			color:red;
		}
		
		.btnMP {
			margin: 0 -4px 0;
			font-size:16px;
			width: 25px; 
			height: 25px; 
		}
		
		.totalNum{
			text-align:center;
			margin: 0 -3px 0;
			font-size:16px;
			width:60px;
			height: 25px;
		}
		
		.item_btn_area{
			margin-top:15px;
			text-align: center;
		}
		<%@ include file="../css/styles.css" %>
</style>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
function clickTabMenu(id){
			if(id == "detailInfo"){
				$("#detailInfo").addClass("on");
				$("#reviewInfo").removeClass("on");
				$("#qnaInfo").removeClass("on");
				$(".tab_detail").parents().addClass("show");
				$(".tab_review").parents().removeClass("show");
				$(".tab_qna").parents().removeClass("show");
			}else if(id == "reviewInfo"){
				$("#detailInfo").removeClass("on");
				$("#reviewInfo").addClass("on");
				$("#qnaInfo").removeClass("on");
				$(".tab_detail").parents().removeClass("show");
				$(".tab_review").parents().addClass("show");
				$(".tab_qna").parents().removeClass("show");
				
				if($(".reviewList").hasClass("list") == false){
					
					$(".reviewList").addClass("list");
					
			        $.ajax({
			            url:"${contextPath}/review/reviewList",
			            type:"get",
			            async:false,
			            data:{item_idx:${item.idx}},
			            
			            success:function(data, textStatus){
			            	var jsonInfo = JSON.parse(data);
			            	//alert(jsonInfo.reviewList.length);
			            	var output=""; 
			            	
							if(jsonInfo.reviewList.length != 0){
				            	for(var i in jsonInfo.reviewList){
				            		output += "<li><div class='userId''>"+jsonInfo.reviewList[i].user_id+"</div>";
									output += "<div class='reviewContents' >";
									output += "<div class='reviewScore'>"+jsonInfo.reviewList[i].grade+"점 "+jsonInfo.reviewList[i].moment+"</div>";
									output += "<div class='reviewText' >"+jsonInfo.reviewList[i].content+"</div>";
									if(jsonInfo.reviewList[i].image != ""){
										output += "<div class='reviewImg'><img id='detailImg' style='width:20%' src='${contextPath}"+jsonInfo.reviewList[i].image+"' alt='상품명 이미지'></div>";
									}
									output += "</div></li>";
				            	}
								$(".reviewList").html(output);
							}else{
								output = "<p style='text-align: center; font-size: 25px;' >등록된 리뷰가 없습니다.</p>";
								$(".reviewList").html(output);
							}

			            },
			            error:function(){
			                alert("clickTabMenu(id) ajax ERR");
			            },
			            complete:function(data, textStatus){
						
						}
			        });
				}
			}else if(id == "qnaInfo"){
				$("#detailInfo").removeClass("on");
				$("#reviewInfo").removeClass("on");
				$("#qnaInfo").addClass("on");
				$(".tab_detail").parents().removeClass("show");
				$(".tab_review").parents().removeClass("show");
				$(".tab_qna").parents().addClass("show");
				
				if($(".qnaList").hasClass("list") == false){
					
					$(".qnaList").addClass("list");
					
			        $.ajax({
			            url:"${contextPath}/qna/qnaList",
			            type:"get",
			            async:false,
			            data:{item_idx:${item.idx}},
			            
			            success:function(data, textStatus){
			            	var jsonInfo = JSON.parse(data);
			            	//alert(jsonInfo.qnaList.length);
			            	var output="";
			            	var user_id = '${sessionScope.user.id}';
			            	
							if(jsonInfo.qnaList.length != 0){
				            	for(var i in jsonInfo.qnaList){
					            	output += "<li><div class='qnaTitle' >";
					            	output += "<input type='hidden' class='qna_idx' value='"+jsonInfo.qnaList[i].idx+"'>";
					            	output += "<input type='hidden' class='qnaQ' value='"+jsonInfo.qnaList[i].questionContent+"'>";
					            	output += "<p class='qnqTitleTx' >";
					            	console.log("answer : ",jsonInfo.qnaList[i].answer)
					            	if(jsonInfo.qnaList[i].answer == ""){
					            		output += "<span class='qnaIcon'> 답변대기 </span>";
					            	}
					            	else{
					            		output += "<span class='qnaIcon answer'> 답변완료 </span>";
					            	}
					            	output += "<a href='javascript:void(0);' onclick='clickQNA("+i+")'>"+jsonInfo.qnaList[i].questionContent+"</a></p>";
					            	output += "<div class='user_Id'><p class='qnaID' >"+ jsonInfo.qnaList[i].user_id+"</p>";
					            	
					            	if( user_id == jsonInfo.qnaList[i].user_id){
					            		if(jsonInfo.qnaList[i].answer == "") output += "<button class='updateBtnQNA' onclick='updateQNA("+i+")'>수정 </button>";
					            		output += "<button class='updateBtnQNA' onclick='deleteQNA("+i+")'>삭제</button>";
					            	}
					            	
					            	output += "</div><p class='qnaDate' >"+jsonInfo.qnaList[i].moment+"</p></div>";
					            	output += "<div class='qnaContents'>";
					            	output += "<div class='areaQA'><div class='qnaIconQA'>Q</div><div class='qnaQA'>"+jsonInfo.qnaList[i].questionContent+"</div></div>";
					            	if(jsonInfo.qnaList[i].answer != ""){
					            		output += "<div class='areaQA'><div class='qnaIconQA'>A</div><div class='qnaQA'>"+jsonInfo.qnaList[i].answer+"</div></div>";
					            	}
					            	output += "</div></li>";
				            	}
								$(".qnaList").html(output);
							}else{
								output = "<p style='font-size: 25px;' >등록된 Q&A가 없습니다.</p>";
								$(".qnaList").html(output);
							}

			            },
			            error:function(){
			                alert("clickTabMenu(id) ajax ERR");
			            },
			            complete:function(data, textStatus){
						
						}
			        });
				}			
			}			
}



function deleteQNA(num){
	var qnaidx = $(".qna_idx");
	document.location="${contextPath}/qna/qnaDelete?idx="+$(qnaidx[num]).val()+"&item_idx="+${item.idx};
}

function clickQNA(num){
	var qnaList = $(".qnaTitle");
	
	if($(qnaList[num]).parent().hasClass("show") != true){
		$(qnaList).parent().removeClass("show");
		$(qnaList[num]).parent().addClass("show");
	}else{
		$(qnaList[num]).parent().removeClass("show");
	}
	
}
function buyItem(){
	if(${ sessionScope.user != null }){
		alert("구매 완료되었습니다.");
	}
	document.location="${contextPath}/user/paymentInsert?item_idx="+${item.idx} +"&price="+$("#totalPriceTx").text()+"&count="+$("#total").val();
	
}


function minus(){
	if($('#total').val() <= 1){
		alert("1개 이상부터 구매할 수 있습니다.");
		$('#total').val(1);
	}else{
		$('#total').val(parseInt($('#total').val()) - 1);
		
		$('#totalPriceTx').text($('#total').val()*${salePrice != 0 ? salePrice : item.price});
	}
	
}

function plus(){
	if($('#total').val() < ${item.stock_count}){
		$('#total').val(parseInt($('#total').val()) + 1);
		
		$('#totalPriceTx').text($('#total').val()*${salePrice != 0 ? salePrice : item.price});
	}
	else{
		alert("재고가 ${item.stock_count}개 남았습니다.");
	}
}
function gotoBasket(){
	if(${ sessionScope.user != null }){
		alert("제품이 장바구니에 담겼습니다.");
	}
	var servletUrl = "${pageContext.request.contextPath}/user/InsertBasket?category_idx=${item.idx}&count="+ $('#total').val() + "&title=${item.title}&price=${item.price}&discount=${item.discount}";
    window.location.href = servletUrl;

}
function modalQNA(){
	if(${ sessionScope.user == null }){
		document.location="${contextPath}/user/";
	}else{
		$('.modalBack').addClass("show");
		$('.modalQNA').addClass("show");
	}
	
}

function updateQNA(num){
	$('.modalBack').addClass("show");
	$('.modalQNA').addClass("show");
	
	var qnaText = $(".qnaQ");
	var qnaIdx = $(".qna_idx");
	console.log(qnaText);
	$('#qnaText').val($(qnaText[num]).val());
	$('#qnaIdx').val($(qnaIdx[num]).val());	
	
	
}

$(document).ready(function() {

	var temp= $('#total').val();
	
	if(${item.stock_count} == 0){
		$(".btnCart").css("display", "none");
		$(".btnBuy").css("display", "none");
		$(".btnSoldout").css("display", "");
		
	}		
	
	$('#total').click(function() {
		temp = $('#total').val();
		
	});

	$('#total').focusout(function() {
		if($('#total').val() < 1){
			alert("1개 이상부터 구매할 수 있습니다.");
			$('#total').val(temp);
		}else if($('#total').val() <= ${item.stock_count}){
			$('#totalPriceTx').text($('#total').val()*${salePrice != 0 ? salePrice : item.price});
		}else{
			alert("재고가 ${item.stock_count}개 남았습니다.");
			$('#total').val(temp);
		}	
	});
	
});

  	function goRanking(){
  		document.location="../ranking/rankingList";
  	}
</script>
</head>
<body>
	<!-- Header-->
       <jsp:include page="../header.jsp" />
       <hr>
       <div id="_container">
     		<ul id="nav4" class="nav justify-content-between bg-light">
     		  <li class="nav-item">
	                <a class="nav-link active" href="#"></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link active" href="#" onclick="goRanking()">랭킹</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">스킨케어</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">메이크업</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">향수</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">클렌징</a>
	            </li>
	        </ul>
     	</div>
     	<hr>
	<div id="c_container">
		<div  class="item_detail_area" > <!-- item 그룹 -->
			<div class="item_detail_box">
				<div class="left_area">
					<div class="item_img">
						<img id="mainImg" src="${contextPath}${item.image }" alt="상품명 이미지" >
					</div>
				
				</div>
				<div class="right_area">
					<div class="detailInfoTitle" >
						<p >${item.title }</p>
					</div>
					<div class="detailInfoPrice" >
						<c:choose> 
							<c:when test="${salePrice != 0}">
								<del class="price_tx">${item.price}원</del>
								<span class="priceTx">${salePrice}원</span> 
							</c:when> 
							<c:otherwise>
								<span class="priceTx">${item.price}원</span> 
							</c:otherwise> 
						</c:choose> 
					</div>
					<c:if test="${salePrice != 0}">
						<p class="detailInfoSaleIcon" >세일</p>
					</c:if>
					<div class="numInput" >
						<span style="font-size: 17px;">수량&nbsp;</span> 
						<button class="btnMP"  id="minus" onClick="minus()">-</button>
						<input  class="totalNum"  type="text" value="1" id="total">
						<button class="btnMP"  id="plus" onClick="plus()">+</button>
					</div>
					<div class="price_area">
						<span class="total_price_tx" >상품금액 합계&nbsp;</span>
						<span class="total_price">
							<span class="tx_num" id="totalPriceTx">
								${salePrice != 0 ? salePrice : item.price}
							</span>원
						</span>	
					</div>
					<div class="item_btn_area">
						<button class="btnCart" style="" onclick="gotoBasket()" >장바구니</button>
						<button class="btnBuy" onclick="buyItem()" >바로구매</button>
						<button class="btnSoldout"  style="display:none" disabled  >일시품절</button>
					</div> 
				</div>
			</div>
			<ul class="item_detail_tab" id="tabList">
				<li class="on" id="detailInfo">
					<a href="javascript:clickTabMenu('detailInfo');" class="item_detailInfo" >상품설명</a>
				</li>
				<li class="" id="reviewInfo">
					<a href="javascript:clickTabMenu('reviewInfo');" class="item_reviewInfo" >리뷰</a>
				</li>
				<li class="" id="qnaInfo">
					<a href="javascript:clickTabMenu('qnaInfo');" class="item_qnaInfo" >Q&A</a>
				</li>
			</ul>
			
			<div class="tab_contents show">
				<div class="tab_detail">
					<div style = "text-align: center;">
						<img id="detailImg" src="${contextPath}${item.detail }" alt="상품명 이미지" onerror="common.errorImg(this);">
					</div>
				</div>
			</div>
			<div class="tab_contents">
				<div class="tab_review">
					<ul class="reviewList" >
							
					</ul>
				</div>
			</div>
			<div class="tab_contents">
				<div class="tab_qna">
					<div class="btnQNA" >
						<button class="btnModalQNA" onClick="modalQNA()">상품 문의</button>
					</div>
					<ul class="qnaList" >
						
					</ul>		
				</div>
			</div>
		</div>
	</div>
		<footer class="py-5 bg-dark">
       		<jsp:include page="../footer.jsp" />
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; olive ung  2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
		<jsp:include page="/qna/qna.jsp"/>

</body>
</html>