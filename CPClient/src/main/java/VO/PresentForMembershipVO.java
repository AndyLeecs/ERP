package VO;

import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 针对不同级别的用户制定促销策略（赠品、价格折让、 赠送代金劵）
*/
public class PresentForMembershipVO extends PresentVO{

	/**
	 *会员级别
	 */	
	VIPGrade grade;
	/**
	 *总额
	 */	
	int sum;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 *折让价格
	 */	
	int rebateInPresentForMembership;
	/**
	 *赠送代金券金额
	 */	
	int voucher;

	
	
}
