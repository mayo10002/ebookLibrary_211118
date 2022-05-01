<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="button-box d-flex justify-content-center ml-4">
			<button type="button" id="calendarViewBtn" class="btn btn-primary p-2 mr-4">캘린더 보기</button>
			<button type="button" id="bookmarkViewBtn" class="btn btn-secondary p-2">즐겨찾기 목록</button>
			<button type="button" id="borrowReserveViewBtn" class="btn btn-warning p-2 d-none">대출/예약 목록</button>
		</div>
		<!-- 대출/ 예약 상자 -->
		<div id="borrowReserveBox">
		<!-- 대출 목록 -->
			<c:forEach items="${borrowViewList}" var="borrow">
				<div class="borrow-list d-flex align-items-center my-3">
					<div><a href="/search/info_view/${borrow.book.id}"><img src="${borrow.book.imagePath}" alt="도서 이미지" width="100" height="150"></a></div>
					<div class="borrowBookInfo mypage-box-width">
						<div><a href="/search/info_view/${borrow.book.id}"><span class="font-weight-bold font-size-larger">${borrow.book.name}</span></a></div>
						<div>${borrow.book.author} 지음</div>
						<div>출판사 | 
						<fmt:formatDate var="publishDate" value="${borrow.book.publishDate}" pattern="yyyy-MM-dd" />${publishDate} 출간</div>
						<div>분류: ${borrow.category.categoryName}</div>
					</div>
					<div>
						<div>반납 예정일: <fmt:formatDate var="returnInfo" value="${borrow.returnInfo}" pattern="yyyy-MM-dd" />${returnInfo} </div>
						<div class="d-flex justify-content-center">
							<button type="button" class="borrowDeleteBtn btn btn-danger mx-2" data-book-id="${borrow.book.id}">반납하기</button>
							<button type="button" class="borrowExtendBtn btn btn-warning" data-book-id="${borrow.book.id}">연장하기</button>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<hr>
			<!-- 예약 목록 -->
			<c:forEach items="${reserveViewList}" var="reserve">
				<div class="reserve-list d-flex align-items-center my-3">
					<div><a href="/search/info_view/${reserve.book.id}"><img src="${reserve.book.imagePath}" alt="도서 이미지" width="100" height="150"></a></div>
					<div class="reserveBookInfo mypage-box-width">
						<div><a href="/search/info_view/${reserve.book.id}"><span class="font-weight-bold font-size-larger">${reserve.book.name}</span></a></div>
						<div>${reserve.book.author} 지음</div>
						<div>출판사 | 
						<fmt:formatDate var="publishDate" value="${reserve.book.publishDate}" pattern="yyyy-MM-dd" />${publishDate} 출간</div>
						<div>분류: ${reserve.category.categoryName}</div>
						<div>반납 예정일: <fmt:formatDate var="returnInfo" value="${reserve.returnInfo}" pattern="yyyy-MM-dd" />${returnInfo} </div>
					</div>
				</div>
				<button type="button" class="reserveDeleteBtn btn btn-danger mx-2" data-book-id="${reserve.book.id}">예약 취소</button>
			</c:forEach>
		</div>
		<hr>
		<!-- 즐겨찾기 목록 -->
		<div id="bookmarkBox" class="d-none">
			<c:forEach items="${bookmarkViewList}" var="bookmark">
				<div class="bookmark-list d-flex align-items-center my-3">
					<div><a href="/search/info_view/${bookmark.book.id}"><img src="${bookmark.book.imagePath}" alt="도서 이미지" width="100" height="150"></a></div>
					<div class="bookmarkBookInfo mypage-box-width">
							<div><a href="/search/info_view/${bookmark.book.id}"><span class="font-weight-bold font-size-larger">${bookmark.book.name}</span></a></div>
							<div>${bookmark.book.author} 지음</div>
							<div>출판사 | 
							<fmt:formatDate var="publishDate" value="${bookmark.book.publishDate}" pattern="yyyy-MM-dd" />${publishDate} 출간</div>
							<div>분류: ${bookmark.category.categoryName}</div>
						</div>
					<div>
						<div>책 상태: 
							<c:choose>
								<c:when test="${bookmark.book.state eq '대출 가능'}">
									<span class="text-success font-weight-bold">${bookmark.book.state}</span>
								</c:when>
								<c:when test="${bookmark.book.state eq '예약 가능'}">
									<span class="text-warning font-weight-bold">${bookmark.book.state}</span>
								</c:when>
								<c:otherwise>
									<span class="text-secondary font-weight-bold">${bookmark.book.state}</span>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="d-flex justify-content-center">
							<c:choose>
								<c:when test="${bookmark.book.state eq '대출 가능'}">
									<button type="button" class="borrowBtn btn btn-success" data-book-id="${bookmark.book.id}">대출하기</button>
								</c:when>
								<c:when test="${bookmark.book.state eq '예약 가능'}">
									<button type="button" class="reserveBtn btn btn-warning" data-book-id="${bookmark.book.id}">예약하기</button>
								</c:when>
								<c:otherwise>
									<span class="text-secondary font-weight-bold">${bookmark.book.state}</span>
								</c:otherwise>
							</c:choose>
						</div>
						
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	// 1. 대출/ 예약 리스트 , 즐겨찾기 리스트 버튼
	$('.bookmarkViewBtn').on('click',function(e){
		e.preventDefault();
		$('#borrowReserveBox').addClass('d-none');
		$('#bookmarkBox').removeClass('d-none');
	});
	$('.borrowReserveViewBtn').on('click',function(e){
		e.preventDefault();
		$('#bookmarkBox').addClass('d-none');
		$('#borrowReserveBox').removeClass('d-none');
	});
	// 2. 반납, 연장
	$('.borrowDeleteBtn').on('click',function(e){
		let bookId = $(this).data('book-id');
		
		$.ajax({
			type:"delete"
			,url:"/borrow/delete/" + bookId
			,data:{"bookId" :bookId}
			,success:function(data){
				if(data.result == "success"){
					alert('도서를 반납했습니다.');
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("반납에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	$('.borrowExtendBtn').on('click',function(e){
		let bookId = $(this).data('book-id');
		
		$.ajax({
			type:"post"
			,url:"/borrow/extend/" + bookId
			,data:{"bookId" :bookId}
			,success:function(data){
				if(data.result == "success"){
					alert('도서 대출 기간을 7일 연장했습니다.');
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("도서 대출 연장에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	// 3. 대출, 예약
	$('.borrowBtn').on('click',function(e){
		e.preventDefault();
		let bookId = $(this).data('book-id');
		$.ajax({
			type:"post"
			,url: "/borrow/borrow/" + bookId
			,data:{"bookId":bookId}
			,success: function(data){
				if(data.result == "success"){
					alert('책을 대출하였습니다.');
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("대출에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	$('.reserveBtn').on('click',function(e){
		e.preventDefault();
		let bookId = $(this).data('book-id');
		$.ajax({
			type:"post"
			,url: "/reserve/" + bookId
			,data:{"bookId":bookId}
			,success: function(data){
				if(data.result == "success"){
					alert('책을 예약하였습니다.');
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("예약에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
		
		//예약 취소 버튼 넣기? 여기에 add remove Class 클래스 넣어서 만들면 될 것 같음
	});
	$('.reserveDeleteBtn').on('click',function(e){
		e.preventDefault();
		let bookId = $(this).data('book-id');
		$.ajax({
			type:"delete"
				,url:"/reserve/delete/" + bookId
				,data:{"bookId" :bookId}
				,success:function(data){
					if(data.result == "success"){
						alert('도서의 예약을 취소했습니다.');
						location.reload();
					}else{
						alert(data.error_message);
					}
				}
				,error:function(e){
					alert("예약 취소에 실패했습니다. 관리자에게 문의해주세요.");
				}
		});
	})
});
</script>