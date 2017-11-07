package bl.userbl;

import VO.UserVO;
import blservice.userblservice.userblservice;
import dataservice.userdataservice.*;
import PO.*;
public class userbl_stub implements userblservice{
	Userdataservice_stub us;
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
	
	public void userdata_driver(){
		UserPO po=new UserPO("161250143","wangruihua","123456",3);
		us.insert(po);
		us.find(po);
		us.delete(po);
		us.update(po);
	}
}
