package blservice.serviceFactory;

import bl.accountbl.AccountBLService_Stub;
import bl.accountbl.AccountManagementServiceImpl;
import bl.accountbl.CashExpenseListImpl;
import bl.accountbl.CollectionListImpl;
import blservice.accountblservice.AccountManagementService;
import blservice.accountblservice.FinanceListService;
import network.accountRemoteHelper.CashExpenseListDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;

public class AccountBLFactory {
	public static FinanceListService getFinanceListService(){
		//TODO deprecate
		return new AccountBLService_Stub();
	}
	
	public static FinanceListService getCollectionListService(){
		return new CollectionListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getPaymentListService(){
		//TODO change return when bl finish
		return new AccountBLService_Stub();
//		return new PaymentListImpl(PaymentListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getCashExpenseListService(){
		//TODO change return when bl finish
//		return new AccountBLService_Stub();
		return new CashExpenseListImpl(CashExpenseListDataServiceHelper.getInstance().getDataService());
	}
	
	public static AccountManagementService getAccountManagementService(){
		return new AccountManagementServiceImpl();
	}
}
