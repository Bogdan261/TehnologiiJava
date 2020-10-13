/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bogdan
 */
@WebServlet(urlPatterns = {"/dctEndpoint"})
public class DictionaryEndpoint extends HttpServlet {
    
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
    response.setContentType("application/json");
    String result = request.getParameter("name");
    char[] letters = getWordLetters(result);
    String[] validWords = getValidWords( letters );
    ObjectMapper obj = new  ObjectMapper();
    int wordCounter = 0;
   
    
     for(int i=0; i < validWords.length; i++)
            if( validWords[i] != null)
             wordCounter++;
            else 
                break;
    Word[] word = new Word[wordCounter];
     for(int i=0; i < validWords.length; i++)
            if( validWords[i] != null)
            {
                word[i] = new Word();
                word[i].text = validWords[i];
            }    
    String json = obj.writeValueAsString(word);
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
    
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
