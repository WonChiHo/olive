<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 페이지</title>
<style type="text/css">
    .coupon_table {
        
        border-collapse: collapse;
        margin: auto; /* 가운데 정렬을 위해 */
    }
 
    .coupon_div {
    	margin-top:150px;
    	margin-bottom:250px;
        text-align: center; /* 가운데 정렬을 위해 */
 
    }
    
    th, td {
        padding: 10px; /* 셀 안의 내용과 테두리 간의 여백 설정 */
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
<div class="coupon_div">
	<h3 style="text-align:center"><b>쿠폰</b></h3>
    <table class="coupon_table" border="1">
    	
        <tr>
            <th>쿠폰 이름</th>
            <th>쿠폰 할인율</th>
            <th>쿠폰 등록일</th>
        </tr>
        <c:forEach var="coupon" items="${coupons}">
            <tr>
                <td>${coupon.name}</td>
                <td>${coupon.discount}%</td>
                <td>${coupon.moment}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br><br><br><br><br>
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
