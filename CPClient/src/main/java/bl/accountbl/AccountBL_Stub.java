package bl.accountbl;

import java.util.ArrayList;
import java.util.Map;

import VO.*;
import bl.utilitybl.ResultMessage;
import blservice.accountblservice.AccountBL;
/**
 * 
 * @author julia98
 *
 */
public class AccountBL_Stub implements AccountBL{
	private static final GoodsVO testGoodsVO = new GoodsVO();
    private static final VIPVO vipVO = new VIPVO("000001","张三","00000","客户", null);
	
	public GoodsVO getGoodsInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return testGoodsVO;
	}

	public VIPVO getMemberInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Search Success!");
		return vipVO;
	}

	public ResultMessage saveInitAccountInfo(AccountVO vo) {
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

	public ResultMessage modifyAccount(String name, AccountVO vo) {
		// TODO Auto-generated method stub
		vo.modifyAccount(name);
		System.out.println("Save Success!");
		return ResultMessage.SUCCESS;
	}

	public ArrayList<AccountVO> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO();
		ArrayList<String> a = accountVO.searchAccount(keyword);
		System.out.println("Search Success!");
		return a;
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
		switch(type) {
		case AccountantListType.CashExpenseList:
			CashExpenseListVO cashExpenseListVO = new CashExpenseListVO();
			break;
		case AccountantListType.CollectMoneyList:
			CollectMoneyListVO collectMoneyListVO = new CollectMoneyListVO();
			break;
		case AccountantListType.PaymentList:
			PaymentListVO paymentListVO = new PaymentListVO();
			break;
		}
		System.out.println("Open Success!");
		return null;
	}

	public ResultMessage saveList(ListType type, PaymentListVO vo) {
		System.out.println("Save Success!");
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public Map searchVIP(String id, String name) {
		vipVO.getVIP();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return null;
	}

	public VIPVO getVIP(String id) {
        vipVO.getName();
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return vipVO;
	}

	public AccountVO getAccount(String name) {
		AccountVO accountVO = new AccountVO();
		accountVO.getAccount(name);
		System.out.println("Search Success!");
		// TODO Auto-generated method stub
		return accountVO;
	}

	public ResultMessage commitList(ListType type, PaymentListVO vo) {
		if(type == ListType)
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
	public CollectMoneyListVO newCollectMoneyList(ListType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentListVO newPaymentList(ListType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashExpenseListVO newCashExpenseList(ListType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
