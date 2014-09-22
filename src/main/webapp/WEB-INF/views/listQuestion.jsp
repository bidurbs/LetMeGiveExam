<%-- 
    Document   : listQuestion
    Created on : Sep 21, 2014, 3:52:55 PM
    Author     : bidur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Question List!</h1>
         <h2>${subject.name}</h2>
        <form:form commandName="questionSetUserAnswers" action="../pupulateResult/${questionSet.id}" method="post">
        <table>
            <!--<tr>-->
                <!--<th>Q .No</th>-->
                <!--<th>Question</th>-->
<!--                <th>Option A</th>-->
                <!--<th>Option B</th>-->
                <!--<th>Option C</th>-->
                <!--<th>Option D</th>-->
            <!--</tr>-->
            <c:forEach var="question" items="${questionSetQuestions}" varStatus="qnum">
                <tr> <td>
                <b>${qnum.index +1}</b>) </td><td> ${question.question}</td></tr>
                </br>
                   <tr> <td><form:radiobutton path="userAnswer/${qnum.index}" value="${question.option1}"/> ${question.option1}
                    <form:radiobutton path="userAnswer/${qnum.index}" value="${question.option2}">${question.option2}
                    <form:radiobutton path="userAnswer/${qnum.index}" value="${question.option3}"/>${question.option3}
                    <form:radiobutton path="userAnswer/${qnum.index}" value="${question.option4}"/>${question.option4}</td></tr>                    
                    </br>
<!--                    <td>${question.option1}</td>
                    <td>${question.option2}</td>
                    <td>${question.option3}</td>
                    <td>${question.option4}</td>-->
                <!--</tr>-->
            </c:forEach>                
                <!--<tr>-->
                <!--<th>Subject</th>-->               
            <!--</tr>-->
        </table>
        </form:form>
        <input type="submit" />
</body>
</html>
