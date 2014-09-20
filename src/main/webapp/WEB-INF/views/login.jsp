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
        <h1>Login Page!</h1>
        <c:if test="${error eq true}">
            <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        </c:if>
        <form method="post" action="<c:url value='j_spring_security_check' />">
            Username: <input name="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/> <br />
                Password: <input type="password" name='j_password' /> <br />
                Remember me: <input type="checkbox" name="_spring_security_remember_me" /> <br />
                <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
            <input type="submit" value="Submit" /><br/>
            <b>Forgot Username or Password - Contact Administrator</b>
        </form>
            <a href="register" >Register</a>
            
        <h1>Spring MVC internationalization example</h1>

    Language : <a href="?language=en">English</a>|
        <a href="?language=zh_CN">Chinese</a>

    <h3>
            welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" />
    </h3>


Current Locale : ${pageContext.response.locale}    
    </body>
</html>
