<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="applyList" class="small-width">
			<div class="d-flex justify-content-between">
				<c:if test="${not empty userName}">
					<button type="button" class="btn btn-success my-3" id="applyCreateBtn">신청하기</button>
				</c:if>
				<c:if test="${userLoginId eq 'admin'}">
					<button type="button" class="btn btn-danger my-3" id="adminCreateBtn">도서 추가하기</button>
				</c:if>
			</div>
				<table id="apply-book" class="table text-center w-100" >
					<tr>
						<th>번호</th>
						<th>신청 도서</th>
						<th>신청자</th>
						<th>작성일</th>
						<th></th>
					</tr>
					<c:forEach items="${applyList}" var="applyList">
						<tr class="table-height">
							<td>${applyList.apply.id}</td>
							<td><a href="/apply/apply_detail_view/${applyList.apply.id}">${applyList.apply.bookName}</a></td>
							<td>${applyList.user.name}</td>
							<td><fmt:formatDate value="${applyList.apply.createdAt}" pattern="yyyy-MM-dd" /> </td>
							<td>
								<c:if test="${userId eq applyList.apply.userId}">
									<button type="button" class="btn btn-danger deleteBtn" data-apply-id="${applyList.apply.id}">삭제</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				
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
	$('#applyCreateBtn').on('click',function(e){
		location.href="/apply/apply_create_view";
	});
	$('#adminCreateBtn').on('click',function(e){
		location.href="/admin/apply_insert_view";
		
	})
	
});
</script>