package VO;

import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumVO extends PresentVO{
	/**
	 * 策略名称
	 */
	String presentName;
	/**
	 * 策略类型
	 */
	PresentType Sum;
	/**
	 * 总额
	 */
	int sum;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 * 赠送代金券金额
	 */
	int voucher;
	
	
}
