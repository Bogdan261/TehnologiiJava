/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Bogdan
 */
//Clasa folosita pentru a 
public class LanguageFilePaths {
    public static  Dictionary filePathForLanguage = new Hashtable(); 
    
    static {
      filePathForLanguage.put("Romana", "C:\\Users\\Bogdan\\Desktop\\RomanianWords.txt");
      filePathForLanguage.put("English", "C:\\Users\\Bogdan\\Desktop\\EnglishWords.txt");
      filePathForLanguage.put("Languages", "C:\\Users\\Bogdan\\Desktop\\Languages.txt");
    }  
    
}
