package ui.mainUI.accountantUI;

import java.io.IOException;

import blservice.accountblservice.FinanceListService;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.accountUI.CashExpenseListWinController;
import ui.accountUI.CollectionListWinController;
import ui.accountUI.FinanceListWinController;
import ui.accountUI.OpenCollectionCommitedListController;
import ui.accountUI.OpenFinanceListController;
import ui.accountUI.PaymentListWinController;
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
	
	FinanceListService financeListService = AccountBLFactory.getFinanceListService();
	
	private static final String FORM_CSS_PATH = "/css/forms/Forms.css";
	
	

	@FXML public void onNewCollectionListBtnClicked() {
		String id = financeListService.newCollectionList();
		loadNewList(id,new CollectionListWinController(),"/fxml/accountUI/CollectionList.fxml",FORM_CSS_PATH);
	}




	@FXML public void onNewPaymentListBtnClicked() {
		String id = financeListService.newPaymentList();
		loadNewList(id,new PaymentListWinController(),"/fxml/accountUI/PaymentList.fxml",FORM_CSS_PATH);
	}



	@FXML public void onNewCashExpenseListBtnClicked() {
		String id = financeListService.newCashExpenseList();
		loadNewList(id,new CashExpenseListWinController(),"/fxml/accountUI/CashExpenseList.fxml",FORM_CSS_PATH);
	}




	@FXML public void onOpenCollectionCommittedBtnClicked() {
		//TODO
		String fxmlPath = "/fxml/commonUI/OpenListOfForms.fxml";
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/commonUI/OpenListOfForms.fxml"));
			OpenFinanceListController openfinanceListController = new OpenCollectionCommitedListController(); 
			loader.setController(openfinanceListController);
			loader.load();

			openfinanceListController.setParentController(this);
			openfinanceListController.setService(financeListService);
			openfinanceListController.init();
			
			AnchorPane ListRoot = loader.getRoot();
			
			centerPane.getChildren().removeAll();
			centerPane.getChildren().add(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
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
		financeListService = AccountBLFactory.getFinanceListService(); 	//刷新一下service
	}
	
	
	
	private void loadNewList(String id,FinanceListWinController ListWinController, String fxmlPath,String cssPath){
		if(id == null){
			//TODO 提示单据已满的界面
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(ListWinController);
			loader.load();
			
			ListWinController.setParentController(this);
			ListWinController.setListID(id);
			ListWinController.setOperator(User.getInstance().getUserName());
			ListWinController.setService(financeListService);
			ListWinController.init();

			AnchorPane ListRoot;
			ListRoot = loader.getRoot();
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			centerPane.getChildren().removeAll();
			centerPane.getChildren().add(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
