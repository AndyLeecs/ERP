package ui.accountUI;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;

public class PaymentListWinApproveController extends CollectionAndPaymentListWinApproveController{

	public PaymentListWinApproveController(CollectionListVO vo) {
		super(vo);
	}
	
	@FXML
	public void initialize(){
		titleLabel.setText("付款单");
	}
	
}
