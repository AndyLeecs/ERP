package ui.accountUI;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ParentController;
import ui.commonUI.SonController;
import javafx.scene.control.Label;

public class CollectionListWinController implements SonController{
	
	ParentController parentController;
	
	@FXML
	AnchorPane root;
	
	@FXML Label listID;
	@FXML Label operator;
	
	@FXML
	public void initialize(){
		
	}

	public void setParentController(ParentController controller){
		parentController = controller;
	};
	
	public void setListID(String id){
		listID.setText(id);
	}
	
	public void setOperator(String name){
		operator.setText(name);
	}
}
