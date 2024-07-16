<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버십 페이지</title>
<style type="text/css">
.membership_header {
	align:center;
	text-align:center;
}

table.membership_table {
	text-align:center;
	align:center;
	border-collapse:collapse;
	 width: 100%; 
    table-layout: fixed; 
}


.membership_body {
	align:center;
}

.membership_container {
	width :900px;
	height: 550px;
	margin: 0 auto;
	min-width : 1020px;
	}
	
	.membership_container::after {
		content: "";
		display:block;
		clear:both;
}
	table {
	    width: 100%;
	    border-collapse: collapse;
	  }
	
	  th, td {
	    padding: 8px;
	    border-bottom: 1px solid #CCCCCC;

	  }
	
	th {
	    background-color: #f2f2f2;
	  }
	  .th {
	    background-color: #f2f2f2;
	    text-align:center;
	  }
	  
	  td {
	  	 text-align: center;
	  	 font-weight: bold;
	  }
	 .membership_table th, .membership_table td {
    border: 1px solid #CCCCCC; 
    padding: 8px;
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
    .gold { color: gold; }
    .black { color: black; }
    .green { color: green; }
    .pink { color: pink; }
    .baby { color: blue; } /* 예시로 파란색 사용 */
    
    
	<%@ include file="../css/styles.css" %>
</style>
</head>
<body>
  		<!-- Header-->
       <jsp:include page="/header.jsp" />
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
     	<div class=membership_container>
			<div>
				<br>
				<h3><b>멤버십</b></h3>
				
				<c:if test="${sessionScope.user != null}">
				  <table border="1">
				    <tr>
				      <th class="th">${sessionScope.user.id }님의 등급 : ${sessionScope.user.level}</th>
				    </tr>
				    <tr>
				      <td>가지고 있는 쿠폰 : <a href="${contextPath}/user/coupon">쿠폰목록</a></td>
				    </tr>
				  </table>
				</c:if>
		<br>
		<br>
		<br>
		<h3><b>등급에 따른 다양한 혜택</b></h3>
		</div>
	<div class="membership_body">
			<table border="1" class="membership_table">
				<colgroup>
					<col style="width:304px">
					<col style="width:143px">
					<col style="width:143px">
					<col style="width:143px">
					<col style="width:143px">
				</colgroup>
				<thead>
				<tr>
					<th scope="col">등급별 혜택</th>
					<th scope="col" class="sffont-area gold">GOLD<br>UNG</th>
					<th scope="col" class="sffont-area black">BLACK<br>UNG</th>
					<th scope="col" class="sffont-area green">GREEN<br>UNG</th>
					<th scope="col" class="sffont-area pink">PINK<br>UNG</th>
					<th scope="col" class="sffont-area baby">BABY<br>UNG</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<th scope="row">선정 기준<span class="table-sub-title"><br>*직전 반기 온・오프라인 누적 구매 금액</span></th>
					<td><span class="sffont-area">100</span>만원 이상</td>
					<td><span class="sffont-area">70</span>만원 이상 ~<br><span class="sffont-area">100</span>만원 미만</td>
					<td><span class="sffont-area">40</span>만원 이상 ~<br><span class="sffont-area">70</span>만원 미만</td>
					<td><span class="sffont-area">10</span>만원 이상 ~<br><span class="sffont-area">40</span>만원 미만</td>
					<td><span class="sffont-area">10</span>만원 미만</td>
				</tr>
				
				<tr>
					<th scope="row">쇼핑 쿠폰<span class="table-sub-title"><br>*<span class="sffont-area">6</span>개월 내 매월<span class="sffont-area">1</span>회 온・오프라인 통합</span></th>
					<td><span class="sffont-area">5</span>장</td>
					<td><span class="sffont-area">4</span>장</td>
					<td><span class="sffont-area">3</span>장</td>
					<td><span class="sffont-area">2</span>장</td>
					<td><span class="sffont-area">1</span>장</td>

				</tr>
				<tr>
					<th scope="row">생일 쿠폰<span class="table-sub-title"><br>*생일월 한정, <strong style="color: red;text-decoration:underline">인당 연 1회 제공</strong></span></th>
					<td><span class="sffont-area">1</span>장</td>
					<td><span class="sffont-area">1</span>장</td>
					<td><span class="sffont-area">1</span>장</td>
					<td><span class="sffont-area">1</span>장</td>
					<td><span class="sffont-area">1</span>장</td>
				</tr>
				</tbody>
			</table>
		</div>
</div>
<br>
<br>
<br>
<br>
<br>
<footer class="py-5 bg-dark">
       		<jsp:include page="/footer.jsp" />
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; olive ung  2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>