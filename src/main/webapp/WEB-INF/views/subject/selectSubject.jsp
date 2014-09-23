<%-- 
    Document   : selectSubject
    Created on : 21 Sep, 2014, 11:05:12 PM
    Author     : devika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Subject</title>
    </head>    
    <body> <html:form action="/inputAction" > 
            <table>
                <tr> <td> Select Subject : </td> 
                    <td> <html:select property="subject" > 
                            <html:option value="0">Select Subject</html:option> 
                            <html:optionsCollection name="InputForm" property="subjects"label="subjectName" value="subjectId" />
                        </html:select>
                    </td>
                </tr>
                <tr> <td colspan="2" align="center"> <html:submit property="method" value="Take Exam" /> </td> </tr>
            </table> </html:form> </body>
</html>


