<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<!--  exit -->
    <title>[Admin]index</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<style>
		.styled-table {
			width: 100%;
		    border-collapse: collapse;
		    margin: 25px 0;
		    font-size: 0.9em;
		    font-family: sans-serif;
		    min-width: 400px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
		}
		
		.styled-table thead tr {
	    background-color: rgb(123,125,135);
	 	color: #ffffff;
	    text-align: left;
		}
		
		.styled-table th,
		.styled-table td {
	    padding: 12px 15px;
		}
		
		.styled-table tbody tr {
	    border-bottom: 1px solid #dddddd;
		}
	
		.styled-table tbody tr:nth-of-type(even) {
		    background-color: #f3f3f3;
		}
		
		.styled-table tbody tr:last-of-type {
		    border-bottom: 2px solid rgb(123,125,135);
		}
		
		<%@ include file="css/sb-admin-2.min.css" %>
	 	
	</style>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></script>
	
</head>
<body id="page-top">
	<form action="" method="get">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-dark sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="admin_main.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Admin</div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            <!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>상품 관리</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href='<c:url value="/ItemAddServlet"/>'>상품 등록</a>
                        <a class="collapse-item" href='<c:url value="/ItemListServlet"/>'>상품 목록</a>
                    </div>
                </div>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">
              <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/OrderListServlet"/>'>
                    <i class="fas fa-fw fa-folder"></i>
                    <span>주문 관리</span></a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">
              <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/MemberListServlet"/>'>
                    <i class="fas fa-fw fa-folder"></i>
                    <span>회원 관리</span></a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
			<!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/BoardListServlet"/>'>
                    <i class="fas fa-fw fa-folder"></i>
                    <span>게시판 관리</span></a>
            </li>
            
             <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
        </ul>
        <!-- End of Sidebar -->

          <!-- Begin Page Content -->
                <div class="container-fluid">

                    <div class="d-sm-flex align-items-center justify-content-between mb-4"></div>
                    <!-- Content Row -->
                    <div class="row">
                        <!-- 회원 수 -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-primary shadow py-4 px-3">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                회원 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${memberList.size()}" />명</div>
                                        
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- 변수 초기화 -->
						<c:set var="totalPrice" value="0"/>
						
						<!-- 가격 합산 -->
						<c:forEach var="order" items="${orderList}">
						    <c:set var="totalPrice" value="${totalPrice + order.price}"/>
						</c:forEach>
                        <!-- 총 매출 -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-success shadow py-4 px-3">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                총 매출</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${totalPrice}" />원</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 문의 건수 -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-info shadow py-4 px-3">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">문의 건수
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><c:out value="${boardList.size()}" />개</div>
                                                </div>
                                          
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 판매 상품 수 -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-warning shadow py-4 px-3">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                               판매 상품 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${itemList.size()}" />개</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   <!-- 문의 목록 -->
                   <div class="row">
                        <div class="col-xl-12">
                 
                        	<h6>Q&A 목록</h6>
                        	<table class="styled-table">
                        		<thead>
	                        		<tr>
	                        			<th>글 번호</th>
	                        			<th>카테고리</th>
	                        			<th>내용</th>
	                        			<th>아이디</th>
	                        			<th>작성일</th>
	                        		</tr>
	                        	</thead>
	                        	<tbody>
	                        		<c:forEach var ="board" items="${boardList }" varStatus="status">
	                        		<tr>
	                        			<td><c:out value="${board.idx }" /></td>
	                        			<td><c:out value="${board.category }" /></td>
	                        			<td><c:out value="${board.questionContent }" /></td>
	                        			<td><c:out value="${board.user_id }" /></td>
	                        			<td><c:out value="${board.moment }" /></td>
		                   
	                        		</tr>
	                        	</c:forEach>
                        		</tbody>
                        	</table>
                        </div>
					</div> 
                  
          	 	   <!-- 주문 목록 -->
                    <div class="row">
                         <div class="col-xl-12">
                       		 <!-- 주문 번호, 아이디, 주문 가격, 주문 날짜, 상품 가격 -->
                        	<h6>주문 목록</h6>
                        	<table class="styled-table">
                        		<thead>
	                        		<tr>
	                        			<th>주문 번호</th>
	                        			<th>이름</th>
	                        			<th>전화번호</th>
	                        			<th>주문 날짜</th>
	                        			<th>상품 가격</th>
	                        		</tr>
	                        	</thead>
	                        	<tbody>
	                        		<c:forEach var ="order" items="${orderList }" varStatus="status">
	                        	
	                        		<tr>
	                        			<td><c:out value="${order.item_idx }" /></td>
	                        			<td><c:out value="${order.name }" /></td>
	                        			<td><c:out value="${order.phone }" /></td>
	                        			<td><c:out value="${order.moment }" /></td>
	                        			<td><c:out value="${order.price }" /></td>
	                        		</tr>
	                        	</c:forEach>
                        		</tbody>
                        	</table>
                        </div>
          	 	 </div>
            <!-- End of Main Content -->
          <!-- Footer -->
      		<footer class="sticky-footer bg-white">
		          <div class="container my-auto">
		              <div class="copyright text-center my-auto">
		                  <span>Copyright &copy; olive ung 2024</span>
		              </div>
		          </div>
      		</footer>
      		<!-- End of Footer -->
       </div>
    
</div>
         

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>
</form>
</body>
</html>