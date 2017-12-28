package ui.accountUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import VO.accountVO.AccountVO;
import VO.accountVO.CollectionListVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import util.CommitListRM;
import util.SaveListRM;
import util.State;

public class CollectionListWinController extends FinanceListWinController{
	
	
	@FXML
	AnchorPane root;
	
	@FXML TableView<TransferItem> TransferListTableView;
	@FXML TableColumn<TransferItem,String> account;
	@FXML TableColumn<TransferItem,String> amount;
	@FXML TableColumn<TransferItem,String> note;
	@FXML TableColumn<TransferItem,String> deleted;

	@FXML ComboBox<String> AccountComboBox;

	@FXML Label accountLabel;
	@FXML Label totalAmount;
	@FXML Button selectVIPBtn;
	@FXML Button saveBtn;
	@FXML Button commitBtn;

	
	final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();
	List<String> accountList = new ArrayList<String>();

	@FXML Label VIPName;

	@FXML Label VIPID;
	
	

	public void init(){
		
		initComboBox();
		initTableView();

	}

	
	@FXML 
	public void OnAccountSelected() {
		String newAccount = AccountComboBox.getValue();
		if(newAccount == null || newAccount.equals("")) return;
		Iterator<TransferItem> iterator = transferItem.iterator();
		while(iterator.hasNext()){
			TransferItem item = iterator.next();
			if(item.getAccount().equals(newAccount))	//此账户已经选择过了
				return;
		}
		transferItem.add(new TransferItem(newAccount,0,""));
		System.out.println("in");
	}
	
	
	private void initTableView(){
		
		initAccountTableColumn();
		initAmountTableColumn();
		initNoteTableColumn();
		initDeleteTableColumn();
		
		TransferListTableView.setItems(transferItem);
	    TransferListTableView.setEditable(true);
		
	    //TODO 测试用，以后删掉
//	    transferItem.add(new TransferItem("1 ", 100,"dv"));
//	    transferItem.add(new TransferItem("老张", 100,"dv"));
//	    transferItem.add(new TransferItem("我 ", 100,"dv"));


	}
	
	private void initAccountTableColumn(){
		//account不可在TableView中修改
		account.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("account"));
	}
	
	private void initAmountTableColumn(){
		amount.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("amount"));
		amount.setCellFactory(TextFieldTableCell.forTableColumn());
		amount.setOnEditCommit(
			    new EventHandler<CellEditEvent<TransferItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, String> t) {
			        	TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
				        item.setAmount(t.getNewValue());	
			            double total = transferItem.stream()
			            						   .map(e -> Double.parseDouble(e.getAmount()))
			            						   .reduce(0.0, (a,b)->a+b);			//真的爽(其实从效率上讲不见得比用iterator好)
			            totalAmount.setText(String.valueOf(total));
			        }
			    }
			);
	}
	
	private void initNoteTableColumn(){
		note.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("note"));
		note.setCellFactory(TextFieldTableCell.forTableColumn());
		note.setOnEditCommit(
		    new EventHandler<CellEditEvent<TransferItem, String>>() {
		        @Override
		        public void handle(CellEditEvent<TransferItem, String> t) {
		            TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
		            item.setNote(t.getNewValue());	
		        }
		    }
		);
	}
	
	private void initDeleteTableColumn(){
		deleted.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("deleted"));
		deleted.setCellFactory(TextFieldTableCell.forTableColumn());
		deleted.setOnEditStart(
			    new EventHandler<CellEditEvent<TransferItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, String> t) {
			        	TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
				        double total = Double.parseDouble(totalAmount.getText()) - Double.parseDouble(item.getAmount());
				        totalAmount.setText(String.valueOf(total));
			            transferItem.remove(item);
			        }
			    }
			);
	}
	
	private void initComboBox(){
		List<AccountVO> accountvo = financeListService.findAccount();
		for(AccountVO vo :accountvo){
			accountList.add(vo.getAccountName());
		}
		AccountComboBox.getItems().addAll(accountList);
		
	}


	@FXML 
	public void onSaveBtnClicked() {
		
		CollectionListVO vo = createCollectionListVO(State.IsDraft);
		
		SaveListRM saverm = financeListService.saveCollectionList(vo);
		switch(saverm){
		case SUCCESS:
			//TODO 显示保存成功的提示窗
			break;
		}
	}


	@FXML 
	public void onCommitBtnClicked() {
		if(transferItem.isEmpty()){
			//TODO 提示转账列表不能为空
		}
		CollectionListVO vo = createCollectionListVO(State.IsCommitted);
		CommitListRM commitrm = financeListService.commitCollectionList(vo);
		switch(commitrm){
		case SUCCESS:
			//TODO 显示提交成功的界面
			break;
		}
		
	}
	
	//创建当前界面对应的VO
	private CollectionListVO createCollectionListVO(State state){
		return new CollectionListVO(
				listID.getText(),
				VIPID.getText(),
				VIPName.getText(),
				operator.getText(),
				transferItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		//请不要乱写注释
				Double.parseDouble(totalAmount.getText()),
				state
				);
	}

}


