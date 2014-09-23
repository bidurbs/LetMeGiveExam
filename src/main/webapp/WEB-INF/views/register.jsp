<%-- 
    Document   : register
    Created on : Sep 20, 2014, 11:47:56 AM
    Author     : nirali_bheda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1></h1>
        <form:form action="addUser" method="post" commandName="user" >
            
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Register</h2></td>
                </tr>
                <tr>
                    <td>Firstname:</td>
                    <td><form:input  type="text" path="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Lastname:</td>
                    <td><form:input  type="text" path="lastName" /></td>
                    <td><form:errors path="lastName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><form:input  type="email" path="email" /></td>
                    <td><form:errors path="email" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><form:input type="text" path="username" /></td>
                    <td><form:errors path="username" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:password path="password" /></td>
                    <td><form:errors path="password" cssClass="error" /> </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </form:form>
    </body>
</html>
