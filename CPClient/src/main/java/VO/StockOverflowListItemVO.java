package VO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockOverflowListItemVO extends SalesmanItemVO{
	/**
	 * 实际库存数量
	 */
    int numberInReality;
	/**
	 * 系统中库存数量
	 */    
    int numberInSystem;
	/**
	 * 报溢数量
	 */
    int gap;
}
