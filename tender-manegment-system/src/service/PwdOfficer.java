package service;

import java.util.Scanner;

import businesslogic.RegisterationValidation;
import model.Tender;
import model.User;
import model.UserRegistration;

public class PwdOfficer {
	//private String description;
	int bidprice = 100000;
	//User winner = null;
	

	public User pwdOfficerRegistration() {	
		
		UserRegistration userRegistration=new UserRegistration();
		 return userRegistration.registerationDetails();
		
	}		 
		 
		 public void declarewinner(int p, User u,int bp,Tender t) {
				if(p <= bidprice && p >= bp ) {
					t.winner = u;
					bidprice=p;
				}
			}


                 
   
}
