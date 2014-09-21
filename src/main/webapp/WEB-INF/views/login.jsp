<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h3>
        <table border="0">
            <tr>
        <h3>Language : <a href="?language=en">English</a>|
        <a href="?language=french">French</a> </h3>
    </tr>
   <!--  Current Locale : ${pageContext.response.locale}  -->
   <tr> <h1><spring:message code="welcome.login" text="Login Page!"/></h1></tr>
       <tr> <c:if test="${error eq true}">
            <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        </c:if></tr>
        
        <form method="post" action="<c:url value='j_spring_security_check' />">
           <tr><td> <spring:message code="welcome.username" text="Username :"/> <input name="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/> </td></tr>
           <tr> <td>    <spring:message code="welcome.password" text="Password :"/> <input type="password" name='j_password' /> </td></tr>
           <tr><td>     <spring:message code="welcome.remember" text="Remember Me "/> <input type="checkbox" name="_spring_security_remember_me" /> <br /><br />
                <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/></td></tr>
           <tr align="left" colspan="2"><td><input type="submit" value='<spring:message code="welcome.submit" text="Submit"/>'/><br/></td></tr>
            <tr><td><spring:message code="welcome.forgetPassword" text="Forgot Username or Password - Contact Administrator"/></td>  </tr>    
        </form>
            <tr align="left" colspan="2"><td><a href="register" ><h3><spring:message code="welcome.register" text="Register"/></h3></a> </td> </tr>
            </h3>

            </table>
    </body>
</html>
