package util;


/**     
* @author 李安迪
* @date 2017年11月9日
* @description 单据状态
*/
public enum State {
	IsDraft(0),
	IsCommitted(1),
	IsApproved(2),
	IsRefused(3),
	IsEditting(4);
	
	private final int state;
	
	State(int state){
		this.state = state;
	}
	
	public int getState(){
		return this.state;
	}
	
	
}
