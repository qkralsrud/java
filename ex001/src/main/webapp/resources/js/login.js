window.onload=function(){
	// 버튼 선택
	let signupBtn = document.querySelector("#signupBtn");
	// 버튼에 이벤트 적용
	signupBtn.addEventListener('click', function(){
		location.href="/signup";
	});
}

// 화면출력==================
function fn_findId(){
	loginForm.classList.add('none');
	findId.classList.remove('none');
	setPwForm.classList.add('none');
}
function fn_login(){
	loginForm.classList.remove('none');
	findId.classList.add('none');
	setPwForm.classList.add('none');
}
function fn_setPw(){
	setPwForm.classList.remove('none');
	findId.classList.add('none');
	loginForm.classList.add('none');
}
//===========================
function fn_findIdAction(){
	let data = {
		name : findId_name.value
		, email : findId_email.value
	};
	console.log("요청데이터 : ",data);
	fetch_post("/findId", data, fn_findIdActionRes)
}

function fn_findIdActionRes(data){
	console.log("응답데이터", data);
	findIdMsgBox.innerHTML = data.msg;
}







