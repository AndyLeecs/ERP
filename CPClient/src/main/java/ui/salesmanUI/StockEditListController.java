package ui.salesmanUI;

import java.util.List;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import bl.salebl.SaleBLFactory;
import blservice.saleblservice.SaleUniBLService;
import blservice.saleblservice.StockListBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockEditListController extends StockTypeEditListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public StockEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		// TODO Auto-generated method stub
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

	@FXML
	void cancel(){

		this.parentController.CloseSonWin();
	}

}
