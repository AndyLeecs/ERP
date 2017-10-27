package VO;

import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackageVO extends PresentVO{
	/**
	 *商品列表，每个策略里只有一个特价包
	 */	
	List<GoodsInSaleVO> goodsList;
	/**
	 *降价金额
	 */	
	int priceReduction;
}
