package bl.userbl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import PO.user.UserPO;
import VO.userVO.UserVO;
import blservice.userblservice.AdministratorService;
import dataService.userDataService.UserDataService;
import network.userRemoteHelper.UserDataServiceHelper;
import resultmessage.NewUserRM;

public class AdministratorServiceImpl implements AdministratorService{

	UserDataService dataService = UserDataServiceHelper.getInstance().getDataService();
	
	@Override
	public NewUserRM checkNewUserName(String name) {
		try {
			if(dataService.getUser(name) != null){
				return NewUserRM.EXIST;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return NewUserRM.VALID;
	}

	@Override
	public void initAndSave(UserVO vo) throws RemoteException{
		UserPO po = voTopo(vo);
		dataService.insert(po);
	}

	@Override
	public void delete(String name) throws RemoteException {
		dataService.delete(name);
	}

	@Override
	public void modify(UserVO vo) throws RemoteException {
		UserPO po = voTopo(vo);
		try{
			dataService.update(po);
		}
		catch(RemoteException e){
			dataService.insert(po);
		}
		
	}
	
	@Override
	public List<UserVO> getAllUser() {
		try {
			List<UserPO> poList = dataService.getAllUser();
			return poList.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private UserVO poTovo(UserPO po){
		return new UserVO(po.getId(),po.getName(),po.getPassword(),
				po.getType(),po.getGrade(),po.getPermission());
	}
	
	private UserPO voTopo(UserVO vo){
		return new UserPO(vo.getId(),vo.getName(),vo.getPassword(),
				vo.getType(),vo.getGrade(),vo.getPermission());
	}

	

}
