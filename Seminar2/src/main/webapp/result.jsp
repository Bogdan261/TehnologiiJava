<%-- 
    Document   : result
    Created on : Oct 21, 2020, 1:17:13 PM
    Author     : Bogdan
--%>
<%@page import="java.io.PrintWriter"%>
<jsp:useBean id="definition" scope="session"
    class="com.mycompany.seminar2.Definition"/>
<%@page import="com.mycompany.seminar2.LanguageFilePaths"%>
<%@page import="com.mycompany.seminar2.FileWR"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "tlds/custom.tld"%>
<% 
 String path = "" + LanguageFilePaths.filePathForLanguage.get(request.getParameter("language")); 
 String[] wordDefinitions = FileWR.GetFileData(path);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Word
                </th>
                <th>
                    Definition
                </th>
            </tr>
            <%
                for (int i = 0; i<wordDefinitions.length - 1; i+=2)
                  if(wordDefinitions[i] != null)
                  {out.print("<tr>");
                   out.print("<td>" + wordDefinitions[i] + "</td>");
                   out.print("<td>" + wordDefinitions[i + 1] + "</td>");
                   out.print("</tr>");
                  }
                response.setContentType("text/html");
            %>
            
        </table>
            <ex:Definition word="pisica"/>
    </body>
</html>
