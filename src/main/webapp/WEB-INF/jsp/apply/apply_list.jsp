<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="applyList">
				<table id="apply-book">
					<tr>
						<th>번호</th>
						<th>신청 도서</th>
						<th>신청자</th>
						<th>작성일</th>
						<th></th>
					</tr>
					<c:forEach items="${applyList}" var="apply">
						<tr>
							<td>${apply.id}</td>
							<td><a href="/apply/apply_deta">${apply.bookName}</td>
							<td>${apply.userId}</td>
							<td><fmt:formatDate value="${apply.createdAt}" pattern="yyyy-MM-dd" /> </td>
							<td>
								<c:if test="${userId eq apply.userId}">
									<button type="button" class="btn btn-danger" id="deleteBtn">삭제</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>	
	</div>
</div>