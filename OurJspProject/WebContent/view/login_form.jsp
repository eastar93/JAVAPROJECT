<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<div align="center"><h1>로그인</h1>
	<form action="#" method="post">
	<input type="text" name="id" placeholder="아이디를 입력해주세요" size = "30"><br/><br/>
	<input type="password" name="pw" placeholder="비밀번호를 입력해주세요" size = "30"><br/><br/>
	<input type="submit" value = "로그인">&nbsp;
	<a href	="http://localhost:8181/OurJspProject/view/join_form.jsp"><input type ="button" value="회원가입"></a>
	</form>
	</div>
</body>
</html>