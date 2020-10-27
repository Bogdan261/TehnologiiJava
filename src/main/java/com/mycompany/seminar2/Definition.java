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
// clasa JavaBeans pe care nu am utilizat-o dar respecta conventiile
public class Definition {
    private String word = "";
    private String definition = "";
    public Definition(){}
    
    public void setWord (String word)
    {
        this.word = word;
    }
    public String getWord()
    {
        return this.word;
    }
    public void setDefinition (String definition)
    {
        this.definition = definition;
    }
    public String getDefinition()
    {
        return this.definition;
    }
    
}
