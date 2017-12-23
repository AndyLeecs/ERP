package ui.mainUI.accountantUI;

import java.io.IOException;

import blservice.accountblservice.FinanceListService;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.commonUI.ListWinController;
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
	
	
	private static final String FORM_CSS_PATH = "/css/forms/Forms.css";
	
	FinanceListService financeListService = AccountBLFactory.getFinanceListService();
	

	@FXML public void onNewCollectionListBtnClicked() {
		String id = financeListService.newCollectionList();
		loadNewList(id,"/fxml/accountUI/CollectionList.fxml",FORM_CSS_PATH);
	}




	@FXML public void onNewPaymentListBtnClicked() {
		String id = financeListService.newPaymentList();
		loadNewList(id,"/fxml/accountUI/PaymentList.fxml",FORM_CSS_PATH);
	}



	@FXML public void onNewCashExpenseListBtnClicked() {
		String id = financeListService.newCashExpenseList();
		loadNewList(id,"/fxml/accountUI/CashExpenseList.fxml",FORM_CSS_PATH);
	}




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
	
	
	
	private void loadNewList(String id, String fxmlPath,String cssPath){
		if(id == null){
			//TODO 提示单据已满的界面
			return;
		}
		
		AnchorPane ListRoot;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
			ListRoot = loader.load();
			ListWinController ListWinController = loader.getController();
			ListWinController.setParentController(this);
			ListWinController.setListID(id);
			ListWinController.setOperator(User.getInstance().getUserName());
			
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			
			centerPane.getChildren().removeAll();
			centerPane.getChildren().add(ListRoot);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
