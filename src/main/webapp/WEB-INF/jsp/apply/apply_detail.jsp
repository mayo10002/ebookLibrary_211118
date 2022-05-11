<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="detailBox" class="small-width">
				<div id="NameBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">&nbsp;신청자: </span>
						</div> <span class="apply-font-design">${detailview.user.name}</span><br>
					</div>
					
					<div id="applyCreateAtBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">신청 일자:&nbsp;</span>
						</div>
						<span class="apply-font-design"><fmt:formatDate value="${detailview.apply.createdAt}" pattern="yyyy-MM-dd" /></span>					
					</div>
					<div id="applyBookNameBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">도서 제목:&nbsp;</span>
						</div>
						<span class="apply-font-design"> ${detailview.apply.bookName}</span>
					</div>
					<div id="applyBookAuthorBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">도서 저자:&nbsp;</span>
						</div>
						 <span class="apply-font-design"> ${detailview.apply.bookAuthor}</span><br>
					</div>
					<div id="applyBookPublisherBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">출판사:&nbsp;</span>
						</div>
						 <span class="apply-font-design">${detailview.apply.bookPublisher}</span><br>
					</div>
					<div id="applyBookPublishDateBox" class="d-flex my-1">
						<div class="apply-box-size">
							<span class="apply-font-design">출판 년도:&nbsp;</span>
						</div>
						 <span class="apply-font-design"> <fmt:formatDate value="${detailview.apply.bookPublishDate}" pattern="yyyy" /></span><br>
					</div>
				
				<c:if test="${userId eq detailview.user.id}">
					<button type="button" class="btn btn-danger mr-3" id="deleteBtn" data-apply-id="${detailview.apply.id}">삭제</button>
				</c:if>
				<button type="button" class="btn btn-secondary" id="listViewBtn">목록으로</button>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$('.deleteBtn').on('click',function(e){
		let applyId = $(this).data('apply-id');
		$.ajax({
			type:"delete"
			,url:"/apply/delete"
			,data:{"applyId":applyId}
			,success:function(data){
				if(data.result == "success"){
					alert('삭제하였습니다.');
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			,error:function(e){
				alert("삭제에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
		
	});
	$('#listViewBtn').on('click',function(e){
		location.href="/apply/apply_list_view";
	});
	
});
</script>