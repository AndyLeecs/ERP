package ui.accountUI;

import javafx.fxml.FXML;

public class CollectionListBriefDraftController extends CollectionAndPaymentListBriefDraftController{


	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadCollectionDraftList(vo);
	}

}
