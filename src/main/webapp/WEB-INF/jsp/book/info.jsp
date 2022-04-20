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
				<span>페이지 수 : ${searchBookInfo.book.page}p </span> | 분류: ${searchBookInfo.category.categoryName}<br>
				<span>isbn : ${searchBookInfo.book.isbn}</span><br>
				<span>도서 상태:</span>
				<span>
					<c:choose>
					</c:choose>
				</span>
				<c:if> <!--도서를 누군가 borrow 상태일 경우 뜬다. 그러나 book에 대한 borrow Count가 5로 전부 차면 display:none-->
					<span>도서 대출 가능일:${searchBookInfo.book.isbn}</span>
				</c:if>
				<div class="d-flex justify-content-center">
				<!-- 대출 가능 상태일 때 대출 버튼 : 대출과 북마크 버튼은 로그인 한 상태일 때만 보이게  -->
					<button></button>
				<!-- 대출 불가 상태일 때 예약 버튼 -->
					<button></button>
				<!-- 대출 가능 상태일 때 연장 버튼 -->
					<!-- 즐겨찾기 버튼 -->
					<c:if test="${not empty userName}">
						<div id="resultBookmark">
							<a href="#" id="bookmarkBtn" data-book-id="${searchBookInfo.book.id}">
								<c:if test="${searchBookInfo.filledBookmark eq true}">
									<img src="https://www.iconninja.com/files/647/837/222/star-icon.png" alt="채워진 별" width="30" height="30">
								</c:if>
								<c:if test="${searchBookInfo.filledBookmark eq false}">
									<img src="https://www.iconninja.com/files/851/501/305/star-icon.png" alt="비워진 별" width="30" height="30">
								</c:if>
							</a>
						</div>
					</c:if>
					
				</div>
			</div>
		</div>
		<div id="bookDescriptionBox">
			<h1>도서 정보</h1>
			<p>${searchBookInfo.book.info}</p>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	$('#bookmarkBtn').on('click',function(e){
		e.preventDefault();
		
		let bookId = $(this).data('book-id');
		$.ajax({
			url : "/bookmark/" + bookId
			,success: function(data){
				if(data.result == "success"){
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("즐겨찾기 등록에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});
</script>