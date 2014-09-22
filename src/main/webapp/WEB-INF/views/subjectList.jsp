<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subjects</title>
    </head>
    <body>
        <h1>Subject List</h1>
        <table>
            <c:forEach var="subject" items="${subjects}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td> 
                    <td>${subject.description}</td>                                        
                </tr>
            </c:forEach>
        </table>        
            <a href="addSubject"> Add a Subject</a>        
        <a href="<%=request.getContextPath()%>/j_spring_security_logout">logout</a>

    </body>
</html>