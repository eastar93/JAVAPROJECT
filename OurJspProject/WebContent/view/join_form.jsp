<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	input{border:1px solid #58D3F7;}
</style>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<div align="center"><h1>회원가입 페이지</h1></div>
		<form action ="#" method="post">
	<div align="center">
		<input type="text" name = "id" placeholder="아이디를 입력해주세요" size = "30"><br/>
		<input type="password" name = "pw" placeholder="패스워드를 입력해주세요" size = "30"><br/>
		<input type="text" name = "name" placeholder="이름을 입력해주세요" size = "30"><br/>
		<input type="email" name = "email" placeholder="이메일을 입력해주세요" size = "30"><br/>
		<input type="text" name = "birth" placeholder="생일을 입력해주세요" size = "30"><br/>
		<input type="radio" name = "gender" value="male">남
		<input type="radio" name = "gender" value="female">여<br/><br/>
		<input type="submit" value="회원가입하기">
	</div>		
</form>
</body>
</html>