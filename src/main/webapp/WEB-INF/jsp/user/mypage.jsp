<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="button-box d-flex justify-content-center ml-4">
			<button type="button" id="calendarViewBtn" class="btn btn-primary p-2 mr-4">캘린더 보기</button>
			<button type="button" id="bookmarkViewBtn" class="btn btn-secondary p-2">즐겨찾기 목록</button>
		</div>
		<div id="myBorrowList" class="d-flex justify-content-center align-items-center my-3">
			<div><a href=""><img src="#"></a></div>
			<div id="borrowBookInfo">
			
			</div>
		</div>
	</div>
</div>