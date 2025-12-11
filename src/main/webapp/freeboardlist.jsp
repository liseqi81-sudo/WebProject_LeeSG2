<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>자유게시판 목록</title>

    <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">

    <style>a{text-decoration:none;}</style>
</head>

<body id="page-top">

<div id="wrapper">

    <!-- 사이드바 -->
    <%@ include file="/include/SideBar.jsp" %>

    <!-- 본문 영역 -->
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">

            <!-- 상단 네비바 -->
            <jsp:include page="/include/TopBar.jsp" />

            <div class="container-fluid">

                <h1 class="h3 mb-4 text-gray-800">자유게시판</h1>

                <!-- 검색 영역 -->
                <form method="get" action="${pageContext.request.contextPath}/freeboard/list.do">
                    <div class="card mb-4 shadow">
                        <div class="card-body">
                            <div class="row">

                                <div class="col-md-2">
                                    <select name="searchField" class="form-control">
                                        <option value="title">제목</option>
                                        <option value="content">내용</option>
                                    </select>
                                </div>

                                <div class="col-md-8">
                                    <input type="text" name="searchWord" class="form-control" placeholder="검색어 입력">
                                </div>

                                <div class="col-md-2">
                                    <button type="submit" class="btn btn-primary btn-block">검색</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </form>

                <!-- 목록 테이블 -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">게시글 목록</h6>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <thead>
                                    <tr align="center">
                                        <th width="8%">번호</th>
                                        <th width="*">제목</th>
                                        <th width="15%">작성자</th>
                                        <th width="10%">조회수</th>
                                        <th width="15%">작성일</th>
                                        <th width="8%">첨부</th>
                                    </tr>
                                </thead>

                                <tbody>

                                    <!-- 게시물이 없을 때 -->
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="6" align="center">등록된 게시물이 없습니다.</td>
                                        </tr>
                                    </c:if>

                                    <!-- 게시물이 있을 때 -->
                                    <c:forEach var="row" items="${list}">
                                        <tr align="center">

                                            <td>${row.num}</td>

                                            <td align="left">
                                                <a href="${pageContext.request.contextPath}/freeboard/read.do?num=${row.num}">
                                                    ${row.title}
                                                </a>
                                            </td>

                                            <td>${row.id}</td>
                                            <td>${row.visitcount}</td>
                                            <td>${row.postdate}</td>

                                            <td></td>

                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </div>

                        <!-- 페이징 -->
                        <div class="text-center mt-3">
                            ${paging}
                        </div>

                        <!-- 글쓰기 버튼 -->
                        <div class="text-right mt-3">
                            <button type="button" class="btn btn-primary"
                                onclick="location.href='${pageContext.request.contextPath}/freeboard_write.do'">
                                글쓰기
                            </button>
                        </div>

                    </div>
                </div>

            </div> <!-- container-fluid -->
        </div> <!-- content -->

        <!-- 푸터 -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright © Your Website 2025</span>
                </div>
            </div>
        </footer>

    </div> <!-- content-wrapper -->
 
</div> <!-- wrapper -->

<%@ include file="/include/Bottom.jsp" %>

</body>
</html>
