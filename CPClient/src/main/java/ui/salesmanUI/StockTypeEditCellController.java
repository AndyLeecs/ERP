package ui.salesmanUI;

import VO.goodsVO.GoodsVO;
import javafx.fxml.FXML;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class StockTypeEditCellController extends SalesmanEditCellController {

	/**
	 * @param salesmanListWinController
	 * @param vo
	 */
	public StockTypeEditCellController(SalesmanListWinController salesmanListWinController, GoodsVO vo) {
		super(salesmanListWinController, vo);
		// TODO Auto-generated constructor stub
	}
	
	@FXML void initialize(){
		super.initialize();
		priceTextField.setText(vo.getGoodsBuyPrice()+"");
	}

}
