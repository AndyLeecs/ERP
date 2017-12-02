package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentPO implements Serializable{
	/**
	 * 策略编号
	 */
	int id;
	/**
	 *开始时间
	 */	
	Date startTime;
	/**
	 *结束时间
	 */	
	Date finishTime;
	/**
	 *赠品列表,或者特价包中特价商品
	 */	
	List<GoodsInSalePO> presentList;


//	public PresentPO(String id, Date startTime, Date finishTime) {
//		super();
//		this.id = id;
//		this.startTime = startTime;
//		this.finishTime = finishTime;
//	}
	public PresentPO(){
	}
	public PresentPO(Date startTime, Date finishTime,List<GoodsInSalePO> presentList) {
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.presentList = presentList;
	}

	public List<GoodsInSalePO> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<GoodsInSalePO> presentList) {
		this.presentList = presentList;
	}

	private int getId() {
		return id;
	}



	private void setId(int id) {
		this.id = id;
	}



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getFinishTime() {
		return finishTime;
	}



	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	
}
