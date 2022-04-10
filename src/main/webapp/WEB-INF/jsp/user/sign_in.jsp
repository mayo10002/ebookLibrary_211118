<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50 d-flex justify-content-center">
		<div id="signBox" class="bg-white w-50 mt-5">
			<h1 class="m-2 text-center p-5">로그인</h1>
			<div class="pl-5 mr-4">
				<!-- 아이디 -->
				<div id="userIdBox" class="d-flex ml-4 mr-5 signInWrite">
					<div class="signInIcon d-flex justify-content-center align-items-center w-25">
					<img src="https://www.iconninja.com/files/278/576/983/users-user-icon.png" alt="아이디" width="30" height="30"></div> 
					<input type="text" id="loginId" class="py-1 border-0 w-100" placeholder="아이디를 입력하세요.">
				</div>
				
				<!-- 비밀번호 -->
				<div id="passwordBox" class="d-flex ml-4 my-1 mr-5 signInWrite">
					<div class="signInIcon d-flex justify-content-center align-items-center w-25">
					<img src="https://www.iconninja.com/files/1010/623/829/key-icon.png" alt="비밀번호" width="30" height="30"></div> 
					<input type="password" id="password" class="py-1 border-0 w-100" placeholder="비밀번호를 입력하세요.">
				</div>
				
				<!-- 가입 버튼 -->
				<div class="d-flex justify-content-center mt-4 pb-1 mr-5">
					<button type="button" id="signInBtn" class="btn btn-primary my-1 ml-4 w-50">로그인</button>
				</div>
				<div class="d-flex justify-content-center pb-5 mr-5">
					<button type="button" id="signUpViewBtn" class="btn btn-secondary ml-4 my-1 w-50">회원가입</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	//로그인 버튼
	$('#signInBtn').on('click',function(e){
		let loginId = $('#loginId').val().trim();
		if(loginId ==''){
			alert('아이디를 입력해주세요.');
			return;
		}
		if(loginId.length < 4){
			alert('아이디가 너무 짧습니다.');
			return;
		}
		let password = $('#password').val();
		if(password == ''){
			alert('패스워드를 입력해주세요.');
		}
		
		$.ajax({
			type:"post"
			,url:"/user/sign_in"
			,data:{"loginId":loginId, "password":password}
			,success : function(data){
				if(data.result == "success"){
					alert("성공");
				}
			}
			,error : function(data){
				alert("로그인에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});

</script>