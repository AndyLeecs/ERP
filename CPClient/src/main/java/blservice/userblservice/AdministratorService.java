package blservice.userblservice;

import VO.userVO.UserVO;
import resultmessage.NewUserRM;

public interface AdministratorService {

	
    public NewUserRM checkNewUserName(String name);							//创建新用户,输入用户名，返回用户是否存在
    public void initAndSave(UserVO vo);					//保存新用户信息
    public void delete(String id);							//删除用户
    public void modify(UserVO vo);							//修改用户信息

    
}
