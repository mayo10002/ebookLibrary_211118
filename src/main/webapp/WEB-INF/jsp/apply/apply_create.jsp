<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="applyCreateBox" class="bg-white mt-5">
				<h1 class="m-2 text-center p-5">희망 도서 신청</h1>
				<div class="d-flex justify-content-center">
				<div class="pl-5 mr-4">
					<div id="NameBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">&nbsp;신청자: </span>
						</div> <span class="apply-font-design">${userName}</span><br>
					</div>
					<div id="applyBookNameBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design text-danger">*</span><span class="apply-font-design">도서 제목:&nbsp;</span>
						</div>
						<input type="text" id="bookName" class="w-50 ml-4" placeholder="도서 제목을 입력하세요.">
					</div>
					<div id="applyBookAuthorBox" class="d-flex my-1">
						<div class="apply-box-size">
						<span class="apply-font-design text-danger">*</span><span class="apply-font-design">도서 저자:&nbsp;</span>
						</div>
						<input type="text" id="bookAuthor" class="w-50 ml-4" placeholder="도서 저자를 입력하세요.">
					</div>
					<div id="applyBookPublisherBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design text-danger">*</span><span class="apply-font-design">출판사:&nbsp;</span>
						</div>
						<input type="text" id="bookPublisher" class="w-50 ml-4" placeholder="출판사를 입력하세요.">
					</div>
					<div id="applyBookPublishDateBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design text-danger">*</span><span class="apply-font-design">출판 날짜:&nbsp;</span>
						</div>
						<input type="text" id="bookPublishYear" class="w-50 ml-4" placeholder="출판날짜를 선택하세요.">
					</div>
					<!-- 신청 / 취소 버튼 -->
					<div class="d-flex justify-content-between">
						<div class="d-flex justify-content-center mt-4 mb-3 ml-4">
							<button type="button" id="CancelBtn" class="btn btn-secondary my-1 ml-4 w-50">뒤로가기</button>
						
							<button type="button" id="ApplyBtn" class="btn btn-success ml-4 my-1 w-50">신청하기</button>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>	
	</div>
</div>

<script>
$(document).ready(function(){
	 $('#bookPublishYear').datepicker({
         minViewMode: 'years'
         ,format: 'yyyy-MM-dd'
         ,changeYear: true
         ,showAnim: "clip"
         ,language: "ko"
         ,title:"출판 년도"
         ,maxDate:0
         ,yearRange: "1900:"
         //여기 수정 필요
       });
	 $('#CancelBtn').on('click',function(e){
		location.href="/book/main_view" 
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
		
		$.ajax({
			type:"post"
			,url:"/apply/create"
			,data : {"bookName": bookName, "bookAuthor": bookAuthor, "bookPublisher": bookPublisher, "bookPublishYear": bookPublishYear}
			,success : function(data){
			   	if(data.result == "success"){
			   		alert("희망 도서를 신청했습니다.");
			    	location.href ="/apply/apply_list_view";
			    }
			}
			,error : function(data){
				alert(data.error_message);
			}
			
		});
	 });
});
</script>