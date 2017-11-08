package VO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售退货单
*/
public class SaleBackListVO extends SalesmanListVO{
	/**
	 * 单据类型
	 */
	SalesmanListType SaleBackList;
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
