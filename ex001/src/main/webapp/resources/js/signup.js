
window.addEventListener('load', function(){
	// 아이디 중복체크 - 익명의 함수를 함수로 정의후 함수의 이름만 입력할 수도 있음
	checkIdBtn.addEventListener('click', checkIdFn);
	id.addEventListener('change', function(){
		checkIdTxt.value='0';
	})
	// 회원가입 버튼 클릭
	signupActionBtn.addEventListener('click', function(e){
		// 기본이벤트 초기화
		e.preventDefault();
		/* 아이디 중복검사가 정상적으로 되지 않은경우
		if(checkIdTxt.value != 1){
			alert('아이디 중복검사를 해주세요.');
			return;
		} else {
			signupForm.submit();
		}*/
		// 유효성검사 후 폼 전송
		if(checkSignupForm()){
			signupForm.submit();
		}
	});
	
	// 모달창 열기
	// 전역변수
	myModal = new bootstrap.Modal(document.getElementById('myModal'), {});
	document.querySelector(".modal-title").innerHTML='알림';
// onload End
});


/*
	signupForm 유효성검사
	사용자의 입력값을 체크
	아이디중복검사확인, 이메일형식, pw길이, pw일치확인
*/
function checkSignupForm(){
	// 검사 결과 성공 : true반환
	// 실패 : 메세지 출력후 false반환
	
	
	// 아이디 체크
	if(checkIdTxt.value != 1){
		document.querySelector(".modal-body").innerHTML='아이디 중복검사를 해주세요.';
		myModal.show();
		
		return false;
	}
	
	// 비밀번호 일치 체크
	if(pwTxt.value != pwCheckTxt.value){
		document.querySelector(".modal-body").innerHTML='비밀번호가 일치하지 않습니다.';
		myModal.show();
		
		// 정규식을 이용한 패턴 체크
		
		return false;
	}
	
	return true;
}

/*
	아이디 중복체크 처리
*/
function checkIdFn(){
	//alert('중복체크!!' + id.value);
	let id = document.querySelector("#id");
	fetch("/checkId?id="+id.value)
		.then(response => response.json())
		.then(res => {
			console.log("res", res);
			// 객체에 존재 하지 않는경우, undefind가 출력
			console.log("res.msg", res.msg);
			
			if(res.msg == ''){
				//document.querySelector(".modal-body").innerHTML='아이디 중복검사를 해주세요.';
				// myModal이 전역변수로 선언되어 있지 않은경우, 오류가 발생할 수 있다
				//myModal.show();
				msgBox.innerHTML = '';
				checkIdTxt.value = 1;
			} else {
				msgBox.innerHTML = res.msg;
				checkIdTxt.value = 0;
			}
		})
		.catch(error => {
			console.log('error', error);
		});
	
}