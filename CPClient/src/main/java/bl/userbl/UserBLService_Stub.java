package bl.userbl;

import java.util.ArrayList;
import java.util.List;

import VO.MessageVO;
import VO.OperationVO;
import VO.UserVO;
import bl.utilitybl.ResultMessage;
import blservice.userblservice.UserBLService;

public class UserBLService_Stub implements UserBLService{
	
	protected static final MessageVO messagevo = null;
	protected static final UserVO uservo = null;
	protected static final OperationVO operationvo = null;
	
	
	@Override
	public ResultMessage login(String name, String password) {
		return ResultMessage.SUCCESS;
		}

	@Override
	public ResultMessage changePassword(String oldPassword, String newPassword) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<MessageVO> checkMessage(String id) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		list.add(messagevo);
		return list;
	}

	@Override
	public String newUser(String name) {
		return "大师";
	}

	@Override
	public ResultMessage initAndSave(UserVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(UserVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<UserVO> findUser(String info) {
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(uservo);
		return list;
	}

	@Override
	public List<OperationVO> viewLog() {
		List<OperationVO> list = new ArrayList<OperationVO>();
		list.add(operationvo);
		return list;
	}

	@Override
	public ResultMessage saveOperation(OperationVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	
}