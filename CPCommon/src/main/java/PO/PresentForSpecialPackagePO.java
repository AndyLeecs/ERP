package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackagePO extends PresentPO implements Serializable{
	public PresentForSpecialPackagePO(Date startTime, Date finishTime, List<GoodsInSalePO> presentList,
			double priceReduction) {
		super(startTime, finishTime,presentList);
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
