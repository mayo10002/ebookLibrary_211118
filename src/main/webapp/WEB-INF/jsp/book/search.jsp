<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="width-fix m-5 p-5">
	<div class="mb-4"><span class="font-weight-bold">검색 결과 3건</span></div> <!-- list count 넣어야 한다. -->
	<div>
		<c:forEach items="${searchViewList}" var="search">
			<div id="searchResultList" class="d-flex justify-content-center align-items-center my-3">
				<div id="resultBookImage"><a href="/search/info_view/${search.book.id}"><img src="${search.book.imagePath}" alt="도서 이미지" width="100" height="150"></a></div>
				<div id="resultBookInfo" class="mx-3">
					<div><a href="/search/info_view/${search.book.id}"><span class="font-weight-bold font-size-larger">${search.book.name}</span></a></div>
					<div>${search.book.author} 지음</div>
					<div>${search.book.publisher} | ${search.book.publishDate} 출간</div>
				</div>
				<div id="resultBookstate" class="my-2 font-weight-bold">도서 상태:&nbsp;
				<!-- c:choose 써서 span text 색깔 바꿔서 표시하기 -->
					<c:choose>
						<c:when test="${search.book.state eq '대출 가능'}">
							<span class="text-success font-weight-bold">${search.book.state}</span>
						</c:when>
						<c:when test="${search.book.state eq '예약 가능'}">
							<span class="text-warning font-weight-bold">${search.book.state}</span>
						</c:when>
						<c:otherwise>
							<span class="text-secondary font-weight-bold">${search.book.state}</span>
						</c:otherwise>
					</c:choose>
				 </div>
				<div id="resultBookmark">
					<c:if test="${search.filledBookmark eq true}">
					채워진 별
					</c:if>
					<c:if test="${search.filledBookmark eq false}">
					비워진 별
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<script>
/* //pathvariable 로 bookid를 넘겨야 한다. */
</script>