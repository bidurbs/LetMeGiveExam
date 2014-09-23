<%-- 
    Document   : UserExam
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
        <title>User Exam</title>
    </head>
    <body>
        <h1>Question List for your current Exam!</h1>
        <c:if test="${userExam != null}"> 
        <h2>${subject.name}</h2>        
        <form:form commandName="questionSet" action="../populateResult/${userExam.id}/${questionSet.id}" method="post">

            <table>

                <c:if test="${userExam.questionSet.questionslist != null}">                                                                     
                    <c:forEach var="question" items="${questionSet.questionslist}" varStatus="qnum">
                        <tr> 
                            <td><b>${qnum.index +1}</b>) ${question.question}</td>
                        </tr>
                        </br>
                        <tr> 
                            <td>
                                <c:if test="${question.option1 != null}">   
                                    <form:radiobutton id="${question.id}" path="questionslist[${qnum.index}].userAnswer" value="${question.option1}"/> ${question.option1} </c:if>
                                <c:if test="${question.option2 != null}"> 
                                    <form:radiobutton id="${question.id}" path="questionslist[${qnum.index}].userAnswer" value="${question.option2}"/>${question.option2}</c:if>
                                <c:if test="${question.option3 != null}"> 
                                    <form:radiobutton id="${question.id}" path="questionslist[${qnum.index}].userAnswer" value="${question.option3}"/>${question.option3}</c:if>
                                <c:if test="${question.option4 != null}"> 
                                    <form:radiobutton id="${question.id}" path="questionslist[${qnum.index}].userAnswer" value="${question.option4}"/>${question.option4}</c:if>
                            </td>
                        </tr> 
                    </c:forEach>  
                </c:if>

            </table>
            <input type="submit" />             
        </form:form>   
        </c:if>
    </body>
</html>
