package VO.presentVO;

import java.util.Date;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public abstract class PresentVO {
	/**
	 * 策略编号
	 */
	String id;
	/**
	 * 策略名称
	 */
	String presentName;
	/**
	 *开始时间
	 */	
	Date startTime;
	/**
	 *结束时间
	 */	
	Date finishTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPresentName() {
		return presentName;
	}
	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}
	public PresentVO(String id, String presentName, Date startTime, Date finishTime) {
		super();
		this.id = id;
		this.presentName = presentName;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	

}
