<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>[Admin]member</title>

    <script>
    function changeModifyColor() {
        document.getElementById("modifyButton").style.backgroundColor = "rgb(80, 80, 80)"; 
     
    }
    function changeDeleteColor() {
        document.getElementById("deleteButton").style.backgroundColor = "rgb(80, 80, 80)"; 
     
    }

    function restoreModifyColor() {
        document.getElementById("modifyButton").style.backgroundColor = "rgb(123, 125, 125)"; 

    }
    function restoreDeleteColor() {
        document.getElementById("deleteButton").style.backgroundColor = "rgb(123, 125, 125)"; 

    }
    </script>
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

                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                       
                    </div>

                    <!-- Content Row -->
                 
                   <!-- 문의 목록 -->
                      	<div class="row">
                        <div class="col-xl-12">
                       	<!-- 아이디, 비밀번호, 이름, 이메일, 전화번호, 멤버십 등급, 성별-->
                        	<h3>회원 목록</h3>
                        	<table class="styled-table">
                        		<thead>
	                        		<tr>
	                        			<th>아이디</th>
	                        			<th>비밀번호</th>
	                        			<th>이름</th>
	                        			<th>이메일</th>
	                        			<th>전화번호</th>
	                        			<th>성별</th>
	                        			<th>멤버십 등급</th>
	                        			<th>수정 / 삭제</th>
	                        	<!-- 		<th>상품 할인율</th> -->
	                        		</tr>
	                        	</thead>
	                        	<tbody>
	                        	<c:forEach var="member" items="${memberList }" varStatus="status">
	                        		<tr>
	                        			<td><c:out value="${member.id }" /></td>
	                        			<td><c:out value="${member.pw }" /></td>
	                        			<td><c:out value="${member.name }" /></td>
	                        			<td><c:out value="${member.email }" /></td>
	                        			<td><c:out value="${member.phone }" /></td>
	                        			<td><c:out value="${member.gender }" /></td>
	                        			<td><c:out value="${member.level }" /></td>
	                        			<td> 
	                        				<button type="button" class="btn btn-info" id="modifyButton" style="width: 70px; background-color:rgb(123,125,125); border:none;" onclick="location.href='<c:url value="/MemberModifyServlet?idx=${member.idx}"/>'" onmouseover="changeModifyColor()" onmouseout="restoreModifyColor()">수정</button>                  	
											<button type="button" class="btn btn-info" id="deleteButton" style="width: 70px; background-color:rgb(123,125,125); border:none;" onclick="location.href='<c:url value="/MemberDeleteServlet?idx=${member.idx}"/>'" onmouseover="changeDeleteColor()" onmouseout="restoreDeleteColor()">삭제</button>
											
	                        			</td>
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