package PO;

import java.io.Serializable;

import util.State;

import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockListPO extends SalesmanListPO implements Serializable{
//	/*
//	 * 单据编号
//	 */
//	String id;
	public StockListPO(){}
//	public StockListPO(State state, String memberID, String memberName, String operator, String warehouse, String notes,
//			List<SalesmanItemPO> saleListItems, double sum, String id) {
//		super(state, memberID, memberName, operator, warehouse, notes, saleListItems, sum);
//		this.id = id;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//	

	public StockListPO(String id, State state, Date day, String memberID, String memberName, String operator,
			String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum) {
		super(id, state, day, memberID, memberName, operator, realOperator, warehouse, notes, saleListItems, sum);
		// TODO Auto-generated constructor stub
	}
}
