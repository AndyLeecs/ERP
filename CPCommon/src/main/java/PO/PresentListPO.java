package PO;

import java.io.Serializable;
import java.util.ArrayList;

import util.State;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentListPO extends StockListPO implements Serializable{
	
	public ArrayList<String >id ; //赠品ID
	   public String listID;  //单据编号
	   public int num;//赠品数量

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String name ;//赠品名字

	public String  getName() {
		return name;
	}

	public void setName(String  name) {
		this.name = name;
	}

	public String VIPname ; // 赠送的对象

	public String getVIPname() {
		return VIPname;
	}

	public void setVIPname(String VIPname) {
		this.VIPname = VIPname;
	}

	public State statetype;

	public State getStatetype() {
		return statetype;
	}

	public void setStatetype(State statetype) {
		this.statetype = statetype;
	}

	public String time;//操作时间

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String operator;//操作员
	private String autoId;

	public String getAutoId() {
		return autoId;
	}

	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}
}
