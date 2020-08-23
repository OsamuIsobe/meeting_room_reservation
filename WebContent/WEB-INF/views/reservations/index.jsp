<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>会議室予約</h2>
        <ul>
            <c:forEach var="reservation" items="${reservations}">
                <li>
                    <%-- <a href="${pageContext.request.contextPath}/show?id=${reservation.id}"> --%>
                    <a href="${pageContext.request.contextPath}/index_room_A">A</a><br/>
                    B<br/>
                    C<br/>
                        <%-- <c:out value="${reservation.room_name}" /> --%>
                    <%--</a>
                     ：<c:out value="${reservation.reserver}"></c:out> --%>
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">予約登録</a></p>

    </c:param>
</c:import>