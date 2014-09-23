<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Subject</title>
    </head>
    <body>
        <form:form commandName="subject" action="addSubject" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />              
                <table>
                    <caption style="background-color: blueviolet">Add Subject</caption>
                <tr>
                    <td>Name :</td>
                    <td><form:input type="text" path="name" /> </td>
                    <td><form:errors path="name" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>Description: </td>
                    <td><form:input type="text" path="description" /> </td>
                    <td><form:errors path="description" cssClass="error" /> </td>
                </tr>                
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>