package ui.managerUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import VO.presentVO.PresentVO;
import bl.presentbl.PresentBLFactory;
import blservice.presentblservice.PresentForSumBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.DataRM;
import util.DateUtil;
import util.NumberUtil;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class PresentForSumController implements SinglePresentController{
		
		@FXML protected Button cancelBtn;
		@FXML protected Button saveBtn;
		
		@FXML protected TextField searchField;
		@FXML protected Button searchBtn;
		@FXML protected Pane presentListPane;
		
		@FXML protected TextField startYearField;
	    @FXML protected TextField startMonthField;
	    @FXML protected TextField startDayField;
	    @FXML protected TextField finishYearField;
	    @FXML protected TextField finishMonthField;
	    @FXML protected TextField finishDayField;

	    @FXML protected TextField totalField;
	    @FXML protected TextField voucherField;
	    
	    @FXML protected Label nullErrorMessage;
	    @FXML protected Label dateErrorMessage;
	    @FXML protected Label totalErrorMessage;
	    @FXML protected Label voucherErrorMessage;
	    
	    private static final String nullError = "请填写所有字段";
	    private static final String dateError = "日期格式错误";
	    private static final String totalError = "总额格式错误";
	    private static final String voucherError = "赠券金额格式错误";
	    
	    protected List<TextField> textFieldList;
	    
	    private PresentForSumBLService service;
	    private Strategy strategy;
	    //暂存vo，传递给strategy
	    private PresentVO vo;
	    @FXML private ManagerController managerController;
        
		/**
         * 界面保存但不显示策略id
         */
        int id;
//        
//    	/**
//    	 *开始时间
//    	 */	
//    	Date startTime;
//    	/**
//    	 *结束时间
//    	 */	
//    	Date finishTime;
//    	/**
//    	 * 总额
//    	 */
//    	double total;
    	/**
    	 *赠品列表,临时作为静态变量保证程序不崩
    	 */	
    	List<GoodsInSaleVO> presentList;
//    	/**
//    	 * 赠送代金券金额
//    	 */
//    	double voucher;
//       
//	    public void setManagerController(ManagerController managerController){
//	    	this.managerController = managerController;
//	    }
    	
       
        
        public PresentForSumBLService getService() {
			return service;
		}

		public void setService(PresentForSumBLService service) {
			this.service = service;
		}
		
	    public ManagerController getManagerController() {
			return managerController;
		}

		public void setManagerController(ManagerController managerController) {
			this.managerController = managerController;
		}

		public Strategy getStrategy() {
			return strategy;
		}

		public void setStrategy(Strategy strategy) {
			this.strategy = strategy;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

//		public Date getStartTime() {
//			return startTime;
//		}
//
//		public void setStartTime(Date startTime) {
//			this.startTime = startTime;
//		}
//
//		public Date getFinishTime() {
//			return finishTime;
//		}
//
//		public void setFinishTime(Date finishTime) {
//			this.finishTime = finishTime;
//		}
//
//		public double getTotal() {
//			return total;
//		}
//
//		public void setTotal(double total) {
//			this.total = total;
//		}
//
//		public List<GoodsInSaleVO> getPresentList() {
//			return presentList;
//		}
//
//		public void setPresentList(List<GoodsInSaleVO> presentList) {
//			this.presentList = presentList;
//		}
//
//		public double getVoucher() {
//			return voucher;
//		}
//
//		public void setVoucher(double voucher) {
//			this.voucher = voucher;
//		}

		public PresentForSumController(Strategy strategy,ManagerController managerController){
			this.strategy = strategy;
			this.managerController = managerController;
			this.vo = null;
	    	service = PresentBLFactory.getPresentForSumBLService();
		}
		public PresentForSumController(Strategy strategy,ManagerController managerController,PresentVO vo){
			this.strategy = strategy;
			this.managerController = managerController;
			this.vo = vo;
	    	service = PresentBLFactory.getPresentForSumBLService();
		}		
		@FXML
	    public void initialize(){
	    	
	    	System.out.println("init");
	    	
	    	textFieldList = new ArrayList<TextField>();
	    	//加入文本框列表
	    	textFieldList.add(startYearField);
	    	textFieldList.add(startMonthField);
	    	textFieldList.add(startDayField);
	    	textFieldList.add(finishYearField);
	    	textFieldList.add(finishMonthField);
	    	textFieldList.add(finishDayField);
	    	textFieldList.add(totalField);
	    	textFieldList.add(voucherField);
	    	
	    	//初始化数值
	    	strategy.initData(this, vo);
	    	
	    	//把vo清空
	    	vo = null;
	    }
				
		@FXML
		@Override
		public void save(){
			System.out.println("save presentForSum");
			/**
			 * 检查合法性
			 */
		    //清空提示信息
		    nullErrorMessage.setText("");
		    dateErrorMessage.setText("");
		    totalErrorMessage.setText("");
		    voucherErrorMessage.setText("");
		    
			//检查非空字段
		    for(TextField f:textFieldList){
//		    	System.out.println(f);
//		    	assert(f != null);
		    	String s = f.getText();
		    	if(s == null || s.length() == 0){
		    		nullErrorMessage.setText(nullError);
		    		return;	
		    	}
		    }

			//检查日期合法性
		    Date startTime = new Date();
		    Date finishTime = new Date();
			try{
		
			startTime = DateUtil.getDate(Integer.parseInt(startYearField.getText()),
					Integer.parseInt(startMonthField.getText()),Integer.parseInt(startDayField.getText()));
			finishTime = DateUtil.getDate(Integer.parseInt(finishYearField.getText()),
					Integer.parseInt(finishMonthField.getText()),Integer.parseInt(finishDayField.getText()));
			}catch(Exception e){
				dateErrorMessage.setText(dateError);
				System.out.println("can not convert to date");
				return;
			}
			
			if(!DateUtil.validStartAndFinish(startTime, finishTime))
			{
				dateErrorMessage.setText(dateError);
				System.out.println(startTime);
				System.out.println(finishTime);
				System.out.println("not valid start and finish");
				return;
			}
			//检查总额合法性
			String totalInString = totalField.getText();
			int total = 0;
			
			if(!NumberUtil.isNotNegative(totalInString)){
				totalErrorMessage.setText(totalError);
				return;
			}
			//检查赠券金额合法性
			String voucherInString = voucherField.getText();
			int voucher = 0;
			if(!NumberUtil.isNotNegative(voucherInString)){
				voucherErrorMessage.setText(voucherError);
				return;
			}
			
			
			//打包成vo
			PresentForSumVO vo = new PresentForSumVO(id,startTime, finishTime,total, presentList,voucher);
			
			//确认操作
			
			if(showConfirmDialog()){
			//传递vo到逻辑层	
			DataRM rm = service.save(vo);
			//显示信息弹窗
			showInformationDialog(rm);
			//回到主界面
			back();
			}
		}
		//确认
		@Override
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
		//回到主界面
		@Override
		public void back(){
			managerController.centerPane.setCenter(null);
		}
		@FXML
		public void cancel(){
			System.out.println("cancel presentForSum");
			if(showConfirmDialog()){
				DataRM rm = strategy.cancel(this);
				//显示处理信息
				showInformationDialog(rm);
				back();
			}
		}

		@FXML
		@Override
		public void search(){
			System.out.println("search goods");
			
		}
		
		
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
		
		

		
		
}
