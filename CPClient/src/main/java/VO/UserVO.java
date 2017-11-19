package VO;

import java.io.Serializable;

public class UserVO implements Serializable{
		  String id;
		  String name;
		  String password;
		  UserType userType;
		  boolean hasHighLimit=false;
//		  int level;		//这是什么？
		  
	public UserVO(String i,String n,String p,int l,UserType usertype){
		  this.id=i;
		  this.name =n;
		  this.password=p;
//		  this.level=l ;
		  this.userType = usertype;
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
		 return userType;
		}
//    public int getLevel(){      	 
//        return level;
//    }
}

