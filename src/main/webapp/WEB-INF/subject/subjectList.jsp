<%-- 
    Document   : subjectList
    Created on : 21 Sep, 2014, 1:30:04 PM
    Author     : devika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<table class="table table-striped">    
                     <td>Name</td>
                     <td>Description</td>
                     
                <c:forEach items="${subjects}" var="subject">
                 <tr>      
                     <td>${subject.name}</td>   
                     <td>${subject.description}</td>
                     
                 </tr>
               </c:forEach>
</table>