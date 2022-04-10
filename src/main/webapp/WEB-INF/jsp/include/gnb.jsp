<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="d-flex justify-content-between align-items-center">
	<h1 class="font-weight-bold m-4 ">전자도서관</h1>
	
	<div class="search-box d-flex justify-content-center w-50">
		<input type="text" id="searchText" class="form-control border-0 ml-5" placeholder="검색어를 입력하세요.">
		<button type="button" id="searchBtn" class="btn btn-light">검색</button>
	</div>
	<div id="emptyUserBox" class="mr-2"></div>
	<%-- <c:if test="${empty userName">	
		<div id="emptyUserBox" class="mr-2"></div>
	</c:if> --%>
	<c:if test="${not empty userName}">
	<div class="user-info d-flex">
		<a href=""><img src="https://www.iconninja.com/files/373/816/921/setting-icon.png" alt="환경설정" width="30" height="30" class="mr-3"></a>
		<a href="/mypage/mypage_view/${userLoginId}"><span class="font-weight-bold d-1">${userName}님</span></a>
		<a href="/user/sign_out" class="ml-2 text-secondary font-weight-bold"><small>로그아웃</small></a>
	</div>
	</c:if>
	
</div>