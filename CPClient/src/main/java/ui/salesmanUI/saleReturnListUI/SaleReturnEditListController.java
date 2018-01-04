package ui.salesmanUI.saleReturnListUI;

import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.sale.SaleTypeEditListController;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description
*/
public class SaleReturnEditListController extends SaleTypeEditListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public SaleReturnEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI(){
		return new SaleReturnListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(), null, "默认仓库", notesTextField.getText(), chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText())); 
	}


	/* (non-Javadoc)
	 * @see ui.salesmanUI.sale.SaleTypeListController#findPresent()
	 */
	@Override
	@FXML
	protected void findPresent() {
		
	}

}
