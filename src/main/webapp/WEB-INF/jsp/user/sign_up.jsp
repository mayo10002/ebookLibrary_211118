<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center w-50">
	<div>
		<h1>회원가입</h1>
		<div id="signUpBox w-75">
			<!-- 아이디 -->
			<div id="userIdBox" class="mx-4 my-1">
				<span class="font-weight-bold mr-3">아이디</span>
				<input type="text" id="loginId" class="my-1" placeholder="아이디를 입력하세요.">
				<button type="button" id="loginIdCheckBtn" class="btn btn-primary ml-3">중복확인</button>
				<!-- 아이디 검증 -->
				<div id="idCheckLength" class="small text-danger d-none my-2">ID를 4자 이상 입력하세요.</div>
				<div id="idCheckDuplicated" class="small text-danger d-none my-2">이미 사용중인 아이디입니다.</div>
				<div id="idCheckOk" class="small text-success d-none my-2">사용 가능한 아이디입니다.</div>
			</div>
			<!-- 이름 -->
			<div id="nameBox" class="mx-4 my-1">
				<span class="font-weight-bold mr-3">이름</span>
				<input type="text" id="name" class="my-1" placeholder="이름을 입력하세요.">
			</div>
			<!-- 비밀번호 -->
			<div id="passwordBox" class="mx-4 my-1">
				<span class="font-weight-bold mr-3">비밀번호</span>
				<input type="password" id="password" class="my-1" placeholder="비밀번호를 입력하세요.">
				
				<span class="font-weight-bold mr-3">비밀번호 확인</span>
				<input type="password" id="confirmPassword" class="form-control my-1" placeholder="비밀번호를 다시 입력하세요">
				
				
			</div>
			<!-- 전화번호 -->
			<!-- 이름 -->
			<div id="phoneNumberBox" class="mx-4 my-1">
				<span class="font-weight-bold mr-3">전화번호</span>
				<input type="text" id="phoneNumber" class="my-1" placeholder="ex)010-0000-0000">
			</div>
			<button type="button" id="signUpBtn" class="btn btn-primary my-3">가입하기</button>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	//아이디 버튼
	
	// 이름 버튼
	
	// 비밀번호 버튼
	
	//
});
</script>