package ui.salesmanUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import bl.salebl.SaleBLFactory;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockReturnListCellController extends StockListCellController implements CellController {

	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public StockReturnListCellController(ListViewController stockReturnListViewController, SalesmanListVO vo) {
		super(stockReturnListViewController, vo);

	}

	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}
	
	@Override
	StockTypeEditListController generateEditList() {
		StockTypeEditListController controller = 
   				    new StockReturnEditListController(this.controller.controller,SaleBLFactory.getStockListBLService(),vo.getId(),vo);
		return controller;
	}
}
