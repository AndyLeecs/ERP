package ui.accountUI;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;

public class CollectionListWinApproveController extends CollectionAndPaymentListWinApproveController{

	public CollectionListWinApproveController(CollectionListVO vo) {
		super(vo);
	}
	
	@FXML
	public void initialize(){
		titleLabel.setText("收款单");
	}
	
}
