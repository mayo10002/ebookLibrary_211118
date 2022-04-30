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
		<!-- 대출 목록 -->
		<div id="myBorrowList" class="d-flex justify-content-center align-items-center my-3">
			<div><a href=""><img src="#" alt="도서 이미지" width="100" height="150"></a></div>
			<div id="borrowBookInfo">
				<div><a href="/search/info_view/${search.book.id}"><span class="font-weight-bold font-size-larger">${search.book.name}</span></a></div>
				<div>지은이 지음</div>
				<div>출판사 | 
				<fmt:formatDate var="publishDate" value="${search.book.publishDate}" pattern="yyyy-MM-dd" />날짜 출간</div>
				<div>분류: 카테고리</div>
			</div>
			<div>
				<div>반납 예정일: returnAt </div>
				<button type="button" class="borrowDeleteBtn btn btn-danger">반납하기</button>
				<button type="button" class="borrowExtendBtn btn btn-warning">연장하기</button>
			</div>
		</div>
		<hr>
		<!-- 예약 목록 -->
		<div id="reserveList" class="d-flex justify-content-center align-items-center my-3">
			<div><a href=""><img src="#" alt="도서 이미지" width="100" height="150"></a></div>
			<div id="borrowBookInfo">
				<div><a href="/search/info_view/${search.book.id}"><span class="font-weight-bold font-size-larger">${search.book.name}</span></a></div>
				<div>지은이 지음</div>
				<div>출판사 | 
				<fmt:formatDate var="publishDate" value="${search.book.publishDate}" pattern="yyyy-MM-dd" />날짜 출간</div>
				<div>분류: 카테고리</div>
			</div>
			<div>
				<div>대출 가능 예정일: returnAt </div>
			</div>
		</div>
		<!-- 즐겨찾기 목록 -->
		<div id="bookmarkList" class="d-flex justify-content-center align-items-center my-3">
			<div><a href=""><img src="#" alt="도서 이미지" width="100" height="150"></a></div>
			<div id="borrowBookInfo">
				<div><a href="/search/info_view/${search.book.id}"><span class="font-weight-bold font-size-larger">${search.book.name}</span></a></div>
				<div>지은이 지음</div>
				<div>출판사 | 
				<fmt:formatDate var="publishDate" value="${search.book.publishDate}" pattern="yyyy-MM-dd" />날짜 출간</div>
				<div>분류: 카테고리</div>
			</div>
			<div>
				<div>책 상태:</div>
				<div>대출하기</div>
				<div>예약하기</div>
			</div>
		</div>
	</div>
</div>