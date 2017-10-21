package accountbl;

import java.util.ArrayList;
import java.util.Map;

import VO.AccountVO;
import VO.GoodsVO;
import VO.InitAccountVO;
import VO.ListInitVO;
import VO.ListType;
import VO.MemberVO;
import VO.PaymentListVO;

public class AccountBL_stub implements AccountBL{

	public GoodsVO getGoodsInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO getMemberInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveInitAccountInfo(InitAccountVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAccount(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveAccount(String name, AccountVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListInitVO createList(ListType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map openDraftList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map openList(ListType type, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveList(ListType type, PaymentListVO vo) {
		// TODO Auto-generated method stub
		
	}

	public Map searchMember(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO getMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO getAccount(String AccountName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void commitList(ListType type, PaymentListVO vo) {
		// TODO Auto-generated method stub
		
	}

}
