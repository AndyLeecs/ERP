package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class StorePO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3819185728624176297L;
	public String name; //商品名称
	public String ID;  //商品ID
	public int alarmNum;//警戒线
	public int Num; //现有数量
	
	public double averagePrice;//库存均价

}
