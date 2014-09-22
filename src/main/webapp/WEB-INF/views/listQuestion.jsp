<%-- 
    Document   : listQuestion
    Created on : Sep 21, 2014, 3:52:55 PM
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
        <h1>List Question!</h1>
        <form:form commandName="questionSetUserAnswers" action="../pupulateResult/${questionSet.id}" method="post">
        <table border="1" cellpadding="10">
            <tr>
                <th>Q .No</th>
                <th>Question</th>
                <th>Option A</th>
                <th>Option B</th>
                <th>Option C</th>
                <th>Option D</th>
            </tr>
            <c:forEach var="question" items="${questionSetQuestions}">
                <tr>
                    <td>${question.id}</td>
                    <td>${question.name}</td>
                    <td>${question.option1}</td>
                    <td>${question.option2}</td>
                    <td>${question.option3}</td>
                    <td>${question.option4}</td>
                </tr>
            </c:forEach>
        </table>
        </form:form>
</body>
</html>
