  package ISD.Assignment.Controller;

   import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
   import javax.servlet.http.HttpSession; 


   public class ValidatorShipment implements Serializable{ 

 
   private String datePattern = "([0-9]{4})(-)([0-9]{2})(-)([0-9]{2})";      
   private String IDPattern = "([0-9]*)";
   private String phonePattern = "([0-9]*)";  
   private String postCodePattern = "([0-9]*)";  
              
   public ValidatorShipment(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   
   public boolean validateDate(String date){                       

      return validate(datePattern,date);   

   }

       
   public boolean validateID(String ID){

      return validate(IDPattern,ID); 

   }     
      public boolean validatePhone(String ID){

      return validate(phonePattern,ID); 

   }       
         public boolean validatePostCode(String ID){

      return validate(postCodePattern,ID); 

   }       
   
  
   
   public void clear(HttpSession session){
    session.setAttribute("dateErr","Enter date");
    session.setAttribute("IDErr","Enter ID");
    session.setAttribute("phoneErr","Enter phone");
    session.setAttribute("postCodeErr","Enter post code");
   }
}


