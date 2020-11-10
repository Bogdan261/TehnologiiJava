/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

import static com.mycompany.seminar2.LanguageFilePaths.filePathForLanguage;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Bogdan
 */
public class CustomTag extends SimpleTagSupport {
    private String word;
    private String language;

   public void setWord(String word) {
      this.word = word;
   }
   public void setLanguage(String language) {
      this.language = language;
   }
   
   private String getDefinition(String word, String language)
   {  String path="";
      String definition = "";
       if(language == "" || (!language.equals("Romana") && !language.equals("English")))
           path = LanguageFilePaths.filePathForLanguage.get("Romana")+"";
       else
         if(language.equals("Romana") || language.equals("English"))
           path = LanguageFilePaths.filePathForLanguage.get(language)+"";
       String[] lines = FileWR.GetFileData(path);
       for(int i = 0; i< lines.length; i+=2)
           if(lines[i]!=null)
           if(lines[i].trim().toLowerCase().equals(word.trim().toLowerCase()))
           {definition = lines[i+1];
            break;
           }       
        return definition;                
   }
    
    public void doTag() throws JspException, IOException {
        
      if(language == null)
          language = "";
      if(word == null)
      {
      JspWriter out = getJspContext().getOut();
      out.println("No word was given!");
      }
      else
      {
          String definition = getDefinition(word,language);
          JspWriter out = getJspContext().getOut();
          if(definition == "")
              out.println("No word was given!");
          else
              out.println("Your definition for the word: "+ word +" is: " + definition);      
      }
   }
    
}
