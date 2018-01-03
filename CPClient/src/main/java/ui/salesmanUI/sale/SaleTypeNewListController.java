package ui.salesmanUI.sale;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.mainUI.loginUI.User;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public abstract class SaleTypeNewListController extends SaleTypeListController {

	

	
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
	}
	@FXML
	protected
	void initialize(){
		super.initialize();

		operator.setText(User.getInstance().getUserName());
		operatorId = User.getInstance().getId();
		operatorGrade = User.getInstance().getGrade();
		System.out.println("sale type newlist controller initialized" );
	}

	
	@FXML
	protected void cancel(){
		DataRM rm = uniBLService.delete(id);
		System.out.println("cancel");
		showPrompt(rm);
		this.parentController.CloseSonWin();
		
	}


}
