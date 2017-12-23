package ui.accountUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ListWinController;

public class CollectionListWinController extends ListWinController{
	
	
	@FXML
	AnchorPane root;
	
	@FXML TableView<TransferItem> TransferListTableView;
	
	private final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();


	@FXML TableColumn<TransferItem,String> account;

	@FXML TableColumn<TransferItem,Double> amount;

	@FXML TableColumn<TransferItem,String> note;

	@FXML 
	public void initialize(){
		account.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("account"));
		amount.setCellValueFactory(new PropertyValueFactory<TransferItem, Double>("amount"));
		note.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("note"));
		TransferListTableView.setItems(transferItem);

	}
	
}


