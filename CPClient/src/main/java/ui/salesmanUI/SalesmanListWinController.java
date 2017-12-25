package ui.salesmanUI;

import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据接口的抽象父类
*/
public abstract class SalesmanListWinController {
	ParentController parentController;
	SaleUniBLService uniBLService;
	String id;
	
	@FXML Label listID;
	@FXML Label operator;
	
	
	public SalesmanListWinController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super();
		this.parentController = parentController;
		this.uniBLService = uniBLService;
		this.id = id;
	}
		
//	public void setParentController(ParentController controller){
//		parentController = controller;
//	};
//	
//	public void setListID(String id){
//		listID.setText(id);
//	}
//	
//	public void setOperator(String name){
//		operator.setText(name);
//	}
}
