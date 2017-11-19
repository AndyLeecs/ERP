package VO.storeVO;

import VO.saleVO.SalesmanItemVO;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockOverflowAndLostListItemVO extends SalesmanItemVO{
	/**
	 * 实际库存数量
	 */
    int numberInReality;
	/**
	 * 系统中库存数量
	 */    
    int numberInSystem;
	/**
	 * 报溢/损数量
	 */
    int gap;
}
