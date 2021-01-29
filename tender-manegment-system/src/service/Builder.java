package service;

import java.util.*;

import businesslogic.RegisterationValidation;
import model.User;
import model.UserRegistration;

public class Builder{
	Scanner scanner = new Scanner(System.in);

	public User builderRegistration() {		
		 UserRegistration userRegistration=new UserRegistration();
		 return userRegistration.registerationDetails();
		
           /* System.out.print(" Enter firstName  as builder=> ");
            String fn = scanner.next();

            System.out.print(" Enter lastName => ");
            String lastName = scanner.next();

            System.out.print(" Enter userName => ");
            String userName = scanner.next();
            
            System.out.print(" Enter phoneNo => ");
            long phoneNo = scanner.nextLong();
          
            System.out.print(" Enter emailId => ");
            String emailId = scanner.next();
            
            System.out.print(" Enter password => ");
            String password = scanner.next();
            
            System.out.print(" confirm password => ");
            String confirmPassword = scanner.next();
            RegisterationValidation registerationValidation =new RegisterationValidation();
            if(registerationValidation.checkUserDetails(emailId,password,confirmPassword)==true) {
            	
            	return (new User(fn,lastName,userName,password,emailId,phoneNo,confirmPassword));
            	
            }else {
            	
            	return null;
            	
            }*/

                 
        }
	
	
	
	
	
	
	
	
}
		
		

	
