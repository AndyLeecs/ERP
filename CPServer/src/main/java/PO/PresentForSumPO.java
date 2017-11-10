package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumPO extends PresentPO implements Serializable{
	public PresentForSumPO(String id, Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			double voucher) {
		super(id, startTime, finishTime);
		this.sum = sum;
		this.presentList = presentList;
		this.voucher = voucher;
	}
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
