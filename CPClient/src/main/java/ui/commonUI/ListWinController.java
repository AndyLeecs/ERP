package ui.commonUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListWinController implements SonController{
	ParentController parentController;
	

	@FXML protected Label listID;
	@FXML protected Label operator;
	

	public void setParentController(ParentController controller){
		parentController = controller;
	};
	
	public void setListID(String id){
		listID.setText(id);
	}
	
	public void setOperator(String name){
		operator.setText(name);
	}
	
	public void init(){}
}
