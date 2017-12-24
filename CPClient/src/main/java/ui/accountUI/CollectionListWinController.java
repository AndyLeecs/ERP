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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import util.CommitListRM;
import util.SaveListRM;

public class CollectionListWinController extends FinanceListWinController{
	
	
	@FXML
	AnchorPane root;
	
	@FXML TableView<TransferItem> TransferListTableView;
	@FXML TableColumn<TransferItem,String> account;
	@FXML TableColumn<TransferItem,Double> amount;
	@FXML TableColumn<TransferItem,String> note;
	@FXML TableColumn<TransferItem,Boolean> deleted;

	@FXML ComboBox<String> AccountComboBox;

	@FXML Label totalAmount;

	
	private final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();
	private List<String> accountList = new ArrayList<String>();

	@FXML Label VIPName;

	@FXML Label VIPID;
	
	

	//不用fxml注入的initialize方法，因为那个会在加载fxml时就调用
	public void init(){
		
		initComboBox();
		initTableView();

	}

	
	@FXML 
	public void OnAccountSelected() {
		String newAccount = AccountComboBox.getValue();
		Iterator<TransferItem> iterator = transferItem.iterator();
		while(iterator.hasNext()){
			TransferItem item = iterator.next();
			if(item.getAccount().equals(newAccount))	//此账户已经选择过了
				return;
		}
		transferItem.add(new TransferItem(newAccount,0,"",false));
	}
	
	
	private void initTableView(){
		account.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("account"));
//		account.setCellFactory(TextFieldTableCell.forTableColumn());	//account不可在TableView中修改
		
		amount.setCellValueFactory(new PropertyValueFactory<TransferItem, Double>("amount"));
		//TODO 这个不能用。double没有默认的回调函数，暂时不知道怎么搞		//实在不行就把类型改为String
//		amount.setCellFactory(
//				new Callback<TableColumn<TransferItem, Double>, TableCell<TransferItem, Double>>() {
//	                 public TableCell<TransferItem, Double> call(TableColumn<TransferItem, Double> p) {
//	                    return new TableCell<TransferItem, Double>();		
//	                 }
//	             });
//		amount.setEditable(true);
		amount.setOnEditCommit(
			    new EventHandler<CellEditEvent<TransferItem, Double>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, Double> t) {
			            ((TransferItem) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setAmount(t.getNewValue());
			        }
			    }
			);
		
		note.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("note"));
		note.setCellFactory(TextFieldTableCell.forTableColumn());
		note.setOnEditCommit(
		    new EventHandler<CellEditEvent<TransferItem, String>>() {
		        @Override
		        public void handle(CellEditEvent<TransferItem, String> t) {
		            ((TransferItem) t.getTableView().getItems().get(
		                t.getTablePosition().getRow())
		                ).setNote(t.getNewValue());
		        }
		    }
		);
		
		//TODO 想实现点一下能删除，不知道怎么做
		deleted.setCellValueFactory(new PropertyValueFactory<TransferItem, Boolean>("deleted"));
		deleted.setCellFactory(CheckBoxTableCell.forTableColumn(deleted));
		deleted.setOnEditStart(
			    new EventHandler<CellEditEvent<TransferItem, Boolean>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, Boolean> t) {
			        	System.out.println("in");		//没有效果
			            transferItem.remove((TransferItem) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                );
			            System.out.println("remove");
			        }
			    }
			);
		
		TransferListTableView.setItems(transferItem);
		
	    TransferListTableView.setEditable(true);
		
	    transferItem.add(new TransferItem("1 ", 100,"dv",false));
	    transferItem.add(new TransferItem("老张", 100,"dv",false));
	    transferItem.add(new TransferItem("我 ", 100,"dv",false));


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
		
		CollectionListVO vo = createCollectionListVO();
		
		SaveListRM saverm = financeListService.saveCollectionList(vo);
		switch(saverm){
		case SUCCESS:
			//TODO 显示保存成功的提示窗
			break;
		}
	}


	@FXML 
	public void onCommitBtnClicked() {
		System.out.println(transferItem.get(1).getNote());
		System.out.println(transferItem.get(1).getAmount());

		CollectionListVO vo = createCollectionListVO();
		CommitListRM commitrm = financeListService.commitCollectionList(vo);
		switch(commitrm){
		case SUCCESS:
			//TODO 显示提交成功的界面
			break;
		}
		
	}
	
	//创建当前界面对应的VO
	private CollectionListVO createCollectionListVO(){
		return new CollectionListVO(
				listID.getText(),
				VIPID.getText(),
				VIPName.getText(),
				operator.getText(),
				transferItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		//装一下B，虽然没人看的到
				Double.parseDouble(totalAmount.getText())
				);
	}

}


