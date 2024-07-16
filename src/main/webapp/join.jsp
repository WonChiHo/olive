<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10"></script>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
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
				if (data == 'usable'){
					swal.fire("사용가능");
				}
				else
					swal.fire("사용불가");
			},
			error:function(data, textStatus){
				
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
	       
	      
	       
        });

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 양식</h2>
    <form action="join" method="post">
        <label for="id">아이디:</label>
	        <div id="user_id">
		        <input type="text" id="id" name="id" required>
		        <input type="button" value="ID중복확인" id="double" onclick="validateID()">
			</div>		
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
        
        <label for="gender">성별:</label>
        <input type="radio" id="male" name="gender" value="M" required>
        <label for="male">남성</label>
        <input type="radio" id="female" name="gender" value="F" required>
        <label for="female">여성</label><br>
        
        <label for="address">주소:</label>
        <input type="text" id="address" name="address" required><br>
        
        
       	<input type="submit" value="가입하기">
    	
    </form>
</body>
</html>