/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.Serializable;  

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ManagedProperty; 
import javax.faces.bean.RequestScoped;  

@ManagedBean(name = "navigationController", eager = true)
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
