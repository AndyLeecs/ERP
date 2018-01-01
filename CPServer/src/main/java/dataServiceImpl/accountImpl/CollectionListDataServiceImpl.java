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
	
	//TODO delete it when dataService all finishes!
	public static void main(String [] args){
		CollectionListPO po = new CollectionListPO();
		po.setId("SKD-20171227-00001");
		po.setVIPID("monk");
		try {
			FinanceListDataServiceImpl impl = new CollectionListDataServiceImpl();
//			System.out.println(impl.delete("SKD-20171227-00001"));
			System.out.println(impl.insert(po));
			
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	

}
