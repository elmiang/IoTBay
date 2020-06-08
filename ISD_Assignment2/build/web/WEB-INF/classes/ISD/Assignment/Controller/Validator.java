/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;


   public class Validator implements Serializable{ 

 
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private String passwordPattern = "[a-zA-Z0-9]{4,}";  
   private String addressPattern = "[a-zA-Z0-9]{4,}";
   private String postCodePattern = "[0-9]+";
   private String phoneNumberPattern = "[a-zA-Z0-9]{6,}";
   private String numberPattern = "^\\d+$";
   private String datePattern = "([0-9]{4})(-)([0-9]{2})(-)([0-9]{2})";      
   private String intPattern = "([0-9]*)";  
   //private String fieldPattern
              
   public Validator(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       

      return match.matches(); 

   }       

   public boolean checkEmpty(String email, String password){       

      return  email.isEmpty() || password.isEmpty();   

   }
   
   public boolean validateAddress(String address){
       return validate(addressPattern, address);
   }
   
   public boolean validatePostCode(String postCode){
       return validate(postCodePattern, postCode);
   }
   
   public boolean validatePhoneNumber(String phoneNumber){
       return validate(phoneNumberPattern, phoneNumber);
   }
   
   public boolean validateEmail(String email){                       

      return validate(emailPattern,email);   

   }

       
   public boolean validateName(String name){

      return validate(namePattern,name); 

   }       
   

   public boolean validatePassword(String password){

      return validate(passwordPattern,password); 

   }
   
   public boolean validateNumber(String number){
   
       return validate(numberPattern, number);
   }
   
   public boolean validateDate(String date){                       

      return validate(datePattern,date);   

   }

   public boolean validateInt(String ID){

      return validate(intPattern,ID); 

   }   
   
   public void clear(HttpSession session){
       session.setAttribute("emailErr", "Enter Email");
       session.setAttribute("passErr", "Enter Password");
       session.setAttribute("existErr", "");
       session.setAttribute("addressErr", "Enter Address");
       session.setAttribute("postCodeErr", "Enter PostCode");
       session.setAttribute("phoneNumberErr", "Enter Phone Number");
       session.setAttribute("priceErr", "");
       session.setAttribute("quantityErr", "");
   }
}