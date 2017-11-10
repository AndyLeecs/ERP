package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 针对不同级别的用户制定促销策略（赠品、价格折让、 赠送代金劵）
*/
public class PresentForMembershipPO extends PresentPO implements Serializable{

	public PresentForMembershipPO(String id, Date startTime, Date finishTime, MemberGrade grade, double sum,
			List<GoodsInSalePO> presentList, double rebateInPresentForMembership, double voucher) {
		super(id, startTime, finishTime);
		this.grade = grade;
		this.sum = sum;
		this.presentList = presentList;
		this.rebateInPresentForMembership = rebateInPresentForMembership;
		this.voucher = voucher;
	}
	/**
	 *会员级别
	 */	
	MemberGrade grade;
	/**
	 *总额
	 */	
	double sum;
	/**
	 *赠品列表
	 */	
	List<GoodsInSalePO> presentList;
	/**
	 *折让价格
	 */	
	double rebateInPresentForMembership;
	/**
	 *赠送代金券金额
	 */	
	double voucher;

	
	
}
