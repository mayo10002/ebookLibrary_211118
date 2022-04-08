<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="d-flex justify-content-center">
	<div class="w-75 bg-warning d-flex justify-content-center">
		<div id="bookRecommend col-8">
			<div><h2>신간 도서</h2></div>
			<div class="d-flex justify-content-center">
				<div class="latest-book bg-secondary">
					<img src="#" alt="표지" width="120" height="180">
				</div>
			</div>
		</div>
		<div id="userSelect bg-secondary col-4">
			<div><span>${userName}님의<br>대출 현황을 확인하세요.</span></div>
			<button type="button" id="myPageBtn" class="btn btn-primary w-100">마이페이지</button>
		</div> 
	</div>
</div>