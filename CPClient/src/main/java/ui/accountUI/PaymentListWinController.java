package ui.accountUI;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;

public class PaymentListWinController extends CollectionAndPaymentListWinController{
	
	
	public PaymentListWinController(){}
	public PaymentListWinController(CollectionListVO vo){super(vo);}

	@FXML
	public void initialize(){
		titleLabel.setText("付款单");
	}

}


