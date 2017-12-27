
package ui.salesmanUI;

import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockTypeNewListController extends SalesmanListWinController {
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id 
	 */
	public StockTypeNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
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
