package ui.managerUI;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import bl.presentbl.PresentBLFactory;
import blservice.presentblservice.PresentForSumBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.DateUtil;
import util.NumberUtil;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class PresentForSumController {
		
		@FXML public Button cancelBtn;
		@FXML public Button saveBtn;
		
		@FXML public TextField searchField;
		@FXML public Button searchBtn;
		@FXML public Pane presentListPane;
		
		@FXML public TextField startYearField;
	    @FXML public TextField startMonthField;
	    @FXML public TextField startDayField;
	    @FXML public TextField finishYearField;
	    @FXML public TextField finishMonthField;
	    @FXML public TextField finishDayField;

	    @FXML public TextField totalField;
	    @FXML public TextField voucherField;
	    
	    @FXML public Label dateErrorMessage;
	    @FXML public Label totalErrorMessage;
	    @FXML public Label voucherErrorMessage;
	    
	    private static final String dateError = "日期格式错误";
	    private static final String totalError = "总额格式错误";
	    private static final String voucherError = "赠券金额格式错误";
	    
	    private List<TextField> textFieldList;
	    
        @FXML private ManagerController managerController;
        
        private boolean modify = false;
        private PresentForSumBLService presentForSumBLService;
    	/**
    	 *开始时间
    	 */	
    	Date startTime;
    	/**
    	 *结束时间
    	 */	
    	Date finishTime;
    	/**
    	 * 总额
    	 */
    	double total;
    	/**
    	 *赠品列表
    	 */	
    	List<GoodsInSaleVO> presentList;
    	/**
    	 * 赠送代金券金额
    	 */
    	double voucher;
       
//	    public void setManagerController(ManagerController managerController){
//	    	this.managerController = managerController;
//	    }
    	
	    
	    @FXML
	    public void initialize(){
	    	
	    	System.out.println("init");
	    	
	    	//加入文本框列表
	    	textFieldList.add(startYearField);
	    	textFieldList.add(startMonthField);
	    	textFieldList.add(startDayField);
	    	textFieldList.add(finishYearField);
	    	textFieldList.add(finishMonthField);
	    	textFieldList.add(finishDayField);
	    	textFieldList.add(totalField);
	    	textFieldList.add(voucherField);
	    }

	    /**
	     * 如果是策略的编辑模式，初始化各项数据
	     */
		
		public void initData(PresentForSumVO vo){
			
			System.out.println("init data");
			//置为修改模式
			modify = true;
			//解析vo
			startTime = vo.getStartTime();
			finishTime = vo.getFinishTime();
			total = vo.getTotal();
			voucher = vo.getVoucher();
			presentList = vo.getPresentList();
			
			//显示数据
		    startYearField.setText(DateUtil.getYear(startTime)+"");
		    startMonthField.setText(DateUtil.getMonth(startTime)+"");
		    startDayField.setText(DateUtil.getDay(startTime)+"");
		    finishYearField.setText(DateUtil.getYear(finishTime)+"");
		    finishMonthField.setText(DateUtil.getMonth(finishTime)+"");
		    finishDayField.setText(DateUtil.getDay(finishTime)+"");
		    totalField.setText(total+"");
		    voucherField.setText(voucher+"");
		    
		    for(TextField f:textFieldList){
		    	f.setStyle("-fx-background-color: #FFECEC");
		    }
	        
	        //显示赠品列表
	        
	        //初始化逻辑层的impl
		    presentForSumBLService = PresentBLFactory.getPresentForSumBLService();
		}
	
		
		
		@FXML
		public void save(){
			System.out.println("save presentForSum");
			/**
			 * 检查合法性
			 */
			
			//检查日期合法性
			try{
		
			startTime = DateUtil.getDate(Integer.parseInt(startYearField.getText()),
					Integer.parseInt(startMonthField.getText()),Integer.parseInt(startDayField.getText()));
			finishTime = DateUtil.getDate(Integer.parseInt(finishYearField.getText()),
					Integer.parseInt(finishMonthField.getText()),Integer.parseInt(finishDayField.getText()));
			}catch(Exception e){
				dateErrorMessage.setText(dateError);
				return;
			}
			
			if(!DateUtil.validStartAndFinish(startTime, finishTime))
			{
				dateErrorMessage.setText(dateError);
				return;
			}
			//检查总额合法性
			String totalInString = totalField.getText();
			
			if(!NumberUtil.isNotNegative(totalInString)){
				totalErrorMessage.setText(totalError);
				return;
			}
			//检查赠券金额合法性
			String voucherInString = voucherField.getText();
			if(!NumberUtil.isNotNegative(voucherInString)){
				voucherErrorMessage.setText(voucherError);
				return;
			}
			if(!modify){
			//打包成vo
			PresentForSumVO vo = new PresentForSumVO(startTime, finishTime,total, presentList,voucher);
			//传递vo到逻辑层	
			presentForSumBLService.addPresentForSum(vo);
			}
			else{
				
			}
			//回到主界面
			back();
		}
		
		//回到主界面
		private void back(){
			
		}
		@FXML
		public void cancel(){
			System.out.println("cancel presentForSum");
			back();
		}

		@FXML
		public void search(){
			System.out.println("search goods");
			
		}
		
}
