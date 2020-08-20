<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>id : ${reservation.id} の予約詳細ページ</h2>

        <p>会議室：<c:out value="${reservation.room_id}" /></p>
        <p>予約者：<c:out value="${reservation.name}" /></p>
        <p>予約時間：<fmt:formatDate value="${reservation.reserve_time}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${reservation.id}">この予約を編集する</a></p>

    </c:param>
</c:import>