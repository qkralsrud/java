window.onload=function(){
	// 버튼 선택
	let signupBtn = document.querySelector("#signupBtn");
	// 버튼에 이벤트 적용
	signupBtn.addEventListener('click', function(){
		location.href="/signup";
	});
}