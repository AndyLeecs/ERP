package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 针对不同级别的用户制定促销策略（赠品、价格折让、 赠送代金劵）
*/
public class PresentForMembershipPO extends PresentPO implements Serializable{
	public PresentForMembershipPO(){}
	public PresentForMembershipPO(int id,Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			PresentState state,double voucher,VIPGrade grade,double rebateInPresentForMembership) {
		super(id,startTime, finishTime,presentList,state);
		this.grade = grade;
		this.sum = sum;
		this.rebateInPresentForMembership = rebateInPresentForMembership;
		this.voucher = voucher;
	}
	/**
	 *会员级别
	 */	
	VIPGrade grade;
	/**
	 *总额
	 */	
	double sum;

	/**
	 *折让价格
	 */	
	double rebateInPresentForMembership;
	/**
	 *赠送代金券金额
	 */	
	double voucher;
	public VIPGrade getGrade() {
		return grade;
	}
	public void setGrade(VIPGrade grade) {
		this.grade = grade;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getRebateInPresentForMembership() {
		return rebateInPresentForMembership;
	}
	public void setRebateInPresentForMembership(double rebateInPresentForMembership) {
		this.rebateInPresentForMembership = rebateInPresentForMembership;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

	
	
}
