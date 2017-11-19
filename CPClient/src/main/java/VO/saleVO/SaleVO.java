package VO.saleVO;

import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售单中返回的信息，供赠送策略使用
*/
public class SaleVO {
	/**
	 * 会员级别
	 */
	VIPGrade grade;
	/**
	 * 商品列表
	 */
	List<GoodsInSaleVO> goodsList;
	/**
	 * 总额
	 */
	int sum;
}
