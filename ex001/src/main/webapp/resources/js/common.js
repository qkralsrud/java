/**
 * fetch 공통함수
 * post방식으로 요청
 * ex ) fetch_post('/changeAdminYN', data, 콜백함수)
 * 콜백함수 : 바로 실행 되지 않고 특정 시점에 실행 할수 있도록 함수의 이름만 전달
 */
function fetch_post(url, data, callback){
	fetch(url, {
		method : 'post'
		// body에 추가하는 데이터의 타입과 일치하는 타입을 지정
		,headers: {
		      "Content-Type": "application/json",
		      // 'Content-Type': 'application/x-www-form-urlencoded',
		    }
		// 오브젝트를 JSON형식의 문자열로 변경
		, body : JSON.stringify(data)
	})
	.then(res=>res.json())
	.then(data=>{
		// 
		callback(data);
	})
	.catch(error=>{
		console.log('error', error)
	});
}


function test(){
	alert('test');
}