package ui.salesmanUI;

import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public class StockTypeApproveListController extends StockTypeListController {

	@FXML protected Button approveBtn;
	@FXML protected Button rejectBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockTypeApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}

	@FXML
	void approve(){
		
	}
	
	@FXML
	void reject(){
		
	}
	
	@FXML
	void cancel(){
		
	}
}
