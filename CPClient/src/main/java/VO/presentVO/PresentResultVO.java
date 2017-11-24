package VO.presentVO;

import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description 销售中返回给界面的赠送结果
*/
public class PresentResultVO {
	/**
	 * 策略名称列表
	 */
	List<String> presentName;
	/**
	 * 价格折让
	 */
	int price_discount;
	/**
	 * 赠送代金券金额
	 */
	int voucher;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 *使用赠送策略后总价
	 */	
	int sum;
}
