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
        <form:form commandName="userExam" action="../populateResult" method="post">
            <table>
                
                <c:if test="${questionSetQuestions != null}">                                                                     
                    <c:forEach var="question" items="${questionSetQuestions}" varStatus="qnum">
                        <tr> <td>
                                <b>${qnum.index +1}</b>) ${question.question}</td></tr>
                        </br>
                        <tr> <td><form:radiobutton path="questionSet.questionslist[${qnum.index}].userAnswer" value="${question.option1}"/> ${question.option1}
                                <form:radiobutton path="questionSet.questionslist[${qnum.index}].userAnswer" value="${question.option2}"/>${question.option2}
                                    <form:radiobutton path="questionSet.questionslist[${qnum.index}].userAnswer" value="${question.option3}"/>${question.option3}
                                    <form:radiobutton path="questionSet.questionslist[${qnum.index}].userAnswer" value="${question.option4}"/>${question.option4}</td></tr>                    
                            </br>
       
                    </c:forEach>  
                </c:if>
               
            </table>
             <input type="submit" />
        </form:form>       
    </body>
</html>
