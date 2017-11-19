package VO.presentVO;

import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumVO extends PresentVO{

	/**
	 * 策略类型
	 */
	PresentType Sum;
	/**
	 * 总额
	 */
	int total;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 * 赠送代金券金额
	 */
	int voucher;
	
	public String getPresentName(){
		return this.presentName;
	}

	public PresentForSumVO(String id, String presentName, Date startTime, Date finishTime, PresentType sum, int total,
			List<GoodsInSaleVO> presentList, int voucher) {
		super(id, presentName, startTime, finishTime);
		Sum = sum;
		this.total = total;
		this.presentList = presentList;
		this.voucher = voucher;
	}


	
	
}
