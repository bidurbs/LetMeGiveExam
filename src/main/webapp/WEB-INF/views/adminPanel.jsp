<%-- 
    Document   : adminpanel
    Created on : Sep 21, 2014, 3:08:10 PM
    Author     : Arjun
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <%@include file="../template/sideBar.jsp"%>
        <h2 style="background-color: blueviolet">Welcome to Admin Page!</h2>        
        <table>            
            <tr><td> <a href="adminSubjects"> Subject Setting</a>    </td></tr>
            <tr><td> <a href="questionSetting">Add Question</a>     </td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/j_spring_security_logout">logout</a></td></tr>
        </table>
    </body>
</html>
