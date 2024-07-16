<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olive?ung 상품 랭킹</title>
	<style type="text/css">
		* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		}
	
		.ranking_list li a {
 			text-decoration: none;
  		    color: inherit;
		}
		
		
		#c_container{
			width: 100%;
			margin:0 auto; <%-- div 중앙정렬 --%>
			background-color: ; <%-- 영역 구분용 --%>
			
		}

		.itemList_area{
			width: 1020px;
			margin:0 auto; <%-- div 중앙정렬 --%>
			text-align: center;
			background-color: ; <%-- 영역 구분용 --%>
		}
		
		
		
		.ranking_list{ <%-- 구분선 --%> 
			border-top: 5px solid #e5e5e5;
			border-bottom: 1px solid #e5e5e5; 
		}
		
		.ranking_title{
			width: 100%;
    		height: 60px;
		}
		
		.ranking_title h3 {
			width: 1020px;
		    margin: 0 auto;
		    padding: 10px 0 0;	
		    
		}
		
		
		.mgLine	{
			border-top: 0 !important
		}
		
		.ranking_num{
			width:40px;
			height:40px;
			line-height:32px;
			position: absolute;
			background-color: #ff7777;
			border-radius: 50%;
			border: 3px solid #ff4444;
			text-align: center;
			color: #ffffff;
			font-size:20px;
			font-weight: bold;
		}
		
		.itemList_area li{
			background-color:; <%-- 영역 구분용 --%>
			float:left;
			list-style:none;
			display: inline-block;
			padding: 30px 20px 35px;
			width: 33%;
		} 
		
		.ranking_list:after {
		   	content: "";
		    display: block;
		    clear: both;
		}
		
		.ranking_list li img{
			
			width:100px;
		} 
		
		li a img {
			width: auto !important;
   		 	max-width: 215px;
   			height: auto !important;
   			max-height: 215px 
		}
		
		.priceRank_tx {
			color: gray;
			font-size:15px;
	
			
		}
		.priceRankTx {
			color:red;
			font-size:18px;
			font-weight: bold;
		}
		
		.titleRank{
			overflow-wrap: break-word;
			word-break:break-all;
		    white-space: normal;
		}
		.nav-link.active {
    	color: black; /* 검정색으로 설정 */
    	font-weight:bold;
		}
		.nav-link {
		color:black;'
		}
		.nav-item {           
	    margin-left: 160px; /* 왼쪽 여백을 50px로 설정 */
	    margin-right: 200px; /* 오른쪽 여백을 50px로 설정 */
		}

		.nav-item:not(:last-child) {
		    margin-right: 100px;
		}
		<%@ include file="../css/styles.css" %>
	</style>
</head>
<body>
	<!-- Header-->
       <jsp:include page="../header.jsp" />
       <hr>
       <div id="_container">
		    <ul id="nav4" class="nav justify-content-between">
		       
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/ranking/rankingList">랭킹</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Skin">스킨케어</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Makeup">메이크업</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Perfume">향수</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Cleansing">클렌징</a>
		        </li>
		    </ul>
		</div>	
     	<hr>
	<div id="c_container">
		<div class="ranking_title"> <!-- 타이틀 -->
			<h3><b>랭킹</b></h3>
		</div>
		
		<div  class="itemList_area" > <!-- item 그룹 -->
			<c:forEach var="item" items="${itemList}" varStatus="status">
				<c:if test="${(status.index % 3) == 0}">
					<ul class="ranking_list ${status.index != 0 ? "mgLine" : "" }" > <!-- 3개씩 묶음  --> 
				</c:if>	
						<li> <!-- item 한개  -->
							<div > <!-- li 전체 --> 
								<a  href="${contextPath}/detail/detailList?idx=${item.idx}">
									<span class="ranking_num">${status.count}</span>
									<img   src="${contextPath}${item.image}" onerror="common.errorImg(this);">
								</a>
								<div>
									<a class="titleRank" href="${contextPath}/detail/detailList?idx=${item.idx}">
										<p>${item.title}</p>
									</a>
								</div>
								<p>
									<c:choose> 
										<c:when test="${salePrice[status.index] != 0}">
											<del class="priceRank_tx">${item.price}원</del>
											<span class="priceRankTx">${salePrice[status.index]}원</span> 
										</c:when> 
										<c:otherwise>
											<span class="priceRankTx">${item.price}원</span> 
										</c:otherwise> 
									</c:choose> 		
								</p>
							</div>
						</li>
					<c:if test="${(status.count % 3) == 0}">
						</ul>
					</c:if>	
			</c:forEach>
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
</body>
</html>