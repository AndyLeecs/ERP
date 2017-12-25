package ui.accountUI;

import blservice.accountblservice.FinanceListService;
import ui.commonUI.ListWinController;

public abstract class FinanceListWinController extends ListWinController{
	protected FinanceListService financeListService;
	
	public void setService(FinanceListService FListService){
		financeListService = FListService;
	}
}
