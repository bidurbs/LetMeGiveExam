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
        <h1>Admin panel</h1>
        <form:form action="addSubject" method="post" commandName="subject" >
        <table>
            <caption>Add Subjects</caption>
            <tr>                
                    <td>Subject Name:</td>
                    <!--<td><form:input type="text" path="name" /></td>-->
                </tr>
                <tr>
                    <td>Description:</td>
                    <!--<td><form:input type="text" path="description" /></td>-->
                </tr>                 
                <input type="submit"/>
        </table>
        </form:form>
    </body>
</html>
