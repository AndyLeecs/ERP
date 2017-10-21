package userbl;

import VO.UserVO;
import userblservice.userblservice;

public class userbl_stub implements userblservice{
	public String check_login (String name, String id){
		return "Success";
	}

	public String create(UserVO vo) {
		// TODO Auto-generated method stub
		return "Success";
	}

	public String delete(String name) {
		// TODO Auto-generated method stub
		return "Success";
	}

	public String modify(UserVO vo) {
		// TODO Auto-generated method stub
		return "Success";
	}

	public UserVO userInfo(String id) {
		UserVO u1=new UserVO("161250143","wangruihua","123456",3);
		return u1;
	}
	
	public void userbl_driver(){
		
	}
}
