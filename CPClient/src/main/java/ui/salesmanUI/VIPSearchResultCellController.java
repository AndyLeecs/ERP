package ui.salesmanUI;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class VIPSearchResultCellController {
	VIPVO vo;

	@FXML public Label id;
	@FXML public Label name;
	@FXML public Label grade;
	@FXML public CheckBox checkBox;
	
	
	@FXML
	void initialize(){
		id.setText(vo.getId()+"");
		name.setText(vo.getName()+"");
		grade.setText(vo.getGrade()+"");
	}
	/**
	 * @param vo
	 */
	public VIPSearchResultCellController(VIPVO vo) {
		// TODO Auto-generated constructor stub
		this.vo = vo;
	}

}
