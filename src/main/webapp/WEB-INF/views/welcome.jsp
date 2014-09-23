<%-- 
    Document   : welcome
    Created on : Sep 19, 2014, 11:03:04 AM
    Author     : nirali_bheda
--%>

<%@page import="org.springframework.util.StringUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%--<%@include file="header.jsp" %>--%>
    </head>
    <body>
         <%@include file="../template/sideBar.jsp"%>
        
<!--       <a href="${pageContext.request.contextPath}/generateQuestionSet/1"> Start Exam</a>
        
        <fieldset style="width: 40%; position: absolute;"><legend><h3>Login Page!</h3></legend>    
             <%--<%@include file="login.jsp" %>--%>
            </fieldset> 
             
        <sec:authorize access="hasRole('ROLE_USER')" >
        <a href="<%=request.getContextPath()%>/j_spring_security_logout">logout</a>-->
        <div id="featureWrap">
            
            <div class="container">
                    <!--display flash message-->
                    <div id="serverResponseMsg"></div>
                    
              
                    <div class="row">
                            <div class="col-sm-4 text-center feature">
                                  <p>
                                      <h4>Available Subjects</h4>
                                       <p>
                                          <table class="table table-striped">    
<!--                     <td>Name</td>
                     <td>Description</td>-->
                     
                <c:forEach items="${subjects}" var="subject">
                 <tr>      
                      <td><a href="generateQuestionSet/${subject.id}">${subject.name}</a></td>   
                      <td><text>${subject.description}<text></td>
                     
                 </tr>
               </c:forEach>
                </table>
                                       </p>
                                    </p>
                            </div>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                            
                            <div class="col-sm-4 text-center feature">                               
                                    <p>
                                          <ul class="nav nav-tabs" role="tablist">
                                            <li class="active">
<!--                                                <a href="#login" role="tab" data-toggle="tab">
                                                    <h5 style="margin-bottom:0px;margin-top:0px">Log in</h5>
                                                </a>-->
                                                   <a href="login.jsp">Login</a>
                                            </li>
         
                                          </ul>

                                         <!-- Tab panes -->
                                          <div class="tab-content">
                                              <div class="tab-pane active" id="login" style="padding:20px;text-align: left;">
                                                    <%@include file="login.jsp" %>
                                              </div>
                                              <!--<div class="tab-pane" id="register" style="padding:20px;text-align: left;">
                                              </div>
                                              -->
                                          </div>
                                    </p>
                                  
                                  <c:if test="${user != null}">
                                      <h3>User Profile</h3>
                                      ${pageContext.request.userPrincipal.name}
                                  </c:if>
                            </div>
                                    </c:if>
                    </div>
            </div>
    </div> <!-- /featureWrap -->
        </sec:authorize>    
<!--    <a href="${pageContext.request.contextPath}/questionSet/1"> Start Exam</a>--> 
</body>
</html>
