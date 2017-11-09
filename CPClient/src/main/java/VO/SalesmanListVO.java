package VO;

import java.util.List;

public abstract class SalesmanListVO extends ListVO{
	 /**
	  * 客户编号
	  */
	 String memberID;
	/**
	  * 客户名
	  */
	 String memberName;
	 /**
	  * 业务员名字
	  */
	 String operator;
	 // ListState state;
	 /**
	  * 仓库名字
	  */
	 String warehouse = "默认仓库";
	 /**
	  * 备注
	  */	 
	 String notes; 
	 /**
	  * 商品清单
	  */
	 List<SalesmanItemVO> SaleListItems;
	 /**
	  * 最终金额
	  */
	 double sum;
//	  double priceBeforeDiscount; //折让前总额
//	  double discount;//销售人员折让
//	  double voucher;//代金券数额
//	  double finalPrice;
}
