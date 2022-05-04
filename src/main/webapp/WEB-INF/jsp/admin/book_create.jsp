<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="width-fix">
		<div class="d-flex justify-content-center">
			<div id="adminCreateBox" class="bg-white mt-5">
				<h1 class="m-2 text-center p-5">도서 추가</h1>
				<div class="pl-5 mr-4">
					<div id="bookNameBox">
						<span class="apply-font-design">도서 제목:</span>
						<input type="text" id="bookName" class="w-50 ml-4" placeholder="도서 제목을 입력하세요.">
					</div>
					<div id="bookAuthorBox">
						<span class="apply-font-design">도서 저자:&nbsp;</span>
						<input type="text" id="bookAuthor" class="w-50 ml-4" placeholder="도서 저자를 입력하세요.">
					</div>
					<div id="bookPublisherBox">
						<span class="apply-font-design">출판사:</span>
						<input type="text" id="bookPublisher" class="w-50 ml-4" placeholder="출판사를 입력하세요.">
					</div>
					<div id="bookPublishDateBox">
						<span class="apply-font-design">출판일:</span>
						<input type="text" id="bookPublishDate" class="w-50 ml-4" placeholder="출판일을 선택하세요.">
					</div>
					<div id="bookIsbnBox">
						<span class="apply-font-design">isbn:</span>
						<input type="text" id="bookIsbn" class="w-50 ml-4" placeholder="출판일을 선택하세요.">
					</div>
					<div id="bookPageBox">
						<span class="apply-font-design">페이지 수:</span>
						<input type="text" id="bookPage" class="w-50 ml-4" placeholder="출판일을 선택하세요.">
					</div>
					<div id="bookInfoBox">
						<span class="apply-font-design">책 정보:</span><br>
						<textarea id="bookInfo" class="" placeholder="출판일을 선택하세요."></textarea>
					</div>
					<div id="bookCategoryBox">
						<span class="apply-font-design">카테고리 선택:</span>
						<datalist id="bookCategory">
							<option value="1" label="">총류</option>
							<option value="2" label="">철학</option>
							<option value="3" label="">종교</option>
							<option value="4" label="">사회과학</option>
							<option value="5" label="">자연과학</option>
							<option value="6" label="">기술과학</option>
							<option value="7" label="">예술</option>
							<option value="8" label="">언어</option>
							<option value="9" label="">문학</option>
							<option value="10" label="">역사</option>
						</datalist>
					</div>
					
					<!-- 신청 / 취소 버튼 -->
					<div class="d-flex justify-content-between">
						<div class="d-flex justify-content-center mt-4 pb-1 mr-5">
							<button type="button" id="CancelBtn" class="btn btn-secondary my-1 ml-4 w-50">메인 화면으로</button>
							<button type="reset" id="resetBtn" class="btn btn-danger">초기화하기</button>
							<button type="button" id="ApplyBtn" class="btn btn-success ml-4 my-1 w-50">추가하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>
</div>