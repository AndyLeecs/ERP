package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public abstract class PresentPO{
	/**
	 * 策略编号
	 */
	String id;
	/**
	 *开始时间
	 */	
	Date startTime;
	/**
	 *结束时间
	 */	
	Date finishTime;

	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public PresentPO(String id, Date startTime, Date finishTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	
}
