package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;

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

	PresentState state = PresentState.EDIT;
public PresentState getState() {
		return state;
	}


	public void setState(PresentState state) {
		this.state = state;
	}


	//	public PresentPO(String id, Date startTime, Date finishTime) {
//		super();
//		this.id = id;
//		this.startTime = startTime;
//		this.finishTime = finishTime;
//	}
	public PresentPO(){
	}
	


	public PresentPO(int id, Date startTime, Date finishTime, List<GoodsInSalePO> presentList, PresentState state) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.presentList = presentList;
		this.state = state;
	}


	public List<GoodsInSalePO> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<GoodsInSalePO> presentList) {
		this.presentList = presentList;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
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
