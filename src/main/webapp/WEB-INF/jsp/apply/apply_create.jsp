<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- datepicker -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="applyCreateBox" class="bg-white mt-5">
				<h1 class="m-2 text-center p-5">희망 도서 신청</h1>
				<div class="pl-5 mr-4">
					<div id="NameTodayBox">
						<span class="apply-font-design">&nbsp;신청자: ${userName}<br>
						&nbsp;신청 날짜:
						<c:set var="today" value="<%=new java.util.Date()%>" />
						<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd" /></c:set> </span>
					</div>
					<div id="applyBookNameBox">
						<span class="apply-font-design text-danger">*</span><span class="apply-font-design">도서 제목:&nbsp;</span>
						<input type="text" id="bookName" class="w-100 ml-4" placeholder="도서 제목을 입력하세요.">
					</div>
					<div id="applyBookAuthorBox">
						<span class="apply-font-design text-danger">*</span><span class="apply-font-design">도서 저자:&nbsp;</span>
						<input type="text" id="bookAuthor" class="w-100 ml-4" placeholder="도서 저자를 입력하세요.">
					</div>
					<div id="applyBookPublisherBox">
						<span class="apply-font-design text-danger">*</span><span class="apply-font-design">출판사:&nbsp;</span>
						<input type="text" id="bookPublisher" class="w-100 ml-4" placeholder="출판사를 입력하세요.">
					</div>
					<div id="applyBookPublishDateBox">
						<span class="apply-font-design text-danger">*</span><span class="apply-font-design">출판 년도:&nbsp;</span>
						<input type="text" id="bookPublishYear" class="yearpicker w-100 ml-4" placeholder="출판년도를 선택하세요.">
					</div>
					<!-- 신청 / 취소 버튼 -->
					<div class="d-flex justify-content-between">
						<div class="d-flex justify-content-center mt-4 pb-1 mr-5">
							<button type="button" id="CancelBtn" class="btn btn-secondary my-1 ml-4 w-50">뒤로가기</button>
						</div>
						<div class="d-flex justify-content-center pb-5 mr-5">
							<button type="button" id="ApplyBtn" class="btn btn-success ml-4 my-1 w-50">신청하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>
</div>

<script>
$(document).ready(function(){
	 $('.yearpicker').datepicker({
         minViewMode: 'years'
         ,format: 'yyyy년'
         ,changeYear: true
         ,showAnim: "clip"
         ,language: "ko"
         ,title:"출판 년도"
       });
	 $('#ApplyBtn').on('click',function(e){
		let  bookName = $('#bookName').val().trim();
		let  bookAuthor = $('#bookAuthor').val().trim();
		let  bookPublisher = $('#bookPublisher').val().trim();
		let  bookPublishYear = $('#bookPublishYear').val().trim();
		
		if (bookName == ''){
			alert('도서 제목을 입력해주세요.');
			return;
		}
		if (bookAuthor == ''){
			alert('도서 저자를 입력해주세요.');
			return;
		}
		if (bookPublisher == ''){
			alert('출판사를 입력해주세요.');
			return;
		}
		if (bookPublishYear == ''){
			alert('출판 년도를 선택해주세요.');
			return;
		}
		
		let formData = new FormData();
		formData.append("bookName" , bookName);
		formData.append("bookAuthor" , bookAuthor);
		formData.append("bookPublisher" , bookPublisher);
		formData.append("bookPublishYear" , bookPublishYear);
		$.ajax({
			type:"post"
			,url:"/apply/create"
			,data : {"bookName": bookName}
					,{"bookAuthor": bookAuthor}
					,{"bookPublisher": bookPublisher}
					,{"bookPublishYear": bookPublishYear}
			,success : function(data){
			   	if(data.result == "success"){
			   		alert("희망 도서를 신청했습니다.");
			    	location.href ="/apply/apply_list_view";
			    }
			}
			,error : function(data){
				alert("신청 등록에 실패했습니다. 다시 시도해 주세요.");
			}
			
		});
	 });
});
</script>