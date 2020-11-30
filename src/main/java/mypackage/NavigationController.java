/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.Serializable;  
import javax.enterprise.context.RequestScoped;


import javax.inject.Named;

@Named(value = "navigationController")
@RequestScoped

public class NavigationController implements Serializable {
  
   public String moveToPersons() {
      return "persons";
   }
    public String moveToMeetings() {
      return "meetings";
   }
     public String moveToLocations() {
      return "locations";
   }
     public String moveToEdit() {
      return "edit";
   }
      public String moveToView() {
      return "view";
   }
    public String moveToHome() {
      return "index";
   }
    
   
 }
