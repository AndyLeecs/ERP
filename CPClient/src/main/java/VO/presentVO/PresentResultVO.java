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
	 * 策略id列表,点击id可以查看详情
	 */
	List<Integer> presentId;
	/**
	 * 价格折让
	 */
	double price_discount;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 *使用赠送策略后总价
	 */	
	double sum;
}
