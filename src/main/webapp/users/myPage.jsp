<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  	<style type="text/css">
  		<%@ include file="../css/styles.css" %>
 
  	 h3, input[type="button"] {
    display: inline-block; 
  }
	  input[type="button"] {
	    float: right; 
	    border: none;
	    padding: 5px 10px; 
  }
	  
	  #main {
		    width: 100%;
		    height: 400px;
		    margin-top: 20px;
			margin:auto;
		}
		 body {
	    font-family: Arial, sans-serif;
	    margin: 0;
	    padding: 0;
	  }

  .container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
  }
  .section {
    margin-bottom: 20px;
    border: 1px solid #ccc;
    padding: 20px;
    background-color: #f9f9f9;
  }

  .section-header {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
    
  }
  
	table {
	    width: 100%;
	    border-collapse: collapse;
	  }
	
	  th, td {
	    padding: 8px;
	    text-align: left;
	    border-bottom: 1px solid #ddd;
	    text-align: center; 
	  }
	
	  th {
	    background-color: #f2f2f2;
	  }
	  
	  td {
	  	 text-align: center;
	  	 font-weight: bold;
	  }
	  
	  .button {
	  	float: right;
	    border: none;
	    padding: 5px 10px; 
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
  	</style>
  	<script type="text/javascript">

  	
  	
    function modifyButton(num, title){
		$('.modalBack').addClass("show");
		$('.modalQNA').addClass("show");
	    $('#item_idx').val(num);
	    $('.itemInfoTitle').text(title);
	   
	}
  	</script>
</head>
<body>
  		<!-- Header-->
       <jsp:include page="/header.jsp" />
        <hr>
        
         <!--  랭킹, 스킨케어, 메이크업, 향수, 클렌징 bar -->
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
  
     	<div class="container">
     		<div class="my">
     			<h3 ><b>마이페이지</b></h3>
     			<input type="button" value="회원정보 수정" class="buttonMod"  onclick="document.location='${pageContext.request.contextPath}/userUpdate.jsp'">
     		<br></div>
     		<br>
     		
		    <div class="section">
		       <div class="section-header">멤버십</div>
		      <!-- 멤버십 내용 -->
		      	<table>
		      		<tr>	
		      			<th>
		      				${sessionScope.user.level } UNG ${sessionScope.user.name }님 반갑습니다.
		      				<input type="button"  value="더보기>" class="button" onclick="location.href='${pageContext.request.contextPath}/memberships/membership.jsp';">
		      			</th>
		      		</tr>
		      	
		      	</table>
		 		<br>
		 		<br>
		      
				<br>
				<br>
		      <div class="section-header">장바구니</div>
		      <!-- 장바구니 내용 -->
		      <table>
		      		<tr>	
		      			<th>
		      				장바구니
		      				<input type="button"  value="더보기>" class="button" onclick="location.href='${pageContext.request.contextPath}/user/ShowBasket'">
		      			</th>
		      		</tr>
		      	</table>
		  		<br>
		  		<br>
		  		<br>
		  		<br>
		  		<form action="" method="post"> 
		  		 <div class="section-header">리뷰</div>
		      <!-- 멤버십 내용 -->
		      	<table>
		      		<tr>	
		      			<th colspan="8">
		      				 Review
		      			</th>
		      		</tr>
		      		<tr>
               			<th>주문 번호</th>
               			<th>이름</th>
               			<th>전화번호</th>
               			<th>상품 이름</th>
               			<th>주문 날짜</th>
               			<th>상품 가격</th>
               			<th>상품 개수</th>
               			<th>리뷰 작성</th>
	                </tr>
		     
                	<c:forEach var="order" items="${orderList}" varStatus="status">
				        <tr>
				            <td><c:out value="${order.item_idx}" /></td>
				            <td><c:out value="${order.name}" /></td>
				            <td><c:out value="${order.phone}" /></td>
				            <td><c:out value="${order.title}" /></td>
				            <td><c:out value="${order.moment}" /></td>
				            <td><c:out value="${order.price}" /></td>
				            <td><c:out value="${order.count}"/></td>
				            <td>
			            		<button type="button" class="btn" style="width: 70px; background-color:rgb(123,125,125); border:none;" onclick='modifyButton(${order.item_idx}, "${order.title}")' >작성</button>
				            
				            </td>
	                 </c:forEach>
		      	</table>
		      </form>
		    </div>
 	 	</div>		
     	<footer class="py-5 bg-dark">
       		<jsp:include page="/footer.jsp" />
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; olive ung  2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
  		<jsp:include page="/review/review.jsp"/>
</body>
</html>