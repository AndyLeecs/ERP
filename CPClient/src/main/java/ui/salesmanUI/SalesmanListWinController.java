package ui.salesmanUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;


import VO.goodsVO.GoodsVO;
import bl.goodsbl.GoodsFuzzySearch;
import bl.utility.GoodsTransGoodsInSale;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ui.commonUI.GoodsSearchResultWin;
import ui.commonUI.ParentController;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据接口的抽象父类
*/
public abstract class SalesmanListWinController{
	protected ParentController parentController;
	
	protected SaleUniBLService uniBLService;
	protected GoodsFuzzySearch fuzzySearch;
	
	protected String id;
	/**
	 * 待选择的商品列表,不需要作为属性
	 */
//	protected List<GoodsVO> forChooseList;
	/**
	 * 已选择的商品列表
	 */
	protected List<GoodsVO> chosenList;
	
	@FXML protected AnchorPane root;
	
	@FXML protected Label listID;
	@FXML protected Label operator;
	
	@FXML protected Label totalAmount;
//暂时不需要绑定什么属性
//	protected DoubleProperty totalAmountProperty  = new SimpleDoubleProperty();
//	protected StringProperty totalAmountStringProperty = new SimpleStringProperty();
	
	@FXML protected Label VIPID;
	@FXML protected Label VIPName;
	
	@FXML protected TextField notesTextField;
//	protected StringProperty notesProperty = new SimpleStringProperty(); 
	
	@FXML protected Button selectVIPBtn;
	@FXML protected TextField selectVIPField;
	
	@FXML protected Button selectGoodsBtn;
	@FXML protected TextField selectGoodsField;
	
	@FXML protected VBox goodsListVBox;
	
	@FXML protected Label nullErrorMessage;
	protected static final String nullError = "请填写所有字段";
//	protected StringProperty nullErrorProperty = new SimpleStringProperty();
	@FXML protected Label numberErrorMessage;
	protected static final String numberError = "数字格式错误";
	
	
	public SalesmanListWinController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super();
		this.parentController = parentController;
		this.uniBLService = uniBLService;
		this.id = id;
	}
	
	/**
	 * 显示单据id
	 */
	@FXML 
	void initialize(){
		listID.setText(id);
//只在第一次操作单据的时候做这项操作
//		operator.setText(User.getInstance().getUserName());
//暂时不需要绑定属性
//		notesTextField.textProperty().bind(notesProperty);
//		totalAmount.textProperty().bind(totalAmountStringProperty);
//		StringConverter<Number> converter = new NumberStringConverter();
//		Bindings.bindBidirectional(totalAmountStringProperty, totalAmountProperty, converter);
	}
	
	/**
	 * 查找商品
	 */
	@FXML
	void selectGoods(){
		//获得关键字
		String message = selectGoodsField.getText();
		System.out.println("search message is "+ message);
		if(message != null && message.length() != 0){
		//查找，分别用三种模糊查找，然后合并得到的商品列表结果
		List<GoodsVO> temp = new ArrayList<GoodsVO>();
		temp.addAll(fuzzySearch.getGoodsInID(message));
		temp.addAll(fuzzySearch.getGoodsInGoodsName(message));
		temp.addAll(fuzzySearch.getGoodsInCategory(message));
		
		//去重
		temp = new ArrayList<GoodsVO>(new LinkedHashSet<>(temp));
		
		try {
			new GoodsSearchResultForSalesmanWin(temp,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	}
	
	/**
	 * 查找会员
	 */
	@FXML
	void selectVIP(){
		
	}
	
	/**
	 * 添加到商品清单
	 */
	protected void addToList(GoodsVO vo){
		this.chosenList.add(vo);
		//去重
		this.chosenList = new ArrayList<GoodsVO>(new LinkedHashSet<GoodsVO>(this.chosenList));
		this.refresh();
	}
	/**
	 * 从商品清单中删除
	 */
	protected void deleteFromchosenList(GoodsVO vo){
		this.chosenList.remove(vo);
		this.refresh();
	}
	
	public List<GoodsVO> getchosenList() {
		return chosenList;
	}
//
	
	public void setchosenList(List<GoodsVO> chosenList) {
		this.chosenList = chosenList;
		this.refresh();
	}
	
	/**
	 * 返回父界面
	 */
	public void back(){
		parentController.CloseSonWin();
	}
	
	/**
	 * 显示结果信息框
	 * @param rm 成功或失败
	 */
	public void showInformationDialog(DataRM rm){
		if(rm == DataRM.SUCCESS){
			Alert information = new Alert(Alert.AlertType.INFORMATION,"请继续努力工作吧~");
			information.setTitle("");         
			information.setHeaderText("成功");    
			information.showAndWait();
			
		}else if(rm == DataRM.FAILED){
			Alert information = new Alert(Alert.AlertType.ERROR,"请继续努力工作吧~");
			information.setTitle("");         
			information.setHeaderText("失败");    
			information.showAndWait();
		}else{
			System.err.println("DataRM is not success or failed");
		}
	}
	/**
	 * 显示确认对话框
	 * @return 是或否
	 */
	public boolean showConfirmDialog(){
		System.out.println("confirming");
		Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"确认此项操作？");
	    Optional<ButtonType> result = confirmation.showAndWait();
	    if(result.isPresent() && result.get() == ButtonType.OK){
	        return true;
	     }
	    else{
	    	return false;
	     }
	}
//	public void setParentController(ParentController controller){
//		parentController = controller;
//	};
//	
//	public void setListID(String id){
//		listID.setText(id);
//	}
//	
//	public void setOperator(String name){
//		operator.setText(name);
//	}
}
