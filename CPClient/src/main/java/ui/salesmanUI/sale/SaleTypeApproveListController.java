package ui.salesmanUI.sale;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import resultmessage.DataRM;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class SaleTypeApproveListController extends SaleTypeEditListController {


	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,SalesmanListVO vo) {
		super(parentController, uniBLService, id,vo);
		vo = uniBLService.get(id);
	}

	@Override
	@FXML
	protected
	void initialize(){
		super.initialize();
		commitBtn.setText("过审");
		saveBtn.setText("驳回");
	}
	//审批
	@Override
	@FXML
	protected
	void commit(){
		if(!check())
			return;
		DataRM rm = uniBLService.approve(getVOFromUI());
		showPrompt(rm);
	}
	
	//审批不通过
	@Override
	@FXML
	protected
	void save(){
		DataRM rm = uniBLService.reject(getVOFromUI());
		showPrompt(rm);
	}

}
