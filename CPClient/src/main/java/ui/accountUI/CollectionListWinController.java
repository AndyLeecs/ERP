package ui.accountUI;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;

public class CollectionListWinController extends CollectionAndPaymentListWinController{
	
	
	public CollectionListWinController(){}
	public CollectionListWinController(CollectionListVO vo){super(vo);}

	@FXML
	public void initialize(){
		titleLabel.setText("收款单");
	}

}


