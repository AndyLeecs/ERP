package ui.salesmanUI.sale;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class SaleTypeEditListController extends SaleTypeListController {

	
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	
	protected SalesmanListVO vo;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,SalesmanListVO vo) {
		super(parentController, uniBLService, id);
		this.vo = vo;
	}
	@FXML
	protected
	void initialize(){
		super.initialize();
		System.out.println(vo);
		if(vo.getOperator()!=null)
		operator.setText(vo.getOperator());
		operatorId = vo.getOperatorId();
		operatorGrade = vo.getOperatorGrade();
		
		totalAmount.setText(vo.getSum()+"");
		VIPID.setText(vo.getMemberID());
		VIPName.setText(vo.getMemberName());
		notesTextField.setText(vo.getNotes());
		clerk.setText(vo.getRealOperator());
		
		chosenList = vo.getSaleListItems();
		//改变组件的名称
//		saveBtn.setText("保存");
//		cancelBtn.setText("删除");
		this.refresh();
	}
	@FXML
	protected
	void cancel(){
		if(parentController != null)
		this.parentController.CloseSonWin();
	}
}