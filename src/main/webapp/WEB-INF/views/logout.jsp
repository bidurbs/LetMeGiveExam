<%-- 
    Document   : logout
    Created on : Sep 16, 2014, 2:25:07 PM
    Author     : nirali_bheda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
    </body>
</html>
