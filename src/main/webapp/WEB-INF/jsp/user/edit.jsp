<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50 d-flex justify-content-center">
		<div id="signBox" class="bg-white w-75 mt-5">
			<h1 class="m-2 text-center p-5">회원 정보 수정</h1>
			<div class="pl-5">
				<!-- 아이디 -->
				<div id="userIdBox" class="d-flex ml-4">
					<div class="sign-name-box"><span class="font-weight-bold mr-3">아이디</span></div>
					<input type="text" id="loginId" class="w-50" placeholder="아이디를 입력하세요." value="${userLoginId}">
					<button type="button" id="loginIdCheckBtn" class="btn btn-primary ml-3">중복확인</button>
				</div>
				<!-- 아이디 검증 -->
				<div id="userIdCheck" class="d-flex">
				<div class="sign-name-box"></div>
					<div id="idCheckLength" class="small text-danger d-none ml-4 my-2">ID를 4자 이상 입력하세요.</div>
					<div id="idCheckDuplicated" class="small text-danger d-none ml-4 my-2">이미 사용중인 아이디입니다.</div>
					<div id="idCheckOk" class="small text-success d-none ml-4 my-2">사용 가능한 아이디입니다.</div>
				</div>
				<!-- 이름 -->
				<div id="nameBox" class="d-flex ml-4 my-1">
					<div class="sign-name-box"><span class="font-weight-bold mr-4">이름</span></div>
					<input type="text" id="name" class="py-1 w-50" placeholder="이름을 입력하세요." value="${userName}">
				</div>
				
				<!-- 전화번호 -->
				<div id="phoneNumberBox" class="d-flex ml-4 my-1">
					<div class="sign-name-box"><span class="font-weight-bold mr-3">전화번호</span></div>
					<input type="text" id="phoneNumber" class="py-1 w-50" placeholder="ex)010-0000-0000" value="${userPhoneNumber}">
				</div>
				<!-- 가입 버튼 -->
				<div class="d-flex justify-content-center pb-5 mr-5">
					<button type="button" id="passwordConfirmBtn" class="btn btn-primary my-3 w-25" data-toggle="modal" data-target="editConfirmModal">수정하기</button>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal : data-target = 모달 id -->
<div class="modal fade" id="editConfirmModal">
	<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
		<div class="modal-content">
      		<div class="d-flex justify-content-center p-5">
      			<div>
      				<input type="password" id="password" class="w-50" placeholder="현재 사용중인 비밀번호를 입력하세요.">
      				<button type="button" id="editBtn" class="btn btn-primary my-4">수정하기</button>
      			</div>
      		</div>
		</div>
	</div>
</div>


<script>
$(document).ready(function(){
	// 아이디 중복확인 버튼
	$('#loginIdCheckBtn').on('click',function(e){
		e.preventDefault();
		let loginId = $('#loginId').val().trim();
		
		$('#idCheckLength').addClass('d-none');
		$('#idCheckDuplicated').addClass('d-none');
		$('#idCheckOk').addClass('d-none');
		
		if(loginId.length < 4) {
			$('#idCheckLength').removeClass('d-none');
			return;
		}
		
		$.ajax({
			url:"/user/is_duplicated_id"
			, data:{"loginId":loginId}
			, success: function(data){
				if(data.result){
					//w 중복인 경우
					$('#idCheckDuplicated').removeClass('d-none');
				}else {
					$('#idCheckOk').removeClass('d-none');
				}
			}
			, error: function(e){
				alert("아이디 중복확인에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	$('#passwordConfirmBtn').on('click',function(e){
		// data를 이쪽에 다시 넣어줘야 한다.
	});
	$('#editBtn').on('click',function(e){
		// 넘겨야 한다.
	})
});
</script>