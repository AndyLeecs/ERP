package ui.salesmanUI;

import VO.GoodsInSaleVO;
import VO.goodsVO.GoodsVO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public class GoodsSearchResultCellForSalesmanController {

GoodsVO vo;

	@FXML public Label id;
	@FXML public Label name;
	@FXML public CheckBox checkBox;
	
	
	@FXML
	void initialize(){
		id.setText(vo.getGoodsID()+"");
		name.setText(vo.getGoodsName());
	}
	/**
	 * @param vo
	 */
	public GoodsSearchResultCellForSalesmanController(GoodsVO vo) {
		// TODO Auto-generated constructor stub
		this.vo = vo;
	}

}
