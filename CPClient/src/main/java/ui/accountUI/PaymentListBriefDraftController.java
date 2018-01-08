package ui.accountUI;

import javafx.fxml.FXML;

public class PaymentListBriefDraftController extends CollectionAndPaymentListBriefDraftController{


	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadPaymentDraftList(vo);
	}

}
