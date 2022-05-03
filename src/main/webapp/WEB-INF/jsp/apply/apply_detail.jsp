<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="detailBox">
				<span class="apply-font-design mr-5">신청자:${detailview.user.name}</span>
				<span class="apply-font-design">신청 날짜: <fmt:formatDate value="${detailview.apply.createdAt}" pattern="yyyy-MM-dd" /></span>
				<br>
				<span class="apply-font-design">제목: ${detailview.apply.bookName}</span>
				<br>
				<span class="apply-font-design">저자: ${detailview.apply.bookAuthor}</span>
				<br>
				<span class="apply-font-design">출판사: ${detailview.apply.bookPublisher}</span>
				<br>
				<span class="apply-font-design">출판년도: <fmt:formatDate value="${detailview.apply.bookPublishDate}" pattern="yyyy" /></span>
				<c:if test="${userId eq detailview.user.id}">
					<button type="button" class="btn btn-danger" id="deleteBtn">삭제</button>
				</c:if>
			</div>
		</div>
	</div>
</div>