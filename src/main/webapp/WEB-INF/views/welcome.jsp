<%-- 
    Document   : welcome
    Created on : Sep 19, 2014, 11:03:04 AM
    Author     : nirali_bheda
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
        <h1>Hello World!</h1>
        
        <fieldset style="width: 40%; position: absolute;"><legend><h3>Login Page!</h3></legend>    
             <%@include file="login.jsp" %>
            </fieldset>
    </body>
</html>
