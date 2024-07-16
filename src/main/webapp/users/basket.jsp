<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>basket.jsp</title>

<style type="text/css">

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

col{
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
    background-color: #fff;
}

table {

    border-collapse: collapse;
    width: 50%;
    text-align: center;
    border: 1px;
    table-layout:fixed ;
    text-align : center;
    
    margin-left: auto;
    margin-right: auto;
    margin-top: auto;

   
}

tr{
	border-left: none;
	border-right: none;
}


th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}

th {
    background-color: #fff;
}

th:first-child,
td:first-child {
	border-left: none;
}
th:last-child,
table td:last-child {
	border-right: 0;
}
tr:nth-child(even) {
    background-color: #fff;
}

tr:hover {
    background-color: #f2f2f2;
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

input[type="checkbox"] {
    transform: scale(1.5);
    margin: 0;
}

#totalOrderAmount {
    font-weight: bold;
    font-size: 20px;
    color: #FF4848;
}

tfoot tr td {
    text-align: right;
    font-weight: bold;
    font-size: 18px;
}

tfoot input[type="button"] {
    background-color: #ff6600;
    color: white;
    border: none;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
}

tfoot input[type="button"]:hover {
    background-color: #e65c00;
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


<!-- 상품 수량 수정 및 주문 -->
<script>
	function alertModify() {
		alert("상품 수량이 수정되었습니다.")
	}

	
	
// 	function OrderTotal() {
// 		 var checkboxes = document.querySelectorAll('input[name="itemCheckbox"]:checked');
// 		 var totalAmount = 0;
		 
// 		 checkboxes.forEach(function(checkbox) {
// 		       var itemRow = checkbox.closest('tr');
// 		       var applySalePrice = parseFloat(itemRow.querySelector('input[name="applySalePrice"]').value);
// 		       totalAmount += applySalePrice;
// 		 });
		 
// 		 var totalAmountInput = document.getElementById("totalAmountInput");
		 
// 		 var intTotalAmount = parseInt(totalAmount.toFixed(0));
// 		 totalAmountInput.value = intTotalAmount; // 수정된 부분

		 
// 		 document.getElementById("totalForm").submit(); // 수정된 부분
		 
// 	}
	
<!-- 개수별 값 넘겨주기 -->
	function Count() {
		 // Select all checked checkboxes
	    var checkboxes = document.querySelectorAll('input[name="itemCheckbox"]:checked');
	    
	    // Initialize arrays to store values
	    var productTitles = [];
	    var categoryIndices = [];
	    var counts = [];
	    var applySalePrices = [];
	    var totalAmount = 0;

	    // Iterate over each checked checkbox
	    checkboxes.forEach(function(checkbox) {
	        // Get the closest row
	        var itemRow = checkbox.closest('tr');
	           
	        // Extract the values from the row
	        var productTitle = itemRow.querySelector('input[name="ProductTitle"]').value;
	        var categoryIndex = itemRow.querySelector('input[name="category_idx"]').value;
	        var count = itemRow.querySelector('input[name="count"]').value;
	        var applySalePrice = itemRow.querySelector('input[name="applySalePrice"]').value;
	        
	        // Push the values to the respective arrays
	        productTitles.push(productTitle);
	        categoryIndices.push(categoryIndex);
	        counts.push(count);
	        applySalePrices.push(applySalePrice);
	        
	    });
	    

	    // Set the values of the hidden input fields in the form
	    document.getElementById("ProductTitle").value = productTitles.join(",");
	    document.getElementById("category_idxInput").value = categoryIndices.join(",");
	    document.getElementById("countInput").value = counts.join(",");
	    document.getElementById("applySalePriceInput").value = applySalePrices.join(",");
	    
	    document.getElementById("totalForm").submit();
	    alert("주문 성공");
	}




<!-- 장바구니 체크박스 -->

   function calculateTotalOrderAmount() {
	    var checkboxes = document.querySelectorAll('input[name="itemCheckbox"]:checked');
	    var totalAmount = 0;
	    

	    checkboxes.forEach(function(checkbox) {
	        var itemRow = checkbox.closest('tr');
	        var applySalePrice = parseFloat(itemRow.querySelector('input[name="applySalePrice"]').value);
	      
	        totalAmount += applySalePrice;
	    });

	    
	    // Convert totalAmount to an integer
	    var intTotalAmount = parseInt(totalAmount.toFixed(0));

	    // Add commas every three digits from the right
	    var formattedTotalAmount = intTotalAmount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

	    document.getElementById('totalOrderAmount').textContent = formattedTotalAmount;
	    
	}

 <!-- 장바구니 all 체크박스 -->
	function selectAllCheckboxes(checkbox) {
	    var checkboxes = document.querySelectorAll('input[name="itemCheckbox"]');
	    checkboxes.forEach(function(checkbox) {
	        checkbox.checked = event.target.checked;
	    });

	    calculateTotalOrderAmount(); // Recalculate total amount after selecting/deselecting all checkboxes
	}

	window.onload = function() {
	    calculateTotalOrderAmount();
	};
	
</script>

</head>

<body>
 <!-- Header-->
       <jsp:include page="../header.jsp" />
               
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
<p style="font-size: 28px; font-weight:bold; padding-top: 25px; padding-left: 25%;padding-bottom: 25px;">장바구니</p>


<p style="font-size: 20px; font-weight: bold; margin-left: 25%;">올리브엉 배송상품</p>
	<table>
		<colgroup>
			<col width="10px">
			<col width="30px">
			<col width="20px">
			<col width="20px">
			<col width="20px">
			<col width="10px">
			<col width="10px">
		</colgroup>

		<!-- 열 이름 -->
		<tr>
			<th  style="background-color: #f2f2f2;"><input type="checkbox" onchange="selectAllCheckboxes(this)" checked></th>
			<th style="font-size: 20px; background-color: #f2f2f2;">상품정보</th>
			<th style="font-size: 20px; background-color: #f2f2f2;">판매가</th>
			<th style="font-size: 20px; background-color: #f2f2f2;">수량</th>
			<th style="font-size: 20px; background-color: #f2f2f2;">구매가</th>
			<th style="font-size: 20px; background-color: #f2f2f2;">배송정보</th>
			<th style="font-size: 20px; background-color: #f2f2f2;">선택</th>
		</tr>

		<!-- 데이터 들어갈 곳 -->
		<c:forEach var="basketItem" items="${basketList}" varStatus="status">
			<tr>

                   <!-- checkbox -->
                   <td><input type="checkbox" name="itemCheckbox" id="itemcheckbox${basketItem.getIdx()}"
					onclick="calculateTotalOrderAmount()" checked></td>

				<!-- 상품정보 -->
				<td>
					<p>
						<strong>
							<li style="list-style: none">
							<a href="${pageContext.request.contextPath}/detail/detailList?idx=${basketItem.getItem_idx()}"
								style="font-size: 20px; font-weight:normal; ; text-decoration: none; color: #000">${basketItem.getCategory()}</a>
							</li>
						</strong>
					</p> 
					<input type="hidden" id="productTitle" name="ProductTitle" value="${basketItem.getCategory()}" /> 
					<input type="hidden" id="product_idx" name="category_idx" value="${basketItem.getItem_idx()}"/>
				</td>


				<!-- 판매가 -->
				<td>
				<input type="hidden" value="${basketItem.getPrice()}" name="OriginalPrice" id="OriginalPrice">
				<c:set var="ALLPrice" value="${basketItem.getPrice()}"></c:set> 
				
				<fmt:formatNumber type="number" pattern="###,##0" maxFractionDigits="0" value="${ALLPrice}" />원 
				<input type="hidden" value="${ALLPrice}" name="ALLPrice" id="ALLPrice" />
				</td>


				<!-- 수량 -->
				<form action="${pageContext.request.contextPath}/user/ModifyBasket" method="post">
					<td>
							<input type="hidden" value="${basketItem.getPrice()}" name="price" id="price" /> 
							<input type="hidden" value="${basketItem.getSale()}" name="SalePercent" id="SalePercent" /> 
							<input type="hidden" value="${basketItem.getItem_idx()}" name="category_idx" id="category_idx" /> 
							
							<input type="number" id="count" min="1" max="${basketItem.getStock_count()}" value="${basketItem.getCount()}" name="count" 
							  style="width:70px; height: 30px; text-align: center; font-size: 15px; border-radius: 8px; color: f2f2f2; "/> 
							
							<button type="submit" onclick="alertModify()">수정</button>
							
					</td>
	
	
					<!-- 구매가 -->
					<td>
					<input type="hidden" value="${basketItem.getPrice()}" name="OriginalPrice" id="OriginalPrice" /> 
					<input type="hidden" value="${basketItem.getSale()}"  name="SalePercent" id="SalePercent" />
					<input type="hidden" value="${basketItem.getCount()}" name="count" id="count" /> 
					
	
	
					<c:set var="ApplySale" value="${basketItem.getApplySalePrice()}" />
					<input type="hidden" value="${basketItem.getApplySalePrice()}" name="applySalePrice" id="applySalePrice"/> 
					<fmt:formatNumber type="number" pattern="###,##0" maxFractionDigits="0" value="${ApplySale}" />원
					</td>
	
	
					<!-- 배송정보 -->
					<td>
						<p style="font-size: 15px; font-weight: bold;">무료배송</p> <br>
						<p style="font-size: 10px;">도서·산간 제외</p>
					</td>


		  		</form>

				<!-- 선택 -->

				<td>
		        <form action="${pageContext.request.contextPath}/user/DeleteBasket" method="post">

						<input type="hidden" value="${basketItem.getPrice()}" name="price" id="price" /> 
						<input type="hidden" value="${basketItem.getSale()}" name="SalePercent" id="SalePercent" /> 
						<input type="hidden" value="${basketItem.getItem_idx()}" name="category_idx" id="category_idx" /> 
						<input type="hidden" value="${basketItem.getCount()}" name="count" /> 
						
						<button type="submit">삭제</button>
		  </form>

				</td>
    
		</tr>
     </c:forEach>

	</table>
	
	<div style="padding-left: 25%; font-size: 24px; font-weight: bold; text-align: right; padding-right: 25%; padding-top: 10px; padding-bottom: 10px;">
			총 결제 예상 금액 : <span id="totalOrderAmount" style="font-size: 40px;">0</span> 원
        </div>

		<br>
		<div align="center">
		<form id="totalForm" action="${pageContext.request.contextPath}/testPayment" method="post">
			<input type="hidden" name="totalAmountInput"  id="totalAmountInput" value ="">
			<input type="hidden" name="ProductTitle"  id="ProductTitle" value ="">
			<input type="hidden" name="applySalePriceInput"  id="applySalePriceInput" value ="">
			<input type="hidden" name="category_idxInput"  id="category_idxInput" value ="">
			<input type="hidden" name="user_idxInput"  id="user_idxInput" value ="">
			<input type="hidden" name="countInput"  id="countInput" value ="">
			
			<input type="button" value= "주문하기"  name="order" onclick="Count()"
			style="text-align: center; border-radius: 10px; color: #FFFFFF; border: none; padding-top :10px; padding-right:25%;
             font-size: 30px; font-weight:bold; padding: 10px; background-color: #FF6C6C; text-align: center;"/>
		</form>
		</div>
		<br>
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
