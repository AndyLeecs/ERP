package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售人员狐狸的单据中的商品项
*/
public abstract class SalesmanItemPO  implements Serializable{
	/**
	 * 商品编号
	 */
	String id;
	/**
	 * 商品名
	 */	
	String name;
	/**
	 * 型号
	 */
	String type;
	/**
	 * 单价
	 */
	double price;
	/**
	 * 数量
	 */
	double amount;
	/**
	 * 金额
	 */
	double sum;
	/**
	 * 备注
	 */
	String notes;
}
