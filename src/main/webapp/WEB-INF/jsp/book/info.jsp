<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="d-flex justify-content-center">
	<div class="width-fix m-5 p-5"> 
		<div class="d-flex justify-content-center">
			<div class="col-3 m-5">
				<img src="#" alt="도서 이미지" width="150" height="100">
			</div>
			<div id="bookInfoBox" class="">
				<h1>도서 제목</h1>
				<h3>저자 : 저자이름</h3>
				<span class="font-weight-bold">출판사 이름 | 2022년 출간</span><br>
				<span>페이지 수 : 200p </span><br>
				<span>isbn : 00000000000</span><br>
				<span>도서 상태:</span>
				<span>
					<c:choose>
					</c:choose>
				</span>
				<c:if> <!-- 도서 borrow 상태일 경우 -->
					<span>도서 대출 가능일:</span>
				</c:if>
				<div class="d-flex justify-content-center">
				<!-- 대출 가능 상태일 때 대출 버튼 -->
					<button></button>
				<!-- 대출 불가 상태일 때 예약 버튼 -->
					<button></button>
					<a href="#"><img src="#" alt="즐겨찾기"></a>
					<!-- 즐겨찾기 버튼 -->
					<div id="resultBookmark">
						<c:if test="${search.filledBookmark eq true}">
						채워진 별
						</c:if>
						<c:if test="${search.filledBookmark eq false}">
						비워진 별
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div id="bookDescriptionBox">
			<h1>도서 정보</h1>
			<p>도서 정보 내용</p>
		</div>
	</div>
</div>