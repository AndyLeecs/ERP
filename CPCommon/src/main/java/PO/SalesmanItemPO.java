package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售人员狐狸的单据中的商品项
*/
public class SalesmanItemPO  implements Serializable{
	int autoId;
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
	public SalesmanItemPO(){}
	public SalesmanItemPO(int autoId,String id, String name, String type, double price, double amount, double sum, String notes) {
		super();
		this.autoId = autoId;
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
		this.notes = notes;
	}
	public int getAutoId() {
		return autoId;
	}
	private void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
