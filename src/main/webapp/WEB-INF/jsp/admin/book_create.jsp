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
						<input type="number" id="bookIsbn" class="w-50 ml-4" placeholder="isbn을 입력하세요.">
					</div>
					
					<div id="bookPageBox">
						<span class="apply-font-design">페이지 수:</span>
						<input type="number" id="bookPage" class="w-50 ml-4" placeholder="도서의 페이지 수를 선택하세요.">
					</div>
					<div id="bookInfoBox">
						<span class="apply-font-design">책 정보:</span><br>
						<textarea id="bookInfo" class="" placeholder="책 정보를 입력하세요."></textarea>
					</div>
					<div id="bookCategoryBox">
      					<select id="categorySelect">
						    <option value="1" selected>총류</option>
						    <option value="2">철학</option>
						    <option value="3">종교</option>
						    <option value="4">사회과학</option>
						    <option value="5">자연과학</option>
						    <option value="6">기술과학</option>
						    <option value="7">예술</option>
						    <option value="8">언어</option>
						    <option value="9">문학</option>
						    <option value="10">역사</option>
						</select>
					</div>
					<div id="fileUpload">
						<span class="apply-font-design">책 표지 이미지를 업로드해주세요.</span><br>
						<input type="file" id="file" accept=".gif,.jpg,.jpeg,.png"> 
						
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
	$('#ApplyBtn').on('click',function(){
		let bookName = $('#bookName').val().trim();
		let bookAuthor = $('#bookAuthor').val().trim();
		let bookPublisher = $('#bookPublisher').val().trim();
		let bookPublishDate = $('#bookPublishDate').val().trim(); 
		let bookIsbn = $('#bookIsbn').val().trim();
		let bookPage = $('#bookPage').val().trim();
		let bookInfo = $('#bookInfo').val();
		let bookCategory =numSelect.options[document.getElementById("categorySelect").selectedIndex].value;
		let file =  $('#file').val();
		
		//파일 유효성 검사
		if(file != ""){
			console.log(file.split(".")); //파일 경로룰 . 기준으로 잘라 배열에 저장한다.
			let ext = file.split(".").pop().toLowerCase(); // 확장자를 뽑아내고 소문자로 변경. pop는 list 제일 마지막 칸을 뽑아온 것.
			if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
				alert("gif, png, jpg, jpeg 확장자만 업로드 할 수 있습니다.");
				$('#file').val(''); // 파일을 비운다.
				return;
			}
			
		}
		if(bookName == ''){
			alert('도서 제목이 입력되지 않았습니다.');
			return;
		}
		if(bookAuthor == ''){
			alert('도서 저자가 입력되지 않았습니다.');
			return;
		}
		if(bookPublisher == ''){
			alert('도서 출판사가 입력되지 않았습니다.');
			return;
		}
		if(bookPublishDate == ''){
			alert('도서 출판일이 입력되지 않았습니다.');
			return;
		}
		if(file == ''){
			alert('파일을 선택해주세요.');
			return;
		}
		
		let formData = new FormData();
		formData.append("bookName" , bookName);
		formData.append("bookAuthor" , bookAuthor);
		formData.append("bookPublisher" , bookPublisher);
		formData.append("bookPublishDate" , bookPublishDate);
		formData.append("bookIsbn" , bookIsbn);
		formData.append("bookPage" , bookPage);
		formData.append("bookInfo" , bookInfo);
		formData.append("bookCategory" , bookCategory);
		formData.append("file", $('#file')[0].files[0]); // 첫번 째 것을 선택해서 올리는 것.
		
		$.ajax({
			type:"post"
			, url:"/admin/create"
			, data: formData
			, enctype: "multipart/form-data" 
			, processData: false 
			, contentType: false 
			, success: function(data){
				if(data.result == "success"){
					location.reload();
				}else{
					alert(data.error_message);
				}
			}
			, error: function(e){
				alert("게시에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	
	
	
	
});

</script>