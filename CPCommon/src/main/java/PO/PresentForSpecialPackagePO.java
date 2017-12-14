package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackagePO extends PresentPO implements Serializable{
	public PresentForSpecialPackagePO(int id,Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			PresentState state,double voucher,double priceReduction) {
		super(id,startTime, finishTime,presentList,state);
		this.priceReduction = priceReduction;
	}
	public PresentForSpecialPackagePO(){}
	/**
	 *降价金额
	 */	
	double priceReduction;

	public double getPriceReduction() {
		return priceReduction;
	}
	public void setPriceReduction(double priceReduction) {
		this.priceReduction = priceReduction;
	}


}
