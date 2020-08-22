<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">会議室</label><br />
<div>
    <select name="room_name">
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
    </select>
</div><br />
<label for="reserver">予約者</label><br />
<input type="text" name="reserver" value="${reservations.reserver}" />
<br /><br />

<label for="start_time">開始時間</label><br />
<input type="datetime-local" name="start_time" value="${reservations.start_time}" pattern='yyyy-MM-dd hh:mm:ss' />
<br /><br />

<label for="finish_time">終了時間</label><br />
<input type="datetime-local" name="finish_time" value="${reservations.start_time}" pattern='yyyy-MM-dd hh:mm:ss' />
<br /><br />

<label for="comment">内容</label><br />
<textarea name="comment" rows="10" cols="50">${reservations.comment}</textarea>
<br /><br />

<br />
<br />
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">予約</button>