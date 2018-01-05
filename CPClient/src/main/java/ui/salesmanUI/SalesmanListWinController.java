package ui.salesmanUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import blservice.VIPblservice.VIPFuzzySearch;
import bl.VIPbl.VIPFuzzySearchImpl;
import blservice.goodsblservice.GoodsFuzzySearch;
import bl.goodsbl.GoodsFuzzySearchImpl;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptWin;
import ui.salesmanUI.vip.VIPSearchResultWin;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据接口的抽象父类
*/
public abstract class SalesmanListWinController{
	protected ParentController parentController;
	
	protected SaleUniBLService uniBLService;
	protected GoodsFuzzySearch goodsFuzzySearch;
	protected VIPFuzzySearch vipFuzzySearch;
	
	
	protected String id;
	/**
	 * 已选择的商品列表
	 */
	protected List<SalesmanItemVO> chosenList;
	protected List<SalesmanEditCellController> controllerList;
	
	@FXML protected AnchorPane root;
	
	@FXML protected Label listID;
	@FXML protected Label operator;
	@FXML protected String operatorId;
	@FXML protected UserGrade operatorGrade;
	
	@FXML protected Label totalAmount;
	
	@FXML protected Label VIPID;
	@FXML protected Label VIPName;
	
	@FXML protected TextField notesTextField;
	


	@FXML protected Button selectVIPBtn;
	@FXML protected TextField searchVIPField;

	@FXML protected Button selectGoodsBtn;
	@FXML protected TextField searchGoodsField;
	
	@FXML protected VBox goodsListVBox;
	
	@FXML protected Label nullErrorMessage;
	protected static final String nullError = "请填写并选择所有项";
	
	@FXML protected Label numberErrorMessage;
	protected static final String numberError = "数字格式错误";
	
	protected static final String cellUrl = "/fxml/salesmanUI/TableItem.fxml";
	
	protected boolean saved = false;//标记是否被保存过，如果被保存过，取消的时候不删除这张单据
	public SalesmanListWinController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super();
		this.parentController = parentController;
		this.uniBLService = uniBLService;
		this.id = id;
		goodsFuzzySearch = new GoodsFuzzySearchImpl();
		vipFuzzySearch = new VIPFuzzySearchImpl();
		this.chosenList = new ArrayList<SalesmanItemVO>();
		this.controllerList = new ArrayList<SalesmanEditCellController>();
	}
	

	/**
	 * 显示单据id
	 */
	@FXML
	protected 
	void initialize(){
		listID.setText(id);
		System.out.println("salesmanListWinController initialized");

	}
	
	/**
	 * 查找商品
	 */
	@FXML
	protected
	void selectGoods(){
		//获得关键字
		String message = searchGoodsField.getText();
		if(message != null && message.length() != 0){
		System.out.println("in select Goods");
		//查找，分别用三种模糊查找，然后合并得到的商品列表结果
		List<GoodsVO> temp = new ArrayList<GoodsVO>();
		temp.addAll(goodsFuzzySearch.getGoodsInID(message));
		temp.addAll(goodsFuzzySearch.getGoodsInGoodsName(message));
		temp.addAll(goodsFuzzySearch.getGoodsInCategory(message));
		
		//去重
		temp = avoidDup(temp);
		
		showSearchGoodsWin(temp);
		}

	}
	
	//根据子类的不同判断使用的是最近进价还是售价
   public abstract void showSearchGoodsWin(List<GoodsVO> temp);

	/**
	 * @param temp
	 * @return 去重后的list
	 */
	public List avoidDup(List temp) {
		temp = new ArrayList(new LinkedHashSet<>(temp));
		return temp;
	}
	

	/**
	 * 查找会员
	 */
	@FXML
	protected
	void selectVIP(){
		//获得关键字
		System.out.println("field is"+searchVIPField);
		System.out.println("select VIP message is"+searchVIPField.getText());
		String message = searchVIPField.getText();
		if(message != null && message.length() != 0){
		//查找，分别用三种模糊查找，然后合并得到的商品列表结果
		List<VIPVO> temp = totalFuzzySearchVIP(message);
		
		try {
			new VIPSearchResultWin(temp,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}

	/**
	 * @param message
	 * @return
	 */
	public List<VIPVO> totalFuzzySearchVIP(String message) {
		List<VIPVO> temp = new ArrayList<VIPVO>();
		getVIPList(message, temp);
		temp = avoidDup(temp);
		return temp;
	}

	/**
	 * @param message 搜索信息
	 * @param temp 结果集，为空
	 */
	public abstract void getVIPList(String message, List<VIPVO> temp);


	/**
	 * 添加到商品清单
	 */
	protected void addToList(SalesmanItemVO vo){
		int dup = -1;
		for(SalesmanItemVO v : chosenList){
			if(v.getId().equals(vo.getId())){
				dup = chosenList.indexOf(v);
			}
		}
		if(dup == -1)
		this.chosenList.add(vo);
		else{
			try {
				new PromptWin("重复添加的商品无效哦");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//去重
	//	this.chosenList = new ArrayList<SalesmanItemVO>(new LinkedHashSet<SalesmanItemVO>(this.chosenList));
		this.refresh();
	}
	/**
	 * 从商品清单中删除
	 */
	protected void deleteFromchosenList(SalesmanItemVO vo){
		this.chosenList.remove(vo);
		this.refresh();
	}
	
	public List<SalesmanItemVO> getchosenList() {
		return chosenList;
	}
//
	
	public void setchosenList(List<SalesmanItemVO> chosenList) {
		this.chosenList = chosenList;
		this.refresh();
	}
	
	public boolean check(){
		/**
		 * 检查合法性
		 */
		nullErrorMessage.setText("");
		numberErrorMessage.setText("");
		//检查是否选择了会员
		//检查是否选择了商品
		if(VIPID.getText().isEmpty()||chosenList.isEmpty()){
			nullErrorMessage.setText(nullError);
			return false;
		}
		//检查数字格式合法性
		
		if(!checkFormat())
			return false;
		//检查商品清单合法性
		if(!checkList())
			return false;
		
		return true;
	}
	public boolean checkFormat(){
		
		return true;
	}
//	public abstract void checkList();
	//检查赠品清单合法性
	public  boolean checkList(){
	for(SalesmanEditCellController c :controllerList){
		if(!c.isValid())
		{
			numberErrorMessage.setText(numberError);
			return false;
		}
	}
	return true;
	}
	/**
	 * 返回父界面
	 */
	public void back(){
		if(parentController != null)
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
	/**
	 * 更新商品列表
	 */
	public abstract void refresh();

	/**
	 * @param loader
	 */
	protected void addChildrenForVBox(FXMLLoader loader) {
		AnchorPane presentroot = null;
		try {
			presentroot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		goodsListVBox.getChildren().add(presentroot);
	}

	/**
	 * @param vo
	 */
	public void setVIP(VIPVO vo) {
		VIPID.setText(vo.getId());
		VIPName.setText(vo.getName());
		
	}
	
	public void showPrompt(DataRM rm){
		try{
		switch(rm){
		case SUCCESS:
			new PromptWin("成功~");
			break;
		case EXIST:
			new PromptWin("存在重复单据哦~");
			break;
		case NOT_EXIST:
			new PromptWin("单据不存在~");
			break;
		case FAILED:
			new PromptWin("失败了呢~");
			break;
		case NET_FAILED:
			new PromptWin("网络有点渣~");
			break;
		case STOCK_FAILED:
			new PromptWin("库存不足~");
			break;
		case VIP_FAILED:
			new PromptWin("超出应收额度~");
			break;
		case PRESENT_FAILED:
			new PromptWin("生成库存赠送单失败了~");
			break;
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@FXML
	protected
	void commit(){

		if(!check())
			return;
		uniBLService.commit(getVOFromUI());
		PromptHelper.showPrompt(DataRM.SUCCESS);
		this.parentController.CloseSonWin();
	}
	
	@FXML
	protected
	void save(){
		saved = true;
		//保存
		uniBLService.save(getVOFromUI());	
		System.out.println("save");
	}
	
	//从ui界面得到所需的vo
	public abstract SalesmanListVO getVOFromUI();
}
