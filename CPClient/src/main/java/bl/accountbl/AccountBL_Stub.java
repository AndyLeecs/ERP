package bl.accountbl;

import java.util.ArrayList;
import java.util.Map;

import VO.*;
import bl.utilitybl.ResultMessage;
/**
 * 
 * @author julia98
 *
 */
public class AccountBL_Stub implements AccountBL{
	private static final GoodsVO testGoodsVO = new GoodsVO("台灯","一型","护眼灯","0","000001",250.0,500.0,250.0,500.0);
    private static final VIPVO memberVO = new VIPVO("000001","张三","00000","客户");
	
	public GoodsVO getGoodsInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return testGoodsVO;
	}

	public VIPVO getMemberInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return memberVO;
	}

	public ResultMessage saveInitAccountInfo(InitAccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Save Success!");
		return ResultMessage.SUCCESS;	
	}

	public ResultMessage addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		vo.addAccount();
		System.out.println("Add Success!");
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deleteAccount(String name) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO();
		accountVO.deleteAccount();
		System.out.println("Delete Success!");
		return ResultMessage.SUCCESS;
	}

	public ResultMessage saveAccount(String name, AccountVO vo) {
		// TODO Auto-generated method stub
		vo.saveAccount(name);
		System.out.println("Save Success!");
		return ResultMessage.SUCCESS;
	}

	public ArrayList<String> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO();
		ArrayList<String> a = accountVO.searchAccount(keyword);
		System.out.println("Search Success!");
		return a;
	}

	public ListVO createList(ListType type) {
		// TODO Auto-generated method stub
		type = new ListType();
		System.out.println("Create Success!");
		return null;
	}

	public Map openDraftList() {
		// TODO Auto-generated method stub
		ListVO listVO = new ListVO();
		listVO.openDraftList();
		System.out.println("Open Success!");
		return null;
	}

	public Map openList(ListType type, String id) {
		// TODO Auto-generated method stub
		ListVO listVO = new ListVO();
		listVO.openList();
		System.out.println("Open Success!");
		return null;
	}

	public ResultMessage saveList(ListType type, PaymentListVO vo) {
		ListVO listVO = new ListVO();
		listVO.saveList();
		System.out.println("Save Success!");
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public Map searchMember(String id, String name) {
		memberVO.getMember();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return null;
	}

	public VIPVO getMember(String id) {
        memberVO.getName();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return memberVO;
	}

	public AccountVO getAccount(String name) {
		AccountVO accountVO = new AccountVO();
		accountVO.getAccount(name);
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return accountVO;
	}

	public ResultMessage commitList(ListType type, PaymentListVO vo) {
		ListVO listVO = new ListVO();
		listVO.commitList();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveInitAccountInfo(AccountVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ListVO createList(ListType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
