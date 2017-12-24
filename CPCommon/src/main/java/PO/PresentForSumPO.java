package PO;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import util.PresentState;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumPO extends PresentPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5139108421227021591L;
	/**
	 * 
	 */

	public PresentForSumPO(){}
	public PresentForSumPO(int id,Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			PresentState state,double voucher) {
		super(id,startTime, finishTime,presentList,state);
		this.sum = sum;
		this.presentList = presentList;
		this.voucher = voucher;
	}
	/**
	 * 总额
	 */
	double sum;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	
	
}
