package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import businesslogic.LoginValidation;
import service.PwdOfficer;
import service.StateGovtOfficer;
import model.Tender;
import service.Builder;
import model.User;

public class Main{
	
	
    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
    	ArrayList <User> builder_list=new ArrayList<User>();
    	ArrayList <User> stateGovtOfficers_list=new ArrayList<User>();
    	ArrayList <User> PwdOfficers_list=new ArrayList<User>();
    	ArrayList <Tender> tender_list=new ArrayList<Tender>();
    	Map<User, ArrayList<Tender>> builderMap = new HashMap<User,ArrayList<Tender>>(); 
    	Map<Tender, ArrayList<User>> tenderMap = new HashMap<Tender,ArrayList<User>>(); 
		PwdOfficer pwdOffice=new PwdOfficer();
		
    	boolean exit=false;
    	String emailId,password;
    	while(exit==false) {
	    	System.out.println("Enter 1 if you want login:");
	    	System.out.println("enter 2 if you want to sign up:");
	    	System.out.println("Enter any other number if you want  to exit:");
	    	int options=sc.nextInt();
	    	if(options ==1) {
	    		System.out.println("Enter 1 if you want to login as builder");
	    		System.out.println("Enter 2 if you want to login as pwd ofiicer");
	    		System.out.println("Enter 3 if you want to login as state government officer ");
	    		int login_option;
	    		login_option=sc.nextInt();
	    		System.out.println("enter your email");
    			emailId = sc.next();
    			System.out.println("enter your password");
    			password = sc.next();
	    		switch(login_option) {
	    		case(1):
	    				User u=LoginValidation.validation(builder_list,emailId,password);
		    			if(u !=null) {
	    					System.out.println("Enter 1 if you want to view all the tenders available");
	    					int view=sc.nextInt();
	    					if(view==1) {
	    						StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
								stateGovtOfficer.viewTender(tender_list);
				    			System.out.println("Enter 2 to apply for a tender");
				    			int apply=sc.nextInt();
				    			if(apply==2) {
					    			System.out.println("Enter the name of tender for which you want to apply ");
					    			String nameOfTender=sc.next();
					    			System.out.println("Enter the bidprice of tender ");
					    			int bidprice=sc.nextInt();
					    			int check_title=0;
					    			for(Tender t:tender_list) {
					    				if((t.getTitle()).equals(nameOfTender)) {
					    					if (builderMap.get(u) == null) { 
					    						builderMap.put(u, new ArrayList<Tender>());
					    					}
					    					builderMap.get(u).add(t);
					    					if (tenderMap.get(t) == null) { 
					    						tenderMap.put(t, new ArrayList<User>());
					    					}
					    					tenderMap.get(t).add(u);
					    					check_title=1;
					    					pwdOffice.declarewinner(bidprice,u,t.getBaseprice(),t);
					    					break;
					    					
					    				}
					    				
					    			}
					    			if(check_title==0) {
					    				System.out.println(" tender name is not valid");
					    			}
					    			for (Map.Entry<User,ArrayList<Tender>> entry : builderMap.entrySet())  {
					    	            System.out.println("Key = " + entry.getKey()); 
					    	            System.out.println("Tenders Applied :");
										for(Tender d : entry.getValue()) {
											System.out.println(d.getTitle());
					    	            	
					    	            }
					    			}
					    			
					    			for (Map.Entry<Tender,ArrayList<User>> entry : tenderMap.entrySet())  {
					    	            System.out.println("Key = " + entry.getKey()); 
					    	            System.out.println("users who  Applied for this tender are :");
										for(User d : entry.getValue()) {
											System.out.println(d.getEmailId());
					    	            	
					    	            }
					    			}		
				    			}	
   					
    					}
		    			}
		    			else {
		    				System.out.println("login failed!!!!");
		    			}
	    		
	    		
	    		
		    			break;
	    		case(2):
	    			
		    			System.out.println(LoginValidation.validation(PwdOfficers_list,emailId,password));
						break;
	    		case(3):
	    			
		    			System.out.println(LoginValidation.validation(stateGovtOfficers_list,emailId,password));
		    			System.out.println("If you want to create a new tender enter 1,enter 2 if you want to view all the tenders you have created,enter 3 if you want to update texisting tender,enter 4 if you want to delete existing tender");
						int newtender=sc.nextInt();
						if(newtender==1) {

							StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
							tender_list.add(stateGovtOfficer.createNewTender());
							
						}
						
						else if(newtender==2) {
							StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
							stateGovtOfficer.viewTender(tender_list);
							
						}
						
						else if(newtender==3) {
							StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
							System.out.println("enter title of tender which you want to update");
							String update_title=sc.next();							
							System.out.println("enter updated tender description");
							String updated_description=sc.next();
							stateGovtOfficer.updateTender(tender_list,update_title,updated_description);	
						}
						
						else if(newtender==4) {
							StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
							System.out.println("enter title of tender which you want to delete");
							String delete_title=sc.next();
							
							stateGovtOfficer.deleteTender(tender_list,delete_title);	
								
							
						}						
		    			break;    		    			
	    			
	    		}
    	}
    	
    	else if(options == 2) {
    		int option;
    		System.out.println("Enter 1 if you want to register as builder");
    		//System.out.println("enter 2 if you want to register as pwd ofiicer");
    		System.out.println("enter 3 if you want to reigster as state government officer,enter 4 to exit ");
    		option=sc.nextInt();
			int validation_check=0;
			switch(option) {
				case(1):
					validation_check=0;
					while(validation_check==0) {
						Builder builder=new Builder();
						User obj = builder.builderRegistration();
					    if(obj!=null) {
					    	builder_list.add(obj);
					    	validation_check=1;
					    	
					    }
					    else {
					    	System.out.println("please re enter your details");
					    }
					}
				    break;
				/*case(2):
					//int validation_check=0;
					while(validation_check==0) {
						PwdOfficer pwdOfficer=new PwdOfficer();
						User obj1=pwdOfficer.pwdOfficerRegistration();
						if(obj1!=null) {
							PwdOfficers_list.add(obj1);
							validation_check=1;
						}
						else {
					    	System.out.println("please re enter your details");
					    }
					
					}
					break;*/
				case(3):
					validation_check=0;
					while(validation_check==0) {
						StateGovtOfficer stateGovtOfficer=new StateGovtOfficer();
						User obj2=stateGovtOfficer.stateGovtOfficerRegistration();
						if(obj2!=null) {
							stateGovtOfficers_list.add(obj2);
							validation_check=1;
							while(true) {
				    			System.out.println("If you want to create a new tender enter 1,enter 2 if you want to view all the tenders you have created,enter 3 if you want to update texisting tender,enter 4 if you want to delete existing tender");
								int newtender=sc.nextInt();
								if(newtender==1) {
									
									tender_list.add(stateGovtOfficer.createNewTender());
									System.out.println("Tender has been created sucessfully!!!");
									
									
								}
								else if(newtender==2) {
									stateGovtOfficer.viewTender(tender_list);
									
								}
								
								else if(newtender==3) {
									
									System.out.println("enter title of tender which you want to update");
									String update_title=sc.next();							
									System.out.println("enter updated tender description");
									String updated_description=sc.next();
									stateGovtOfficer.updateTender(tender_list,update_title,updated_description);	
								}
								
								else if(newtender==4) {
									
									System.out.println("enter title of tender which you want to delete");
									String delete_title=sc.next();
									stateGovtOfficer.deleteTender(tender_list,delete_title);	
										
									
								}						
								
								
								else {
									break;
								}
								
							}								
						}
						else {
							
					    	System.out.println("please re enter your details");
							
						}
					}
					
			for(User l : builder_list) {
		        System.out.println("builder "+l.getFirstName());
		    }
			for(User l : PwdOfficers_list) {
		        System.out.println("pwd "+l.getFirstName());
		        }
	
			for(User l : stateGovtOfficers_list) {
		        System.out.println("state govt "+l.getFirstName());
			}
			}
    	}
			
    	
    	else {
    		
    		exit=true;
    	}
    }
    	
    	for (Map.Entry<Tender,ArrayList<User>> entry : tenderMap.entrySet())  {
    		
    		 		
            Tender t=entry.getKey();
            if(t.winner!=null) {
            System.out.println(t.getTitle() +" "+t.winner.getEmailId());
            }
            else {
                System.out.println(t.getTitle() +" "+"no one ");	
            }
		}		
    	
    	
    	}
   }