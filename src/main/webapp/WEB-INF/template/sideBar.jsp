<%-- 
    Document   : sideBar
    Created on : Sep 21, 2014, 3:57:52 PM
    Author     : Arjun
--%>

<%@page import="org.springframework.util.StringUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:url var="cssMenuUrl" value='/css/styles-side-menu.css'></c:url>
        <link rel="stylesheet" href="${cssMenuUrl}">
        <c:url var="jsMenuUrl" value='/js/script-side-menu.js'></c:url>
        <script src="${jsMenuUrl}"></script>
        <title>JSP Page</title>
    </head>
    <div id="section-navigation">
        <div id='cssmenu'>
            <ul> 
                <sec:authorize access="hasRole('ROLE_USER')" >
                        <li><a href="generateQuestionSet/1" >Start Exam</a></li>
                        <li><a href="examHistory" >View History</a></li>
                        <li><a href="viewProfile" >View Profile</a></li>
                </sec:authorize>
                
                
                <sec:authorize access="hasRole('ROLE_ADMIN')" >
                         
                          <li><a href="adminSubjects"> Subjects</a></li>
                          <li><a href="questionSetting">Add Question</a>  </li>
                          <li><a href="adminEditSetting">Setting</a>  </li>
                          
                </sec:authorize>
               
                <li><a href="logout" >Logout</a></li>
            </ul>
        </div>
    </div>
</html>
