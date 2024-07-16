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

    <title>[Admin]memberModify</title>

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
<form name="memberModifyForm" action="<c:url value="/MemberModifyServlet" />" method="post">
<input type="hidden" name="idx" value="<c:out value="${membervo.idx}" />" />

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
								<table class="styled-table">
								<h3>회원 수정</h3>
								<!--  입력한 값 가져오기, 이름/멤버십 등급 수정가능 -->
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">아이디</td>
									<td><input type="text" name="id" class="form-control" style="width: 70%;" value="<c:out value="${membervo.id }" />" readonly> </td>
								</tr>		
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">비밀번호</td>
									<td><input type="text" name="pw" class="form-control" style="width: 70%;" value="<c:out value="${membervo.pw }" />" readonly> </td>
								</tr>	
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">이름</td>
									<td><input type="text" name="name" class="form-control" style="width: 70%;" value="<c:out value="${membervo.name }" />" > </td>
								</tr>	
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">이메일</td>
									<td><input type="text" name="email" class="form-control" style="width: 70%;" value="<c:out value="${membervo.email }" />" readonly> </td>
								</tr>
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">전화번호</td>
									<td><input type="text" name="phone" class="form-control" style="width: 70%;" value="<c:out value="${membervo.phone }" />" readonly> </td>
								</tr>
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">성별</td>
									<td><input type="text" name="gender" class="form-control" style="width: 70%;" value="<c:out value="${membervo.gender }" />" readonly> </td>
								</tr>
								<tr>
									<td style="width: 150px; background-color:rgb(123,125,135); color:#ffffff;">멤버십 등급</td>
									<td><input type="text" name="level" class="form-control" style="width: 70%;" value="<c:out value="${membervo.level }" />"> </td>
								</tr>		
								<tr>
									<td colspan="2" align="center">
										<button type="submit" class="btn btn-info" id="btnadd" style="width: 100px; background-color:rgb(123,125,125); border:none;" >확인</button>
										<button type="button" class="btn btn-info" style="width: 100px; background-color:rgb(123,125,125); border:none;" onclick="location.href='<c:url value="/MemberListServlet"/>'" >취소</button>
									</td>
								</tr>
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