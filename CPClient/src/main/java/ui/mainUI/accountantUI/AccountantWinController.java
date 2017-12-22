package ui.mainUI.accountantUI;

import java.io.IOException;

import bl.accountbl.AccountBLService_Stub;
import blservice.accountblservice.FinanceListService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.accountUI.CollectionListWinController;
import ui.commonUI.ParentController;
import ui.mainUI.loginUI.User;

public class AccountantWinController implements ParentController{
	
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
	
	FinanceListService financeListService = new AccountBLService_Stub();
	

	@FXML public void onNewCollectionListBtnClicked() {
		
		String id = financeListService.newCollectionList();
		if(id == null){
			//TODO 提示单据已满的界面
			return;
		}
		
		AnchorPane collectionListRoot;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CollectionList.fxml"));
			collectionListRoot = loader.load();
			CollectionListWinController collectionListWinController = loader.getController();
			collectionListWinController.setParentController(this);
			collectionListWinController.setListID(id);
			collectionListWinController.setOperator(User.getInstance().getUserName());
			
			
			collectionListRoot.getStylesheets().add(getClass().getResource("/css/forms/Forms.css").toExternalForm());
			
			centerPane.getChildren().removeAll();
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




	@Override
	public void CloseSonWin() {
		centerPane.getChildren().removeAll();		
	}
	
	//不好用
//	private void loadFXML(String fxmlPath){
//		loadFXML(fxmlPath,null);
//	}
	
//	private void loadFXML(String fxmlPath,String cssPath){
//		
//	}
}
