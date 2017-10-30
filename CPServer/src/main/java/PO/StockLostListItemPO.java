package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockLostListItemPO extends SalesmanItemPO implements Serializable{
	/**
	 * 实际库存数量
	 */
    int numberInReality;
	/**
	 * 系统中库存数量
	 */    
    int numberInSystem;
	/**
	 * 报损数量
	 */
    int gap;
}
