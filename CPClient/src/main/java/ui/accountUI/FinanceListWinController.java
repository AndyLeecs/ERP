package ui.accountUI;

import blservice.accountblservice.FinanceListService;
import blservice.serviceFactory.AccountBLFactory;
import ui.commonUI.ListWinController;

public abstract class FinanceListWinController extends ListWinController{
	protected FinanceListService financeListService = AccountBLFactory.getFinanceListService();
	
	public void setService(FinanceListService FListService){
		financeListService = FListService;
	}
}
