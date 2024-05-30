<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
    $('#btn').click(function() {
        
        $.ajax({
            url : './Ajax_res.json',
            type : 'get',
            data : {id : "momo", pw:"1234"},
            dataType : "json",
            success : function(resData) {
            	console.log(resData);
                //if (resData != '') location.href='PopupMain.jsp';
            }
        });
        
        
        
    });
});
</script>
<button id="btn">클릭!</button>
</body>
</html>