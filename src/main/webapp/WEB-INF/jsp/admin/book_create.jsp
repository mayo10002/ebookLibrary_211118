<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
						<input type="text" id="bookIsbn" class="w-50 ml-4" placeholder="isbn을 입력하세요.">
					</div>
					<div id="bookPageBox">
						<span class="apply-font-design">페이지 수:</span>
						<input type="number" id="bookPage" class="w-50 ml-4" placeholder="출판일을 선택하세요.">
					</div>
					<div id="bookInfoBox">
						<span class="apply-font-design">책 정보:</span><br>
						<textarea id="bookInfo" class="" placeholder="출판일을 선택하세요."></textarea>
					</div>
					<div id="bookCategoryBox">
						<span class="apply-font-design">카테고리 선택:</span>
						<label for="general"><input type="radio" name="category" value="1" id="general" checked>총류</label>
      					<label for="philosophy"><input type="radio" name="category" value="2" id="philosophy">철학</label>
      					<label for="religion"><input type="radio" name="category" value="3" id="religion">종교</label>
      					<label for="socialScience"><input type="radio" name="category" value="4" id="socialScience">사회과학</label>
      					<br>
      					<label for="pureScience"><input type="radio" name="category" value="5" id="pureScience">자연과학</label>
      					<label for="technology"><input type="radio" name="category" value="6" id="technology">기술과학</label>
      					<label for="art"><input type="radio" name="category" value="7" id="art">예술</label>
      					<label for="language"><input type="radio" name="category" value="8" id="language">언어</label>
      					<br>
      					<label for="literature"><input type="radio" name="category" value="9" id="literature">문학</label>
      					<label for="history"><input type="radio" name="category" value="10" id="history">역사</label>
					</div>
					<div id="fileUpload">
						<input type="file" id="file" class="d-none" accept=".gif,.jpg,.jpeg,.png"> 
						<a href="#" id="fileUploadBtn" > 
						<img src="https://www.iconninja.com/files/505/794/492/image-icon.png" alt="이미지 삽입" width="30"></a>
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

<script>
$(document).ready(function(){
	$('#bookPublishDate').datepicker({
        minViewMode: 'years'
        ,format: 'yyyy-MM-dd'
        ,changeYear: true
        ,showAnim: "clip"
        ,language: "ko"
        ,title:"출판 날짜"
        //여기 수정 필요
      });
	let bookname = $('#bookName').val().trim();
	let bookAuthor = $('#bookAuthor').val().trim();
	let bookPublisher = $('#bookPublisher').val().trim();
	let bookPublishDate = $('#bookPublishDate').val().trim(); 
	let bookIsbn = $('#bookIsbn').val().trim();
	let bookPage = $('#bookPage').val().trim();
	let bookInfo = $('#bookInfo').val();
	let bookCategory =$('[name=category]').val();
	
});

</script>