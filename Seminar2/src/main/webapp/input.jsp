<%-- 
    Document   : input
    Created on : Oct 21, 2020, 1:02:50 PM
    Author     : Bogdan
--%>

<%@page import="com.mycompany.seminar2.FileWR"%>
<%@page import="com.mycompany.seminar2.LanguageFilePaths"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 String language = "";
 String[] languages = FileWR.GetFileData(LanguageFilePaths.filePathForLanguage.get("Languages") + "");
 
 if (session.isNew())
 {   
    language=languages[0];
    session.setAttribute("languageKey", language);
 }
 else 
 {
 for(int i = 0; i<=languages.length; i++)
    if (languages[i] != null)
      if(languages[i] == session.getAttribute("languageKey"))
        if(i==0) break;
        else
        {
            String aux = languages[0];
            languages[0] = languages[i];
            languages[i] = aux;
            break;          
        }
      else break;
 }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <img src="CaptchaGenerator" />
      <form action="inputcontroller">
       <select name="language">
           <option value="">Nothing</option>
         <% for(int i = 0; i<=languages.length; i++)
             if (languages[i] != null)
              out.print(" <option value="+ languages[i] +">"+ languages[i] +"</option>");
             else break;
         %>       
        </select>
          <br>
          <input type="text" name="word" placeholder="word"/>
          <br>
          <input type="text" name="definition" placeholder="Definition" />
          <br>
           <br>
          <input type="number" name="answer" placeholder="Captcha Answer" />
          <br>
       <input type="submit" value="Submit" />
      </form>
    </body>
</html>
