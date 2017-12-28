package ui.salesmanUI;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockReturnNewListController extends StockTypeNewListController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockReturnNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		// TODO Auto-generated method stub
		return null;
	}



}
