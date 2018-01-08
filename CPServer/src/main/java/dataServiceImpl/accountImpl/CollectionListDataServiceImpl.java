package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;

import PO.account.CollectionListPO;
import dataHelper.HibernateUtil;
import dataService.accountDataService.CollectionListDataService;

public class CollectionListDataServiceImpl extends FinanceListDataServiceImpl implements CollectionListDataService{

	private static final long serialVersionUID = 2025751205261887468L;

	public CollectionListDataServiceImpl() throws RemoteException{
		super();
		basicUtil = new HibernateUtil<CollectionListPO>(CollectionListPO.class);
		
	}
	
	@Override
	public String getNewListId()  throws RemoteException{
		return basicUtil.getNewListId("SKD", new CollectionListPO());
		
	}
	

}
