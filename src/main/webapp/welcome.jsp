<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="member.MemberDTO" %>
<%@ page session="true" %>
<%
    // 세션에서 로그인 정보 가져오기
    MemberDTO user = (MemberDTO) session.getAttribute("loginUser");
    if(user == null) {
        response.sendRedirect("login.jsp"); // 로그인 안 되어 있으면 로그인 페이지로
        return;
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>환영합니다</title>
</head>
<body>
    <h2>환영합니다, <%= user.getName() %>님!</h2>
    <p>아이디: <%= user.getId() %></p> <!-- 디버그용: 세션 정보 확인 -->
    <a href="logout.do">로그아웃</a>
</body>
</html>
