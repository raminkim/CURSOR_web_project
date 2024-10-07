<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
</head>
<body id="container">
<!-- <%
    HttpSession existingSession = request.getSession(false); // 세션 가져오기
    String name = (String) existingSession.getAttribute("name"); // 세션에서 name 가져오기
    
    if (existingSession != null && name != null) {
%> -->
        <h2>로그인 되었습니다.</h2>
<!-- <%
    } else {
%>
        <h2>로그인되지 않았습니다.</h2>
        <a href="/Mainlogin">로그인 하러가기</a>
<%
    }
%> -->
</body>
</html>