package VO;

import java.io.Serializable;

public class UserVO implements Serializable{
		  String id;
		  String name;
		  String password;
		 // UserRole role;
		  boolean hashighLimit=false;
		  int level;
		  
		  public UserVO(String i,String n,String p,int l){
		  id=i;
		  name =n;
		  password=p;
		 level=l ;
		  }

		  public String getName(){
		  return name;
		  }
		    
		  public String getID(){
		        return id;
		  }
		  
		  public String getPassword(){
		     return password;
		  }

	/*	  public UserRole getRole(){
		     return role;
		}*/
         public int getLevel(){
        	 
        	 return level;
         }
		   }
