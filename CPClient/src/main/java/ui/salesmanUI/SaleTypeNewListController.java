package ui.salesmanUI;

import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleTypeNewListController extends SaleTypeListController {

	

	
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id 
	 */
	public SaleTypeNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService,id);
		// TODO Auto-generated constructor stub
	}

	@FXML
	void commit(){
		
	}
	
	@FXML
	void save(){
		
	}
	
	@FXML
	void cancel(){
		
	}
}
