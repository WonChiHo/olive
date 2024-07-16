<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<style type="text/css">
#container {
    display: flex;
    justify-content: center;
}


header#header nav.top_util { display: flex; justify-content: space-between; align-items: center; }
header#header nav.top_util hgroup.header_inner { display: inline-block; margin-right: 20px}
header#header nav.top_util ul.menu_list { display: flex; list-style: none; }
header#header nav.top_util ul.menu_list li { margin-right: 5px; }
header#header nav.top_util div.search { display: flex; align-items: center; }
header#header nav.top_util div.search input.search_box { margin-right: 5px; }

header#header nav.top_util hgroup.header_inner img.logo_img { width:250px; }
header#header nav.top_util ul.menu_list li a {
    text-decoration: none; /* 링크에 밑줄 제거 */
    color: #333; /* 링크 텍스트 색상 변경 */
    font-weight: bold; /* 링크 텍스트 굵게 표시 */
}

header#header nav.top_util ul.menu_list li a:hover {
    color: #ff6600; /* 링크에 마우스를 올렸을 때 색상 변경 */
}

header#header nav.top_util ul.menu_list li a::after {
    content: "|"; /* 가상 요소에 표시할 내용 설정 */
    margin-left: 5px; /* 구분자와 링크 사이의 간격 설정 */
    color: #333; /* 구분자 색상 설정 */
}

.search {
    position: relative;
    display: inline-block; 
}

.search_box {
    width: 320px; 
    height: 40px;
    padding: 8px 32px 8px 12px; 
    border: 1px solid #ccc; 
    border-radius: 10px; 
    outline: none; 
    font-size: 14px; 
}

.search_box:focus {
    border-color: #007bff; 
}

.search img {
    position: absolute;
    top: 50%;
    right: 10px; 
    transform: translateY(-50%); 
    width: 20px;
    height: 20px;
    cursor: pointer; 
}
</style>
<link rel="icon" href="${contextPath}/image/logo.png">
<!-- </head> -->
<!-- <body> -->

<div id="container">
	<form action="${pageContext.request.contextPath}/Search?keyword=${param.keyword}" method="get">
		<header id="header">
				<nav class="top_util">
				
					<hgroup class="header_inner">
						<h1><a href="${contextPath}/index.jsp"><img class="logo_img" src="${contextPath}/image/logo.png"></a>
						</h1>
					</hgroup>
				
					<div class="search">
						<input class="search_box" type="text" name="keyword" value="" placeholder=""/>
						<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
					</div>
						<c:choose>
							<c:when test="${ sessionScope.user == null }">
							<ul class="menu_list">
								<li><a href="${contextPath}/login.jsp">로그인/회원가입</a></li>
								<li><a href="${pageContext.request.contextPath}/user/ShowBasket">장바구니</a></li>
								<li><a href="${contextPath}/memberships/membership.jsp">멤버십/쿠폰</a></li>
								<li><a href="#">접속자수:${applicationScope.userCount}</a></li>
							</ul>
							
							</c:when>
							<c:otherwise>
								<ul class="menu_list">
									<li><a href="${contextPath}/logout">로그아웃</a></li>
							<%-- 		<li><a href="${contextPath}/users/myPage.jsp">마이페이지</a></li> --%>
	 								<li><a href='<c:url value="/PayListServlet"/>'>마이페이지</a></li> 
									<li><a href="${pageContext.request.contextPath}/user/ShowBasket">장바구니</a></li>
									<li><a href="${contextPath}/memberships/membership.jsp">멤버십/쿠폰</a></li>
									<li><a href="#">접속자수:${applicationScope.userCount}</a></li>
								</ul>
							</c:otherwise>
						</c:choose>
				</nav>
		</header>
	</form>
</div>
