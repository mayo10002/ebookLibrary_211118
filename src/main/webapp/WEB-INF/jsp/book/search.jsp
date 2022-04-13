<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="width-fix m-5 p-5">
	<div class="mb-4"><span class="font-weight-bold">검색 결과 3건</span></div> <!-- list count 넣어야 한다. -->
	<div>
		<div id="searchResultList" class="d-flex justify-content-center align-items-center my-3">
			<div id="resultBookImage"><a href="/book/info/${bookId}"><img src="#" alt="도서 이미지" width="120" height="80"></a></div>
			<div id="resultBookInfo" class="mx-3">
				<div><a href="/book/info/${bookId}"><span class="font-weight-bold font-size-larger">${bookName}</span></a></div>
				<div>${bookAuthor} 지음</div>
				<div>${bookPublisher} | ${bookPublishDate} 출간</div> <!-- c:format date에 쓰기 -->
			</div>
			<div id="resultBookstate" class="my-2 font-weight-bold">도서 상태:
			<!-- c:choose 써서 span text 색깔 바꿔서 표시하기 -->
			 </div>
			<div id="resultBookmark"></div>
		</div>
	</div>
</div>