<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="d-flex justify-content-center">
	<div class="w-75 d-flex justify-content-center">
		<div id="bookRecommend col-8">
			<div><h2>신간 도서</h2></div>
			<div class="d-flex">
				<c:forEach items="${latestBook}" var="latest">
					<div class="d-flex justify-content-center mx-1 my-3">
						<div class="latest-book bg-secondary">
						<!-- 신간 추천 -->
							<a href="/search/info_view/${latest.id}"><img src="${latest.imagePath}" alt="표지" width="120" height="180" class="ml-4 pl-3"></a><br>
							<a href="/search/info_view/${latest.id}"><span class="font-weight-bold">${latest.name}</span></a><br>
							<span>${latest.author}</span><br>
							<span>${latest.publisher}</span>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div><h2>추천 도서</h2></div>
			<div class="d-flex">
				<c:forEach items="${recommendBook}" var="recommend">
					<div class="d-flex justify-content-center mx-1 my-3">
						<div class="recommend-book bg-secondary">
						<!-- 연관 추천 :최근에 빌렸던 책 하나의 category와 동일한 category의 책을 신간 순으로 골라 추천한다.-->
							<a href="/search/info_view/${recommend.id}"><img src="${recommend.imagePath}" alt="표지" width="120" height="180" class="ml-4 pl-3"></a><br>
							<a href="/search/info_view/${recommend.id}"><span class="font-weight-bold">${recommend.name}</span></a><br>
							<span>${recommend.author}</span><br>
							<span>${recommend.publisher}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="userSelect" class="col-4 p-3 m-3" >
			<c:if test="${not empty userName}">
				<div><span class="d-3 font-weight-bold  m-2">${userName}님의<br>대출 현황을 확인하세요.</span></div>
				<button type="button" id="myPageBtn" data-user-id="${userId}" class="btn btn-primary w-100 m-2">마이페이지</button>
			</c:if>
			<div><span class="d-3 font-weight-bold m-2">신청하고 싶은 도서가 있나요?</span></div>
			<c:if test="${not empty userName}">
				<button type="button" id="applyCreateViewBtn" class="btn btn-primary w-100 m-2">희망 도서 신청</button>
			</c:if>
			<button type="button" id="applyListViewBtn" class="btn btn-primary w-100 m-2">희망 도서 신청 목록</button>
		</div> 
	</div>
</div>

<script>
$(document).ready(function(){
	$('#myPageBtn').on('click',function(e){
		let userId = $(this).data('user-id');
		location.href="/mypage/"+userId;
	});
	$('#applyCreateViewBtn').on('click',function(e){
		location.href="/apply/apply_create_view";
	});
	$('#applyListViewBtn').on('click',function(e){
		location.href="/apply/apply_list_view";
	});
});
</script>