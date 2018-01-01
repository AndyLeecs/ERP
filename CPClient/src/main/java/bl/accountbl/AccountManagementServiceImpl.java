package bl.accountbl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import PO.account.AccountPO;
import VO.accountVO.AccountVO;
import blservice.accountblservice.AccountManagementService;
import dataService.accountDataService.AccountDataService;
import network.accountRemoteHelper.AccountDataServiceHelper;

public class AccountManagementServiceImpl implements AccountManagementService{

	AccountDataService service = AccountDataServiceHelper.getInstance().getDataService();
	
	@Override
	public List<AccountVO> getAllAccount() {
		try {
			List<AccountPO> poList = service.getAllAccount();
			return poList.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAllAccount(List<AccountVO> l) {
		try {
			service.deleteAllAccount();
			for(AccountVO vo : l){
				service.insert(voTopo(vo));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private AccountPO voTopo(AccountVO vo){
		return new AccountPO(vo.getAccountName(),vo.getBalance());
	}
	
	private AccountVO poTovo(AccountPO po){
		return new AccountVO(po.getAccountName(),po.getBalance());
	}

}
