package PO;

import java.io.Serializable;
import java.util.ArrayList;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentListPO extends StockListPO implements Serializable{
	
	public ArrayList<String >id ; //赠品ID
	   public String listID;  //单据编号
	   public ArrayList<Integer > num;//赠品数量
	   public ArrayList<String >name ;//赠品名字
	   public String VIPname ; // 赠送的对象
	   public State statetype;
	   
	   public String time;//操作时间
	   public String operator;//操作员
}
