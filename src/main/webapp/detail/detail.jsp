<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="com.kah.VO.ItemVO"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
 
<style type="text/css">

		
body {
    font-family: Arial, sans-serif;

   
}

.grid-container {
    display: grid;
    grid-template-columns:repeat(3, 300px);
    grid-gap: 20px;
    padding-left: 25%;
    padding-right: 25%;
    
  
}

.grid-item {
    border: 1px solid #ccc;
    padding: 20px;
   
}

.grid-item img {
    max-width: 100%;
    height: auto;
}



.grid-item a {
    text-decoration: none;
    color: #000;
}

.grid-item a:hover {
    color: #ff6600;
}

.price-original {
    font-size: 20px;
    color: #888;
    text-decoration: line-through;
    text-align: left;
}

.price-discounted {
    font-size: 24px;
    color: #ff6600;
    font-weight: bold;
    text-align: right;
    align-items: flex-end;
}

.page-navigation {
    margin-top: 20px;
 
}

.page-navigation a {
    display: inline-block;
    padding: 8px 16px;
    background-color: #ff6600;
    color: #fff;
    text-decoration: none;
    border-radius: 4px;
    margin-right: 5px;
  
}

.page-navigation a:hover {
    background-color: #e65c00;
}

button {
 -webkit-border-radius: 10px;
   -moz-border-radius: 10px;
   border-radius: 7px;
   color: #9bce26;
   font-family: Arial;
   font-size: 15px;
   font-weight: 100;
   padding: 5px;
   background-color: #FFFFFF;
   border: solid #9bce26 2px;
   text-decoration: none;
   display: inline-block;
   cursor: pointer;
   text-align: center;
 
}

button:hover {
 -webkit-border-radius: 10px;
   -moz-border-radius: 10px;
   border-radius: 7px;
   color: #9bce26;
   font-family: Arial;
   font-size: 15px;
   font-weight: 100;
   padding: 5px;
   background-color: #FFFFFF;
   border: solid #9bce24 2px;
   text-decoration: none;
   display: inline-block;
   cursor: pointer;
   text-align: center;
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
<input type="hidden" name="keyword" value="${keyword}">
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
<c:choose>

<c:when test="${empty keyword}">

<!-- 정렬 버튼 -->
    <form action="${pageContext.request.contextPath}/detail/Sorting?sort=${param.sort}&categoryName=${sessionScope.categoryName}" method="get">
	
	
<!-- 카테고리 확인 -->
<div style="font-size: 30px; font-weight: bold;  padding-left: 25%;">

<c:if test="${fn:length(itemList) != 0}">


 <c:choose>
 
  <c:when test="${param.List eq 'ALL'}">
  <p>전체<p>
  <input type="hidden" name="categoryName" value="ALL" />
  </c:when>
  
  <c:when test="${param.List eq 'Skin'}">
  <div class="">
  <p><b>스킨케어</b></p>
  </div>
  <input type="hidden" name="categoryName" value="Skin" />
  </c:when>
  
  <c:when test="${param.List eq 'Makeup'}">
  <p>메이크업<p>
  <input type="hidden" name="categoryName" value="Makeup" />
  </c:when>
  
  <c:when test="${param.List eq 'Perfume'}">
  <p>향수<p>
  <input type="hidden" name="categoryName" value="Perfume" />
  </c:when>
  
  <c:when test="${param.List eq 'Cleansing'}">
  <p>클렌징<p>
  <input type="hidden" name="categoryName" value="Cleansing" />
  </c:when>
  
 </c:choose>
</c:if>
<!-- 베너 -->
    <div style="padding-right: 25%;"> 
    <button type="submit" style="border: none;">
    <img src="${pageContext.request.contextPath}/data/screenConfiguration2.jpg" alt="이미지 설명">
    </button>
	</div>

    <div style="padding-right: 25%;"> 
    <button type="submit" style="border: none;">
    <img src="${pageContext.request.contextPath}/data/screenConfiguration.png" alt="이미지 설명">
    </button>
	</div>
</div>
	<div style="margin-left: 25%;">
		<button type="submit" name="sort" value="popularity">인기순</button>
		<button type="submit" name="sort" value="highPrice">높은 가격순</button>
		<button type="submit" name="sort" value="lowPrice">낮은 가격순</button>
	</div>
</form>
</c:when>

<c:when test="${not empty keyword}">

<!-- 정렬 버튼 -->
    <form action="${pageContext.request.contextPath}/detail/searchItemSortingServlet?sort=${param.sort}&keyword=${keyword}" method="get">
	<div style="margin-left: 25%;">
		<button type="submit" name="sort" value="popularity">인기순</button>
		<button type="submit" name="sort" value="highPrice">높은 가격순</button>
		<button type="submit" name="sort" value="lowPrice">낮은 가격순</button>
		<input type="hidden" name="keyword" value="${keyword}">
		<input type="hidden" name="totalCount" value="${totalCount}">
	</div>
	</form>
</c:when>

</c:choose>
<br>


<!-- 검색 결과 없을 때-->
<c:if test="${fn:length(itemList) == 0}">

	<div style="font-size: 30px; font-weight: bold; text-align: center; padding-bottom: 10%;">
        <c:choose>
        <c:when test="${not empty keyword}">
        <img src="${pageContext.request.contextPath}/data/CautionMark.png"/>
        <div><c:out value="검색하신 '${keyword }'에 관한 검색 결과가 없습니다."/></div>
        </c:when>

        <c:when test="${empty keyword}">
        <img src="${pageContext.request.contextPath}/data/CautionMark.png"/>
        <div><c:out value="상품정보가 존재하지 않습니다."/></div>
        </c:when>
        </c:choose>
		</div>


</c:if>

	<!-- 상세페이지 -->
	
	
	<div class="grid-container">
		<c:forEach var="item" items="${itemList}">
			<div class="grid-item">
				<p>
					<img src="${pageContext.request.contextPath}${item.getImage()}"
						style="width: 400px; height: 250px;"><br>
				</p>

				<p>
					<strong>
					<input type="hidden" value="${item.getIdx()}" name= "idx" id="idx" />
					<input type="hidden" value="${item.getDiscount()}" name="discount" />
						<li style="list-style: none"><a
							href="${pageContext.request.contextPath}/detail/detailList?idx=${item.getIdx()}"
							style="font-size: 16px; text-decoration: none; color: #000">${item.getTitle()}</a></li>
							
					</strong>
				</p>

				<p style="font-size: 19px; color: gray; text-align: left;">
					<STRONG><strike> ${item.getPrice()}원 </strike></STRONG>
				</p>
				<p style="font-size: 18px; color: red; text-align: right;">
					<STRONG><fmt:formatNumber
							value="${item.getPrice() - (item.getPrice() * item.getDiscount()/ 100)}"
							pattern="#,##0" /> 원 </STRONG>
				</p>
			</div>
		</c:forEach>
	</div>

             
     <div style="font-size: 18px; font-weight: bold; padding-left: 25%; padding-right: 25%;" align="center">
   		 <c:out value="${pageNavigator}" escapeXml="false" />
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

