package ui.salesmanUI;

import java.util.List;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockTypeListViewController extends ListViewController{

	/**
	 * @param controller
	 * @param service
	 * @param list
	 */
	public StockTypeListViewController(ParentController controller, SaleUniBLService service,
			List<SalesmanListVO> list) {
		super(controller, service, list);
		// TODO Auto-generated constructor stub
	}

}
