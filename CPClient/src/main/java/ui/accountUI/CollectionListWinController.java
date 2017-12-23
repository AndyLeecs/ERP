package ui.accountUI;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ui.commonUI.ListWinController;

public class CollectionListWinController extends ListWinController{
	
	
	@FXML
	AnchorPane root;
	
	@FXML TableView<TransferItem> TransferListTableView;
	
	private final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();


	@FXML TableColumn<TransferItem,String> account;

	@FXML TableColumn<TransferItem,Double> amount;

	@FXML TableColumn<TransferItem,String> note;
	
	@FXML TableColumn<TransferItem,Boolean> deleted;

	@FXML 
	public void initialize(){
		
		account.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("account"));
		account.setCellFactory(TextFieldTableCell.forTableColumn());
		
		amount.setCellValueFactory(new PropertyValueFactory<TransferItem, Double>("amount"));
		//这个不能用。double没有默认的回调函数，暂时不知道怎么搞
//		amount.setCellFactory(
//				new Callback<TableColumn<TransferItem, Double>, TableCell<TransferItem, Double>>() {
//	                 public TableCell<TransferItem, Double> call(TableColumn<TransferItem, Double> p) {
//	                    return new TableCell<TransferItem, Double>();		
//	                 }
//	             });
		
		note.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("note"));
		note.setCellFactory(TextFieldTableCell.forTableColumn());
		
		deleted.setCellValueFactory(new PropertyValueFactory<TransferItem, Boolean>("deleted"));
		deleted.setCellFactory(CheckBoxTableCell.forTableColumn(deleted));
		
		TransferListTableView.setItems(transferItem);
		
	             
	             
	    TransferListTableView.setEditable(true);
		
		transferItem.add(new TransferItem("boss",1000,"very good", false));
		transferItem.add(new TransferItem("boss32",10201,"no", false));
		transferItem.add(new TransferItem("boss9",189000,"very good", true));
		
	}
	
	public static class TransferItem{
		private final SimpleStringProperty account;
		private final SimpleDoubleProperty amount;
		private final SimpleStringProperty note;
		private final SimpleBooleanProperty deleted;
		
		private TransferItem(String account, double amount, String note, boolean deleted){
			this.account = new SimpleStringProperty(account);
			this.amount = new SimpleDoubleProperty(amount);
			this.note = new SimpleStringProperty(note);
			this.deleted = new SimpleBooleanProperty(deleted);
		}

		public String getAccount() {
			return account.get();
		}
		
		public void setAccount(String account){
			this.account.set(account);
		}
		
		public double getAmount(){
			return amount.get();
		}
		
		public void setAmount(double amount){
			this.amount.set(amount);
		}
		
		public String getNote(){
			return note.get();
		}
		
		public void setNote(String note){
			this.note.set(note);
		}
		
		public Boolean getDeleted(){
			return deleted.get();
		}
		
		public void setDeleted(boolean deleted){
			this.deleted.set(deleted);
		}
		
	}

}


