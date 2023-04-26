<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>성적처리 프로그램 v6</title>
    <style>
        table { border: black solid 1px; width: 750px;
            border-spacing: 0; }
        th, td {border: black solid 1px;
            padding: 10px; border-spacing: 0;}
        td {text-align: center;}
    </style>
</head>
<body>
    <h1>성적 상세 조회</h1>
    <table>
        <tr><th>학번</th><th>이름</th><th>국어</th><th>영어</th><th>수학</th>
            <th>총점</th><th>평균</th><th>학점</th><th>등록일자</th></tr>
        <tr><td>${sj.sjno}</td><td>${sj.name}</td><td>${sj.kor}</td>
            <td>${sj.eng}</td><td>${sj.mat}</td><td>${sj.tot}</td>
            <td>${sj.avg}</td><td>${sj.grd}</td><td>${sj.regdate}</td></tr>
    </table>

    <p><a href="/modify?sjno=${sj.sjno}">수정하기</a></p>
    <p><a href="/remove?sjno=${sj.sjno}">삭제하기</a></p>
</body>
</html>
