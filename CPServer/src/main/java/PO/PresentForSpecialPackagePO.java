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
	public PresentForSpecialPackagePO(String id, Date startTime, Date finishTime, List<GoodsInSalePO> goodsList,
			double priceReduction) {
		super(id, startTime, finishTime);
		this.goodsList = goodsList;
		this.priceReduction = priceReduction;
	}
	/**
	 *商品列表，每个策略里只有一个特价包
	 */	
	List<GoodsInSalePO> goodsList;
	/**
	 *降价金额
	 */	
	double priceReduction;


}
