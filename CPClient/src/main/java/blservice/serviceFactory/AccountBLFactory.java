package blservice.serviceFactory;

import bl.accountbl.AccountBLService_Stub;
import blservice.accountblservice.FinanceListService;

public class AccountBLFactory {
	public static FinanceListService getFinanceListService(){
		//TODO change return type when finish 
//		return new FinanceListServiceController();
		return new AccountBLService_Stub();
	}
}
