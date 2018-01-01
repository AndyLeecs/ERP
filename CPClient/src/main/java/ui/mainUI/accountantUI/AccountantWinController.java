package ui.mainUI.accountantUI;

import java.io.IOException;

import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
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
import ui.accountUI.OpenCashExpenseCommitedListController;
import ui.accountUI.OpenCashExpenseDraftListController;
import ui.accountUI.OpenCollectionCommitedListController;
import ui.accountUI.OpenCollectionDraftListController;
import ui.accountUI.OpenFinanceListController;
import ui.accountUI.PaymentListWinController;
import ui.commonUI.ParentController;
import ui.commonUI.PromptWin;
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
	
	
	private static final String OPEN_LIST_OF_FORM_FXML =  "/fxml/commonUI/OpenListOfForms.fxml";
	private static final String COLLECTION_LIST_FXML = "/fxml/accountUI/CollectionList.fxml";
	private static final String PAYMENT_LIST_FXML = "/fxml/accountUI/PaymentList.fxml";
	private static final String CASH_EXPENSE_LIST_FXML = "/fxml/accountUI/CashExpenseList.fxml";
	

	@FXML public void onNewCollectionListBtnClicked() {
		loadNewList(AccountBLFactory.getCollectionListService(),new CollectionListWinController(),COLLECTION_LIST_FXML);
	}




	@FXML public void onNewPaymentListBtnClicked() {
		loadNewList(AccountBLFactory.getPaymentListService(),new PaymentListWinController(),PAYMENT_LIST_FXML);
	}



	@FXML public void onNewCashExpenseListBtnClicked() {
		loadNewList(AccountBLFactory.getCashExpenseListService(),new CashExpenseListWinController(),CASH_EXPENSE_LIST_FXML);
	}




	@FXML public void onOpenCollectionCommittedBtnClicked() {
		loadOpenList(AccountBLFactory.getCollectionListService(),new OpenCollectionCommitedListController());
		
	}




	@FXML public void onOpenPaymentCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseCommittedBtnClicked() {
		loadOpenList(AccountBLFactory.getCashExpenseListService(),new OpenCashExpenseCommitedListController());
	}




	@FXML public void onOpenCollectionDraftBtnClicked() {
		loadOpenList(AccountBLFactory.getCollectionListService(), new OpenCollectionDraftListController(this));
	}




	@FXML public void onOpenPaymentDraftBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseDraftBtnClicked() {
		loadOpenList(AccountBLFactory.getCashExpenseListService(), new OpenCashExpenseDraftListController(this));
	}




	@Override
	public void CloseSonWin() {
		centerPane.setCenter(null);
		centerPane.getChildren().removeAll();		
	}
	
	
	
	private void loadNewList(FinanceListService financeListService,FinanceListWinController financeListWinController, String fxmlPath){
		String id = financeListService.newList();
		if(id == null){
			try {
				new PromptWin("网络异常，请稍后再试！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		if(id == global.ListGlobalVariables.LIST_FULL){
			try {
				new PromptWin("今日该类单据已满，请明天再来～");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(financeListWinController);
			loader.load();
			
			financeListWinController.setParentController(this);
			financeListWinController.setService(financeListService);
			financeListWinController.setListID(id);
			financeListWinController.setOperator(User.getInstance().getUserName());
			financeListWinController.init();

			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void loadOpenList(FinanceListService financeListService,OpenFinanceListController openfinanceListController){
		try {		//此处和下面的loadEditableList方法纯属雷同，无任何设计不合理之处
			FXMLLoader loader = new FXMLLoader(getClass().getResource(OPEN_LIST_OF_FORM_FXML));
			
			loader.setController(openfinanceListController);
			loader.load();

			openfinanceListController.setParentController(this);
			openfinanceListController.setService(financeListService);
			openfinanceListController.init();
			
			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadCollectionDraftList(CollectionListVO vo){
		FinanceListWinController financeListWinController = new CollectionListWinController(vo);
		String fxmlPath = COLLECTION_LIST_FXML;
		FinanceListService financeListService= AccountBLFactory.getCollectionListService();
		
		loadEditableList(financeListWinController,financeListService,fxmlPath);
		
	}
	
	public void loadCashExpenseDraftList(CashExpenseListVO vo){
		FinanceListWinController financeListWinController = new CashExpenseListWinController(vo);
		String fxmlPath = CASH_EXPENSE_LIST_FXML;
		FinanceListService financeListService= AccountBLFactory.getCashExpenseListService();
		loadEditableList(financeListWinController,financeListService,fxmlPath);
		
	}
	
	private void loadEditableList(FinanceListWinController financeListWinController, FinanceListService financeListService, String fxmlPath){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(financeListWinController);
			loader.load();
			
			financeListWinController.setParentController(this);
			financeListWinController.setService(financeListService);
			financeListWinController.init();

			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
