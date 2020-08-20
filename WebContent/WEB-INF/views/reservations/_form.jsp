<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">会議室</label><br />
<input type="text" name="room_id" value="${reservations.room_id}" /><br>
<label for="title">予約者</label><br />
<input type="text" name="name" value="${reservations.name}" />
<%-- <br /><br />

<label for="content">メッセージ</label><br />
<input type="text" name="content" value="${message.content}" />
<br /><br />
--%>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">予約</button>