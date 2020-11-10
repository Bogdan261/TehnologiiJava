package com.mycompany.seminar2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bogdan
 */
// clasa folosita pentru scrierea la final de fisier a unui rand nou si pentru citrea randurilor dintr-un fisier
public class FileWR {
    
    public static String[] GetFileData( String path)
    {  String lines[] = new String[100];
       int linesCounter=0;
       File myObj = new File(path);
       try {
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines[linesCounter] = data;
        linesCounter++;
          }
         myReader.close();
       } 
       catch (FileNotFoundException e) {
       System.out.println("An error occurred.");
       e.printStackTrace();
       }
       return lines;
    } 
    
    public static void WriteFileData (String path, String word, String definition)
    {
    try(FileWriter fw = new FileWriter(path, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
        {
          out.println(word);
         //more code
         out.println(definition);
         //more code
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
       }    
    }
    
    
    
}
