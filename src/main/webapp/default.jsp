<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olive?ung</title>
<script type="text/javascript">
function goRanking(){
	document.location="ranking/rankingList";
}

function delReview(){
	document.location="review/reviewDelete?idx=6";
}
</script>
</head>
<body>
	<button style="width:100px; height:100px;" onClick="goRanking()">랭킹</button>
	<button style="width:100px; height:100px;" onClick="delReview()">리뷰 삭제</button>
</body>
</html>