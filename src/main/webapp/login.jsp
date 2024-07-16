<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10"></script>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>


<style type="text/css">

@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}


<%@ include file="css/styles.css" %>

</style>
<script type="text/javascript">

function validateID(){
	var targetID = $("#id").val();
	const regExpression = /[a-zA-Z0-9]/g;
	if (!regExpression.test(targetID))
		swal.fire("영어 숫자만 가능합니다.");
	
	$.ajax({
		type:"post",
		async:false,
		url:"${contextPath}/validateID",
		dataType:"text",
		data:{id:targetID},
		success:function(data, textStatus){
			if (data == 'usable')
				alert("사용가능");
			else
				alert("사용불가");
		},
		error:function(data, textStatus){
			alert(data + "에러발생");
		},
		complete:function(data, textStatus){
			
		}
	});
}

$(document).ready(function() {
       // 암호 확인 기능 구현
        $('#pw_confirm').keyup(function() {
            var out = "<b>비밀번호가 맞습니다.</b>";
        	$('#pw_message').text('');
        	if ($('#pw').val() != $('#pw_confirm').val())
            	out = "<b>비밀번호가 틀립니다.</b>";
    		$('#pw_message').html(out); 
        });
       
        $('.message a').click(function(){
     	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
     	});
        
        $('.adminLogin a').click(function(){
      	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
      	});
       
    });
</script>
<meta charset="UTF-8">
<title>Landing page</title>
</head>
<body>

<jsp:include page="header.jsp" />
<hr>
<div class="login-page">
  <div class="form">
    <form class="register-form" action="${contextPath}/hashPassword/join.do" method="post">
      	<label for="id">아이디:</label>
        <input type="text" id="id" name="id" required>
        <input type="button" value="ID중복확인" id="double" onclick="validateID()">
        
        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br>
        <label for="pw">비밀번호확인:</label>
        <input type="password" name="pw_confirm" id="pw_confirm" >
        <div id="pw_message"></div>
        
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone" required><br>
        
        <label for="male">남성</label>
        <input type="radio" id="male" name="gender" value="M" required>
        <label for="female">여성</label>
        <input type="radio" id="female" name="gender" value="F" required>
        
        
        <label for="address">주소:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="birthday">생일:</label>
        <input type="text" minlength="6" maxlength="6" name="birthday" required><br>
        <input type="submit" value="가입하기">
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form" action="login" method="post">
      <c:if test="${ requestScope.error != null }"><h3>${ requestScope.error }</h3></c:if>
      <input type="text" name="id" placeholder="ID"/>
      <input type="password" name="pw" placeholder="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
      <p class="adminLogin">admin Login: <a href="adminLogin.jsp">admin</a></p>
  </div>
</div>

	<footer class="py-5 bg-dark">
       		<jsp:include page="footer.jsp" />
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; olive ung  2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>