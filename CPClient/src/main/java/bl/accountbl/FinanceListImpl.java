package bl.accountbl;

import java.rmi.RemoteException;
import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import blservice.accountblservice.FinanceListService;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.CommitListRM;
import resultmessage.DeleteListRM;
import resultmessage.SaveListRM;

public class FinanceListImpl implements FinanceListService{

	FinanceListDataService financeListDataService;
	
	public FinanceListImpl(FinanceListDataService dataService){
		financeListDataService = dataService;
	}
	
	@Override
	public String newList() {
		try {
			String newId = financeListDataService.getNewListId();
			if(newId == null || newId == "")
				return null;
			return newId;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DeleteListRM delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveListRM save(FinanceListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommitListRM commit(FinanceListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends FinanceListVO> openDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends FinanceListVO> openCommitted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVO> findAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
