<%-- 
    Document   : adminSetting
    Created on : Sep 23, 2014, 3:34:18 PM
    Author     : Arjun
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="sideBar.jsp"%>
        <form:form commandName="setting" action="adminEditSetting" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />              
                <table>
                    <caption style="background-color: blueviolet">Edit Setting</caption>
                <tr>
                    <td>Duration Of Exam </td>
                    <td><form:input type="text" path="duration" value="${currentSetting.duration}"/> </td>
                    <td><form:errors path="duration" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>No of Questions in Question Set </td>
                    <td><form:input type="text" path="noOfQuestions" value="${currentSetting.noOfQuestions}"/> </td>
                    <td><form:errors path="noOfQuestions" cssClass="error" /> </td>
                </tr>                
            </table>
            <input type="submit"/>

        </form:form>
</html>
