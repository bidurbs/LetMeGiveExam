<%-- 
    Document   : examHistory
    Created on : Sep 22, 2014, 2:29:55 PM
    Author     : bidur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exam history page for user</h1>
        <table border="1" cellpadding="10">
            <tr>
                <th>Question Set</th>
                <th>Subject</th>
                <th>Exam Date</th>
                <th>Duration</th>
                <th>Score</th>
            </tr>
            <c:forEach var="userExam" items="${userExamList}">
                <tr>
                    <td>${userExam.id}</td>
                    <td>${userExam.questionSet.questionslist.get(0).subject}</td>
                    <td>${userExam.startTime}</td>
                    <td>${userExam.durateion}</td>
                    <td>${userExam.score}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
