package ui.accountUI;

import VO.accountVO.CollectionListVO;
import ui.commonUI.ListWinController;
import ui.mainUI.accountantUI.AccountantWinController;

public class CollectionAndPaymentListBriefDraftController extends ListWinController{

	AccountantWinController accountantWinController;
	
	CollectionListVO vo;

	@Override
	public void init() {
		setListID(vo.getId());
		setOperator(vo.getOperator());
		
	}
	
	public void setVO(CollectionListVO vo){
		this.vo = vo;
	}
	
	public void setAccountantWinController(AccountantWinController  accountantWinController){
		this.accountantWinController =  accountantWinController;
	}	
}
