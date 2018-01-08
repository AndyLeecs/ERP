package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;

import PO.account.PaymentListPO;
import dataHelper.HibernateUtil;
import dataService.accountDataService.PaymentListDataService;

public class PaymentListDataServiceImpl extends FinanceListDataServiceImpl implements PaymentListDataService{

	private static final long serialVersionUID = 126476166705282771L;

	public PaymentListDataServiceImpl() throws RemoteException{
		super();
		basicUtil = new HibernateUtil<PaymentListPO>(PaymentListPO.class);
		
	}
	
	@Override
	public String getNewListId()  throws RemoteException{
		return basicUtil.getNewListId("FKD", new PaymentListPO());
	}
	

}
