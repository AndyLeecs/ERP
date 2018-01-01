package ui.accountUI;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;
import ui.commonUI.ListWinController;
import ui.mainUI.accountantUI.AccountantWinController;

public class CollectionListBriefDraftController extends ListWinController{

	AccountantWinController accountantWinController;
	
	CollectionListVO vo;

	@Override
	public void init() {
		setListID(vo.getId());
		setOperator(vo.getOperator());
		
	}
	
	public void setCollectionListVO(CollectionListVO vo){
		this.vo = vo;
	}
	
	public void setAccountantWinController(AccountantWinController  accountantWinController){
		this.accountantWinController =  accountantWinController;
	}

	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadCollectionDraftList(vo);
	}

}
