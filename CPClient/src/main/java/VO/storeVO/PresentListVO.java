package VO.storeVO;

import java.util.List;

import PO.State;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentListVO {
   public List<String >id ; //赠品ID
   public String listID;  //单据编号
   public List<Integer > num;//赠品数量
   public List<String >name ;//赠品名字
   public String VIPname ; // 赠送的对象
   public State statetype;
   
   public PresentListVO(String listID,List<String > id,List<Integer > num, List<String >name,String VIPname){
	   this.listID=listID;
	   this.id=id;
	   this.name=name;
	   this.num=num;
	   this.VIPname=VIPname;
   }
}
