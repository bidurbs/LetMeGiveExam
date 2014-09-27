<%-- 
    Document   : viewProfile
    Created on : Sep 22, 2014, 10:21:36 AM
    Author     : nirali_bheda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Profile</title>
    </head>
    <body>
         <%@include file="sideBar.jsp"%>
        <h1>View profile</h1>
        <table>
            <tr>
                <td>Firstname:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Lastname:</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>Username:</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${user.email}</td>
            </tr>
           
        </table>
    </body>
</html>

