package PO;

import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumPO extends PresentPO{
	/**
	 * 总额
	 */
	double sum;
	/**
	 *赠品列表
	 */	
	List<GoodsInSalePO> presentList;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
	
	
}
