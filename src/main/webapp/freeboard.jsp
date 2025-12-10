<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model2.mvcboard.BoardDTO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin 2 - 자유게시판</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
<div id="wrapper">
 <%@ include file="/include/SideBar.jsp" %>
 <div id="content-wrapper" class="d-flex flex-column">
     <div id="content">
         <jsp:include page="/include/TopBar.jsp" />
         <div class="container-fluid">
            
 <!-- 컨텐츠 추가 부분s -->
 <h1 class="h3 mb-4 text-gray-800">자유게시판</h1>

<div class="container-fluid">
 <div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">게시글 목록</h6>
  </div>
   <div class="card-body">
     <div class="table-responsive">
    <table class="table table-bordered" width="100%" cellspacing="0">
     <thead>
       <tr>
         <th>글번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>작성일</th>
         <th>조회수</th>
       </tr>
     </thead>
     <tbody>
         <%
             List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
             if(list != null && !list.isEmpty()) {
                 for(BoardDTO dto : list) {
         %>
         <tr>
             <td><%= dto.getNum() %></td>
             <td><a href="read.do?num=<%=dto.getNum()%>"><%= dto.getTitle() %></a></td>
             <td><%= dto.getId() %></td>
             <td><%= dto.getPostdate() %></td>
             <td><%= dto.getVisitcount() %></td>
         </tr>
         <%
                 }
             } else {
         %>
         <tr>
             <td colspan="5" align="center">글이 없습니다.</td>
         </tr>
         <%
             }
         %>
     </tbody>
    </table>
         <button type="button" onclick="location.href='freeboardwrite.jsp'">글쓰기</button>
     </div>
   </div>
  </div>
 </div>
 <!-- 컨텐츠 추가 부분e -->
         </div>
     </div>
     <footer class="sticky-footer bg-white">
         <div class="container my-auto">
             <div class="copyright text-center my-auto">
                 <span>Copyright &copy; Your Website 2025</span>
             </div>
         </div>
     </footer>
 </div>
</div>
<%@ include file="/include/Bottom.jsp" %>
</body>
</html>
