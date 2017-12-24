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
	//private static final long serialVersionUID = 3819185728624176297L;
	public String name; //商品名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String ID;  //商品ID

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public int alarmNum;//警戒线

	public int getAlarmNum() {
		return alarmNum;
	}

	public void setAlarmNum(int alarmNum) {
		this.alarmNum = alarmNum;
	}

	public int Num; //现有数量

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public double averagePrice;//库存均价

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	private String autoId;

	public String getAutoId() {
		return autoId;
	}

	public void setAutoId(String autoId ) {
		this.autoId = autoId;
	}
}
