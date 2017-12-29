package bl.accountbl;

import bl.utility.DomainList;
import dataService.accountDataService.PaymentListDataService;
import network.accountRemoteHelper.PaymentListDataServiceHelper;

public class PaymentList extends DomainList{

	PaymentListDataService dataService = PaymentListDataServiceHelper.getInstance().getDataService();
		

	@Override
	public PaymentListDataService getDataService() {
		return dataService;
	}
	
	
}
