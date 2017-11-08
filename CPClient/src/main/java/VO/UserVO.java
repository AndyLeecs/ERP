package VO;

import java.io.Serializable;

public class UserVO implements Serializable{
		  String id;
		  String name;
		  String password;
		  UserType usertype;
		  boolean hashighLimit=false;
		  int level;
		  
	public UserVO(String i,String n,String p,int l,UserType usertype){
		  this.id=i;
		  this.name =n;
		  this.password=p;
		  this.level=l ;
		  this.usertype = usertype;
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

	public UserType getType(){
		 return usertype;
		}
    public int getLevel(){      	 
        return level;
    }
}

