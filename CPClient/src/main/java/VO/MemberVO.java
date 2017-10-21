package VO;

import java.util.ArrayList;

public class MemberVO {
	  String id;
	  String name;
	  String password;
	  String role;
	  boolean hashighLimit;
	  ArrayList<String> memberInfo;
	  
	  public MemberVO(String i,String n,String p,String r){
	  id=i;
	  name =n;
	  password=p;
	  role=r;
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

	  public String getRole(){
	     return role;
	  }
	  
	  public ArrayList<String> getMember(){
		  return memberInfo;
	  }

}
