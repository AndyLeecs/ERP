package VO.presentVO;

import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackageVO extends PresentVO{

	/**
	 * 策略类型
	 */
	PresentType SpecialPackage;
	/**
	 *商品列表，每个策略里只有一个特价包
	 */	
	List<GoodsInSaleVO> goodsList;
	/**
	 *降价金额
	 */	
	int priceReduction;
	
	public String getPresentName(){
		return this.presentName;
	}

	public PresentForSpecialPackageVO(String id, String presentName, Date startTime, Date finishTime,
			PresentType specialPackage, List<GoodsInSaleVO> goodsList, int priceReduction) {
		super(id, presentName, startTime, finishTime);
		SpecialPackage = specialPackage;
		this.goodsList = goodsList;
		this.priceReduction = priceReduction;
	}


	
}
