package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class SaleListPO extends SalesmanListPO implements Serializable{
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
	
}
