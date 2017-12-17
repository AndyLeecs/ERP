package ui.mainUI.loginUI;

import VO.userVO.UserVO;
import bl.userbl.UserBLService_Stub;
import blservice.userblservice.PersonalInfoService;
import util.LoginRM;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class User {
	private PersonalInfoService service;
	private static User user;
	
	boolean loggedIn = false;		//是否登录，不知道有没有用。。
	
	private String id;
	private	String name;
	private	UserType type = UserType.Salesman;				
	private	UserGrade grade;			//用户等级（经理，普通）
	private	UserPermission permission;		//权限等级
											//为了安全，密码不让界面层持有，不过userVO里是否要有密码？
	private User(){
		service = new UserBLService_Stub();
	}
	
	public static User getInstance(){
		if(user == null)
			user = new User();
		return user;
	}
	
	
	public LoginRM login(String username, String password){
		LoginRM loginrm = service.login(username, password);
		if(loginrm == LoginRM.SUCCESS){
			loggedIn = true;
			UserVO uservo = service.getCurrentUserInfo();
			this.id = uservo.getID();
			this.name = uservo.getName();
			this.type = uservo.getType();
			this.grade = uservo.getGrade();
			this.permission = uservo.getPermission();
		}
		
		return loginrm;
	}
	
	public void logout(){
		service.logout();
		user = null;
	}
	
	public UserType getUserType(){
		return type;
	}
	
}
