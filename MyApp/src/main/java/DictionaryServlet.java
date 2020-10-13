/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bogdan
 */
@WebServlet(name = "dictionary", urlPatterns = {"/dictionary"})
public class DictionaryServlet extends HttpServlet {  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DictionaryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DictionaryServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String[] getValidWords( char[] letters)
    {  String dictionaryWords[] = new String[130000];
       int dictionaryWordsCounter=0;
       File myObj = new File("C:\\Users\\Bogdan\\Desktop\\Words.txt");
       try {
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        dictionaryWords[dictionaryWordsCounter] = data;
        dictionaryWordsCounter++;
          }
        myReader.close();
      } 
       catch (FileNotFoundException e) {
       System.out.println("An error occurred.");
       e.printStackTrace();
       }
    
       String[] validWords = new String[100000];
       int validWordsCounter = 0;      
       for( int i=0; i < dictionaryWordsCounter; i++)
       { int[] remainingLetters = new int[28];
         for( int j=0; j < letters.length; j++)
             remainingLetters[ Character.toLowerCase( letters[j] ) - 97 ]++;
         for(int j=0; j < dictionaryWords[i].length(); j++)
             if( Character.toLowerCase( dictionaryWords[i].charAt(j)) <= 'z' && Character.toLowerCase( dictionaryWords[i].charAt(j)) >= 'a' )
             remainingLetters[ Character.toLowerCase( dictionaryWords[i].charAt(j)) - 97  ] -- ;
         boolean found = true;
         for( int j=0; j < 27; j++)
             if( remainingLetters[j] < 0)
                 found = false;
         
         if( found == true )
             {validWords[ validWordsCounter ] = dictionaryWords[i];
              validWordsCounter++;
             }       
       
           
       }
               
       return validWords;
    }
    
    private char[] getWordLetters (String word)
    {
        char[] y = new char[word.length()];
        int i=0,z=0;      
        int a = 1;
        while (a <= word.length()) {
            y[z] = word.charAt(word.length() - a);
            z = z + 1;
            a = a + 1;
        }  
        return y;
    }        
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        long startTime = System.nanoTime();
        String result = request.getParameter("name");
        char[] letters = getWordLetters(result);
        String[] validWords = getValidWords( letters );
        StringBuilder words = new StringBuilder();
        for(int i=0; i < validWords.length; i++)
            if( validWords[i] != null)
            {
            words.append( validWords[i] + " " );
            }
            else 
              break;
        try (PrintWriter out = response.getWriter()) 
         {out.println("List of the valid words:  " + words.toString());}
        long endTime = System.nanoTime();
        
        ServletContext context = getServletContext( );
        context.log(request.getMethod() + " Address: " + request.getRemoteAddr() + 
                    " Querry string: " + request.getQueryString() + " Language: " + request.getLocale() + " Execution time: " + ((endTime-startTime)/1000000) + "ms" );
       
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
