package accountbl;

import java.util.ArrayList;
import java.util.Map;

import VO.AccountVO;
import VO.GoodsVO;
import VO.InitAccountVO;
import VO.ListInitVO;
import VO.ListType;
import VO.ListVO;
import VO.MemberVO;
import VO.PaymentListVO;

public class AccountBL_Stub implements AccountBL{
	private static final GoodsVO testGoodsVO = new GoodsVO("台灯","一型","护眼灯","0","000001",250.0,500.0,250.0,500.0);
    private static final MemberVO memberVO = new MemberVO("000001","张三","00000","客户");
	
	public GoodsVO getGoodsInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return testGoodsVO;
	}

	public MemberVO getMemberInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return memberVO;
	}

	public void saveInitAccountInfo(InitAccountVO vo) {
		// TODO Auto-generated method stub
		vo = new InitAccountVO("000001","信息");//??
		System.out.println("Save Success!");	
	}

	public boolean addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		vo.addAccount();
		System.out.println("Add Success!");
		return false;
	}

	public boolean deleteAccount(String name) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO();
		accountVO.deleteAccount();
		System.out.println("Delete Success!");
		return false;
	}

	public void saveAccount(String name, AccountVO vo) {
		// TODO Auto-generated method stub
		vo.saveAccount(name);
		System.out.println("Save Success!");
		
	}

	public ArrayList<String> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO();
		accountVO.searchAccount(keyword);
		System.out.println("Search Success!");
		return null;
	}

	public ListInitVO createList(ListType type) {
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

	public void saveList(ListType type, PaymentListVO vo) {
		ListVO listVO = new ListVO();
		listVO.saveList();
		System.out.println("Save Success!");
		// TODO Auto-generated method stub
		
	}

	public Map searchMember(int id, String name) {
		memberVO.getMember();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO getMember(int id) {
        memberVO.getName();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return memberVO;
	}

	public AccountVO getAccount(String accountName) {
		AccountVO accountVO = new AccountVO();
		accountVO.getAccount(accountName);
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return null;
	}

	public void commitList(ListType type, PaymentListVO vo) {
		ListVO listVO = new ListVO();
		listVO.commitList();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		
	}

}
