<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어 - 연산자</title>
</head>
<body>
<%
	// 스크립틀릿에서 변수 선언
	int num1 = 3;
	pageContext.setAttribute("num2", 4);
	pageContext.setAttribute("num3", 333);
	pageContext.setAttribute("num4", 8);
%>

<h3>변수 선언및 할당</h3>
<!-- 표현언어는 내장객체에 저장된 값을 출력하는데 이용되므로 출력이 안됨 -->
스크립틀릿에서 선언한 변수 : ${num1 } <br> 
page영역에 저장된 변수 : ${num2 } <br>
변수 할당및 즉시 출력 : ${num1 = 7 } <br>
변수 할당및 별도 출력 : ${num2=8;'' } ${num2 } <br>

스크립틀릿을 이용하여 변수에 저장 : <%=num1 %> <br> 
el 표현언어를 이용해서 변수를 할당 : ${num1 } <br>

num1=${num1 }, num2=${num2 }, num3=${num3 }

<hr>
<h3>산술 연산자</h3>
num1 + num2 : ${ num1 + num2 } <br />
num1 - num2 : ${ num1 - num2 } <br />
num1 * num2 : ${ num1 * num2 } <br />
num3 / num4 : ${ num3 / num4 } <br />
num3 div num4 : ${ num3 div num4 } <br />
num3 % num4 : ${ num3 % num4 } <br />
num3 mod num4 : ${ num3 mod num4 }

<h3>+ 연산자는 덧셈만 가능</h3>  
num1 + "34" : ${ num1 + "34" } <br /> 
num2 + "이십" : \${num2 + "이십" }<!-- 에러 발생(주석 처리) --> <br />
"삼십" + "사십" : \${"삼십" + "사십" }<!-- 에러 발생(주석 처리) -->

<h3>비교 연산자</h3>
num4 > num3 : ${ num4 gt num3 } <br />
num1 < num3 : ${ num1 lt num3 } <br />
num2 >= num4 : ${ num2 ge num4 } <br />
num1 == num4 : ${ num1 eq num4 } 

<h3>논리 연산자</h3>
num3 <= num4 && num3 == num4 : ${ num3 le num4 and num3 eq num4 } <br />
num3 >= num4 || num3 != num4 : ${ num3 ge num4 or num3 ne num4 }

<%
// null
pageContext.setAttribute("nullStr", null);
// 빈문자열
pageContext.setAttribute("emptyStr", "");
// 길이가 0인 배열
pageContext.setAttribute("lengthZero", new Integer[0]);
// 비어있는 리스트
pageContext.setAttribute("sizeZero", new ArrayList());
// 비어있는 맵
pageContext.setAttribute("sizeZeroMap", new HashMap());
%>

<h3>empty 연산자</h3>

empty nullStr : ${ empty nullStr } <br />
empty emptyStr : ${ empty emptyStr } <br />
empty lengthZero : ${ empty lengthZero } <br />
empty sizeZero : ${ empty sizeZero } <br>
empty sizeZeroMap : ${empty sizeZeroMap }

<h3>삼항 연산자</h3>
num1 : ${num1 }, num2 : ${num2 } <br>
num1 gt num2 ? "참":"거짓" => ${num1 gt num2 ? "num1이 큽니다" : "num2가 큽니다"}

<h3>null 연산</h3>
null + 10 : ${null + 10 }









</body>
</html>