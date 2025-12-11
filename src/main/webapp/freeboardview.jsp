<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글보기</title>
<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/include/SideBar.jsp" />
<jsp:include page="/include/TopBar.jsp" />

<div class="container-fluid">
    <h2 class="h3 mb-4 text-gray-800">자유게시판 - 글보기</h2>

    <table class="table table-bordered" width="90%">
        <tr>
            <td>번호</td>
            <td>${dto.num}</td>
            <td>작성자</td>
            <td>${dto.id}</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>${dto.postdate}</td>
            <td>조회수</td>
            <td>${dto.visitcount}</td>
        </tr>
        <tr>
            <td>제목</td>
            <td colspan="3">${dto.title}</td>
        </tr>
        <tr>
            <td>내용</td>
            <td colspan="3" height="200">${dto.content}</td>
        </tr>
        <tr>
            <td colspan="4" class="text-center">
                <button type="button" class="btn btn-primary"
                        onclick="location.href='${pageContext.request.contextPath}/freeboard/edit.do?num=${dto.num}'">
                    수정
                </button>
                <button type="button" class="btn btn-danger"
                        onclick="location.href='${pageContext.request.contextPath}/freeboard/delete.do?num=${dto.num}'">
                    삭제
                </button>
                <button type="button" class="btn btn-secondary"
                        onclick="location.href='${pageContext.request.contextPath}/freeboard/list.do'">
                    목록
                </button>
            </td>
        </tr>
    </table>
</div>

<jsp:include page="/include/Bottom.jsp" />
</body>
</html>
