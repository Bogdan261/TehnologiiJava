/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

/**
 *
 * @author Bogdan
 */
public class TextValidation {
    
     private static String existingWordMessage = "This word already exists in the dictionary";
     private static String emptyWordMessage = "Please insert a word";
     private static String emptyDefinitionMessage = "Please insert a definition";
    
    private static boolean checkExistingWord(String word, String path)
    {
        String[] linesFromText = FileWR.GetFileData(path);
        for(int i = 0; i < linesFromText.length - 1; i+=2)
            if(linesFromText[i] != null)
              if( linesFromText[i].toLowerCase().trim().equals(word.toLowerCase().trim()) )
                {return true;}              
        return false;           
    }
    
    public static String checkWordValidity(String word, String path)
    {
        if(word == null)
              return emptyWordMessage;
        if(word.trim().equals(""))
              return emptyWordMessage;
        if(checkExistingWord(word, path))
              return existingWordMessage;
        return "";
    }
    
    public static String checkDefinitionValidity (String definition)
    {
         if(definition== null)
              return emptyDefinitionMessage;
        if(definition.trim().equals("") || definition.equals(""))
              return emptyDefinitionMessage;
        return "";
    }
      
}
