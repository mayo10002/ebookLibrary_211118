<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="width-fix m-5 p-5"> 
		<div class="d-flex justify-content-center">
		
			<div class="col-3 m-5">
				<img src="${searchBookInfo.book.imagePath}" alt="도서 이미지" width="150" height="100">
			</div>
			<div id="bookInfoBox" class="">
				<h1>${searchBookInfo.book.name}</h1>
				<h3>저자 : ${searchBookInfo.book.author}</h3>
				<span class="font-weight-bold">${searchBookInfo.book.publisher} | ${searchBookInfo.book.publishDate} 출간</span><br>
				<span>페이지 수 : ${searchBookInfo.book.page}p </span> | 분류: 총류<br>
				<span>isbn : ${searchBookInfo.book.isbn}</span><br>
				<span>도서 상태:</span>
				<span>
					<c:choose>
					</c:choose>
				</span>
				<c:if> <!-- 도서 borrow 상태일 경우 -->
					<span>도서 대출 가능일:${searchBookInfo.book.isbn}</span>
				</c:if>
				<div class="d-flex justify-content-center">
				<!-- 대출 가능 상태일 때 대출 버튼 -->
					<button></button>
				<!-- 대출 불가 상태일 때 예약 버튼 -->
					<button></button>
					
					<!-- 즐겨찾기 버튼 -->
					<div id="resultBookmark">
						<c:if test="${searchBookInfo.filledBookmark eq true}">
						채워진 별
						</c:if>
						<c:if test="${searchBookInfo.filledBookmark eq false}">
						비워진 별
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div id="bookDescriptionBox">
			<h1>도서 정보</h1>
			<p>${searchBookInfo.book.info}</p>
		</div>
	</div>
</div>