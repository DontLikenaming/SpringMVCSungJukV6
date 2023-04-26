<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>성적 리스트</title>
    <style>
        table { border: black solid 1px; width: 750px;
                border-spacing: 0; }
        th, td {border: black solid 1px;
            padding: 10px; border-spacing: 0;}
    </style>
</head>
<body>
    <h1>성적 리스트</h1>
    <table>
      <tr><th>이름</th><th>국어</th><th>영어</th><th>수학</th></tr>
        <%--for(SungJuk sj : sjs)--%>
      <c:forEach items="${sjs}" var="sj">
        <tr>
            <td><a href="/view?sjno=${sj.sjno}">${sj.name}</a></td>
            <td>${sj.kor}</td>
            <td>${sj.eng}</td>
            <td>${sj.mat}</td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>
