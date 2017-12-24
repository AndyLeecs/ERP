package ui.accountUI;

import blservice.accountblservice.FinanceListService;
import ui.commonUI.ListWinController;

public class FinanceListWinController extends ListWinController{
	protected FinanceListService financeListService;
	
	public void setService(FinanceListService FListService){
		financeListService = FListService;
	}
}
