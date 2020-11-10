<%-- 
    Document   : error
    Created on : Oct 22, 2020, 11:27:14 AM
    Author     : Bogdan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your form has the following problems</h1>
        <% out.print(session.getAttribute("errors"));%>
    </body>
</html>
