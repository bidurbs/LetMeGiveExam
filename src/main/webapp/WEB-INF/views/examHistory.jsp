<%-- 
    Document   : examHistory
    Created on : Sep 22, 2014, 2:29:55 PM
    Author     : bidur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>       
        <%@include file="../template/sideBar.jsp"%>
        <h3>Exam history :</h3>
        <table border="1" cellpadding="10">
            <tr>
                <th>Question Set</th>
                <th>Subject</th>
                <th>Exam Date</th>
                <th>Duration (Min)</th>
                <th>Score</th>
            </tr>
            <c:forEach var="userExam" items="${userExamList}">
                <tr>
                    <td>${userExam.id}</td>
                    <td> <c:if test="${userExam.questionSet.questionslist.size() != 0}">   
                            ${userExam.questionSet.questionslist.get(0).subject.name}
                        </c:if>
                    </td>
                    <td>${userExam.startTime}</td>
                    <td>${userExam.duration}</td>
                    <td>${userExam.score}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
