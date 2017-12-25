package PO;

import java.io.Serializable;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import util.State;

public class SalesmanListPO  implements Serializable{
//	 /**
//	  * 数据库id
//	  */
//	int id;
	String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 单据状态
	 */
	State state;
	 /**
	  * 日期，精确到天
	  */	
	Date day;

	/**
	  * 客户编号
	  */
	 String memberID;
	/**
	  * 客户名
	  */
	 String memberName;
	 /**
	  * 操作员id?
	  */
	 String operator;
	 //业务员id
	 String realOperator;
	 
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
	 List<SalesmanItemPO> SaleListItems;
	 /**
	  * 最终金额
	  */
	 double sum;


	 public SalesmanListPO(String id, State state, Date day, String memberID, String memberName, String operator,
			String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum) {
		super();
		this.id = id;
		this.state = state;
		this.day = day;
		this.memberID = memberID;
		this.memberName = memberName;
		this.operator = operator;
		this.realOperator = realOperator;
		this.warehouse = warehouse;
		this.notes = notes;
		SaleListItems = saleListItems;
		this.sum = sum;
	}

	public SalesmanListPO(){}

//	private int getId() {
//		return id;
//	}
//	private void setId(int id) {
//		this.id = id;
//	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public List<SalesmanItemPO> getSaleListItems() {
		return SaleListItems;
	}
	public void setSaleListItems(List<SalesmanItemPO> saleListItems) {
		SaleListItems = saleListItems;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

	public String getRealOperator() {
		return realOperator;
	}

	public void setRealOperator(String realOperator) {
		this.realOperator = realOperator;
	}
	 
	 
//	  double priceBeforeDiscount; //折让前总额
//	  double discount;//销售人员折让
//	  double voucher;//代金券数额
//	  double finalPrice;
}
