package ui.salesmanUI;

import VO.goodsVO.GoodsVO;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public abstract class SalesmanEditCellController {
	@FXML protected Label typeLabel;
	@FXML protected Label sumLabel;
	protected DoubleProperty sumProperty  = new SimpleDoubleProperty();

	@FXML protected TextField priceTextField;
	protected DoubleProperty priceProperty  = new SimpleDoubleProperty();

	@FXML protected TextField notesTextField;
	protected StringProperty notesProperty = new SimpleStringProperty(); 

	@FXML protected Label nameLabel;
	@FXML protected Label idLabel;
	@FXML protected Button deleteBtn;
	@FXML protected TextField amountTextField;
	protected IntegerProperty amountProperty  = new SimpleIntegerProperty();
	
	protected final String INIT_AMOUNT = "1";
	
	protected GoodsVO vo;
	
	protected SalesmanListWinController controller;
	/**
	 * @param salesmanListWinController
	 * @param vo
	 */
	public SalesmanEditCellController(SalesmanListWinController salesmanListWinController, GoodsVO vo) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.vo = vo;
	}
	
	@FXML void initialize(){
		//绑定属性
		notesTextField.textProperty().bind(notesProperty);
		
		amountTextField.textProperty().bind(amountProperty.asString());
		
		priceTextField.textProperty().bind(priceProperty.asString());
		 sumLabel.textProperty().bind(new StringBinding() {

	            {
	                bind(amountProperty.asString(), priceProperty.asString());
	            }

	            @Override
	            protected String computeValue() {
	                return amountProperty.getValue()*priceProperty.getValue()+"";
	            }
	        });	
		 
		typeLabel.setText(vo.getGoodsType());
		sumLabel.setText("");
		//在子类里写price的处理
		amountTextField.setText(INIT_AMOUNT);
		notesTextField.setText("");
		nameLabel.setText(vo.getGoodsName());
		idLabel.setText(vo.getGoodsID());
		

	}
	
	@FXML void delete(){
		//每次删除的时候删除vo,因为并没有保存vo中amount域的更改
		controller.deleteFromchosenList(vo);
	}

}
