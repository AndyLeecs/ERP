package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class SaleReturnListPO extends SalesmanListPO implements Serializable{
	/**
	 * 单据编号
	 */
	String id;
	/**
	 * 折让前总额
	 */
	double sumBeforeRebate;
	/**
	 * 折让
	 */
	double rebate;
	/**
	 * 使用代金券金额
	 */
	double voucher;
//	public SaleReturnListPO(){}
	
	public SaleReturnListPO(String memberID, String memberName, String operator, String warehouse, String notes,
			List<SalesmanItemPO> saleListItems, double sum,String id,double sumBeforeRebate, double rebate, double voucher) {
		super(memberID, memberName, operator, warehouse, notes,
				saleListItems, sum);
		this.id = id;
		this.sumBeforeRebate = sumBeforeRebate;
		this.rebate = rebate;
		this.voucher = voucher;
	}

	public String getId(){
//		return "0001";
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public double getSumBeforeRebate() {
		return sumBeforeRebate;
	}
	public void setSumBeforeRebate(double sumBeforeRebate) {
		this.sumBeforeRebate = sumBeforeRebate;
	}
	public double getRebate() {
		return rebate;
	}
	public void setRebate(double rebate) {
		this.rebate = rebate;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
}
