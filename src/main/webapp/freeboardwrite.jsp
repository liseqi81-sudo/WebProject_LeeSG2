<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    HttpServletRequest req = request; // request 내장객체를 req로 사용
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin 2 - 자유게시판 글쓰기</title>

<!-- CSS -->
<link href="<%=req.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="<%=req.getContextPath()%>/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body id="page-top">
    <div id="wrapper">
        <%@ include file="/include/SideBar.jsp" %>

        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <jsp:include page="/include/TopBar.jsp" /> 

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <h1 class="h3 mb-4 text-gray-800">자유게시판 - 글쓰기</h1>

                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <form method="post" action="<%=req.getContextPath()%>/freeboard_write.do">
                                <div class="form-group">
                                    <label>제목</label>
                                    <input type="text" name="title" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>내용</label>
                                    <textarea name="content" class="form-control" rows="5"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>작성자</label>
                                    <input type="text" name="id" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-primary">작성</button>
                                <button type="reset" class="btn btn-secondary">초기화</button>
                                <button type="button" class="btn btn-info" onclick="location.href='<%=req.getContextPath()%>/freeboard/list.do'">목록</button>
                            </form>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2025</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

    <!-- JS -->
    <script src="<%=req.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=req.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="<%=req.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="<%=req.getContextPath()%>/js/sb-admin-2.min.js"></script>

</body>
</html>
