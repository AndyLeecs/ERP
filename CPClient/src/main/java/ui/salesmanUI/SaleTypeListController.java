package ui.salesmanUI;

import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class SaleTypeListController extends SalesmanListWinController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}

}
