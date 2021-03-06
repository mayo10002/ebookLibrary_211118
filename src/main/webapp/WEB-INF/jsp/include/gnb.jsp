<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="d-flex justify-content-between align-items-center">
	<a href="/book/main_view" src="대문 이동"><h1 class="font-weight-bold m-4 ">전자도서관</h1></a>
	<form id="searchForm" method="get" action="/search/search_list_view">
		<div class="search-box d-flex justify-content-center">
			<input type="text" id="searchText" name="searchText" class="border-0 ml-3 search-box-width" placeholder="검색어를 입력하세요.">
			<button type="submit" id="searchBtn" class="btn btn-light">검색</button>
		</div>
	</form>
	<c:if test="${empty userName}">
		<div id="emptyUserBox" class="mr-2">
			<a href="/user/sign_in_view" class="font-weight-bold">로그인</a>
		</div>
	</c:if>
	<c:if test="${not empty userName}">
	<div class="user-info d-flex">
		<a href="/user/edit_view"><img src="https://www.iconninja.com/files/373/816/921/setting-icon.png" alt="환경설정" width="30" height="30" class="mr-3"></a>
		<a href="/mypage/${userId}"><span class="font-weight-bold d-1">${userName}님</span></a>
		<a href="/user/sign_out" class="ml-2 font-weight-bold"><small class="mr-2">로그아웃</small></a>
	</div>
	</c:if>
	
</div>


<script>
$(document).ready(function(){
	$('#searchBtn').on('click',function(e){
		let searchText = $('#searchText').val().trim();
	
		if (searchText == ''){
			alert('검색어를 입력해주세요.');
			e.preventDefault();
		}
		
		
	});
});
</script>