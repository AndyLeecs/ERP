package VO.saleVO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售单
*/
public class SaleListVO extends SalesmanListVO{
	/**
	 * 单据类型
	 */
	SalesmanListType SaleList;
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
