<%-- 
    Document   : addQuestion
    Created on : Sep 22, 2014, 11:49:58 AM
    Author     : Arjun
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <%@include file="../template/sideBar.jsp"%>
        <form:form commandName="question" action="addQuestion" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />      

            <table>
                <caption style="background-color: blueviolet">Add Question!</caption>
                <tr>

                    <td>Choose Subject:</td>

                    <td>  <form:select path="subjectId" >
                    <option value="">Select</option>
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </form:select>  </td>
            <td><a href="addSubject"> Add Subject</a></td>
        </tr>

        <tr>
            <td>Difficulty Level:</td>
            <td><form:select path="difficultyLevel" >
            <option value="1" selected>1</option>                           
            <option value="2">2</option>  
            <option value="3">3</option>  
            <option value="4">4</option>  
            <option value="5">5</option>                                  
        </form:select> </td>
</tr>

<tr>
    <td>Question</td>
    <td><form:textarea path="question" rows="5" cols="40" /></td>
</tr>

<tr>
<table>
    <thead>
    <th>Option</th>
    <th>Answer</th>
    <th>Correct Answer</th>
    <th>&nbsp;</th>
    </thead>
    <tbody>
        <tr>
            <td>Option 1</td>
            <td><form:input type="text" path="option1" /> </td>
            <td><form:radiobutton path="correctAnswer" value="option1" /><td>
            <td><form:errors path="option1" cssClass="error" /> </td>                     
        </tr>
        <tr>
            <td>Option 2</td>
            <td><form:input type="text" path="option2" /> </td>
            <td><form:radiobutton path="correctAnswer" value="option2" /><td>
            <td><form:errors path="option2" cssClass="error" /> </td>                     
        </tr>
        <tr>
            <td>Option 3</td>
            <td><form:input type="text" path="option3" /> </td>
            <td><form:radiobutton path="correctAnswer" value="option3" /><td>
            <td><form:errors path="option3" cssClass="error" /> </td>                     
        </tr>
        <tr>
            <td>Option 4</td>
            <td><form:input type="text" path="option4" /> </td>
            <td><form:radiobutton path="correctAnswer" value="option4" /><td>
            <td><form:errors path="option4" cssClass="error" /> </td>                     
        </tr>
    </tbody>
</table>
</tr>           
</table>
<input type="submit"/>
</form:form>        
</body>
</html>
