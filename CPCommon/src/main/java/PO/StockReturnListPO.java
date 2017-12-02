package PO;

import java.io.Serializable;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockReturnListPO extends SalesmanListPO implements Serializable{
	/*
	 * 单据编号
	 */
	String id;
	public StockReturnListPO(){}
	public StockReturnListPO(String memberID, String memberName, String operator, String warehouse, String notes,
			List<SalesmanItemPO> saleListItems, double sum) {
		super(memberID, memberName, operator, warehouse, notes,
				saleListItems, sum);
		this.id = getId();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
