package ui.mainUI.accountantUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AccountantWinController {
	
	@FXML AnchorPane root;

	
	@FXML MenuItem newCollectionList;
	@FXML MenuItem newPaymentList;
	@FXML MenuItem newCashExpenseList;
	@FXML MenuItem openCollectionCommitted;
	@FXML MenuItem openPaymentCommitted;
	@FXML MenuItem openCashExpenseCommitted;
	@FXML MenuItem openCollectionDraft;
	@FXML MenuItem openPaymentDraft;
	@FXML MenuItem openCashExpenseDraft;
	
	@FXML BorderPane centerPane;
	
	
	

	@FXML public void onNewCollectionListBtnClicked() {
		//TODO
		AnchorPane collectionListRoot;
		try {
			collectionListRoot = FXMLLoader.load(getClass().getResource("/fxml/accountUI/CollectionList.fxml"));
			collectionListRoot.getStylesheets().add(getClass().getResource("/css/forms/Forms.css").toExternalForm());
			centerPane.getChildren().add(collectionListRoot);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	@FXML public void onNewPaymentListBtnClicked() {
		//TODO
	}




	@FXML public void onNewCashExpenseListBtnClicked() {}




	@FXML public void onOpenCollectionCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenPaymentCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCollectionDraftBtnClicked() {
		//TODO
	}




	@FXML public void onOpenPaymentDraftBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseDraftBtnClicked() {
		//TODO
	}
}
