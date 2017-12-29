package blservice.serviceFactory;

import bl.accountbl.AccountBLService_Stub;
import bl.accountbl.FinanceListImpl;
import blservice.accountblservice.FinanceListService;
import network.accountRemoteHelper.CollectionListDataServiceHelper;

public class AccountBLFactory {
	public static FinanceListService getFinanceListService(){
		//TODO deprecate
		return new AccountBLService_Stub();
	}
	
	public static FinanceListService getCollectionListService(){
		//TODO change return when bl finish
		return new AccountBLService_Stub();
//		return new FinanceListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getPaymentListService(){
		//TODO change return
		return new FinanceListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getCashExpenseListService(){
		//TODO change return
		return new FinanceListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
}
