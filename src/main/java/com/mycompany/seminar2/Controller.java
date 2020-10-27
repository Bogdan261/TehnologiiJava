package com.mycompany.seminar2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bogdan
 */
// Flow ul aplicatiei: cand se intra pe /input.jsp se completeaza un form
// Daca datele nu sunt valide (captcha gresit, campuri goale, definitii deja existente) utilizatorul este redirectioant catre un mesaj de eroare pe o pagina separata
// Daca datele sunt valdie, este trimis pe result.jsp unde vede lista definitiilordin dictionar in functie de limba selectata
@WebServlet(name="Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession session = request.getSession();
      session.setAttribute("languageKey", request.getParameter("language"));
      Cookie c = new Cookie("language",request.getParameter("language"));
      c.setMaxAge(10);
      response.addCookie(c);
      String word = request.getParameter("word");
      String definition = request.getParameter("definition");
      String captchaError ="";
      int captchaAnswer = Integer.parseInt(request.getParameter("answer"));
      if(captchaAnswer != Integer.parseInt(""+ session.getAttribute("answer")))
          captchaError = "Wrong captcha answer";
          
      String path = "" + LanguageFilePaths.filePathForLanguage.get(request.getParameter("language"));
      String wordError = TextValidation.checkWordValidity(word, path);
      String definitionError = TextValidation.checkDefinitionValidity(definition);     
     
      String nextPage ="";
      if( wordError.equals("") && definitionError.equals("") && captchaError.equals(""))
      {   FileWR.WriteFileData(path, word, definition);
          nextPage =  "/result.jsp";
      }
      else 
      {nextPage = "/error.jsp";
       session.setAttribute("errors", wordError + " <br> " + definitionError + " <br> " + captchaError);
       }
      
      getServletContext().getRequestDispatcher(nextPage).forward(request, response);
    }
    
}
