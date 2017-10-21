package userblservice;
import VO.UserVO;
public interface userblservice {
	
    public String check_login(String name, String id);//登录账户
    public String create(UserVO vo);//创建账户
    public String delete(String name);//删除账户
    public String modify(UserVO vo); //更新账户信息
    public UserVO userInfo(String id);//返回用户信息
    
    
}
