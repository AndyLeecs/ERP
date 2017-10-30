package VO;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 库存管理人员处理的单据类型，包括库存报溢单，库存报损单，库存赠送单
*/
public enum StockmanListType implements ListType{
	OverflowList("库存报溢单"),
	LostList("库存报损单"),
	PresentList("库存赠送单");
		
	
	private final String type;
	
	private StockmanListType(String type){
		this.type = type;
	}
	
	public String getName(){
		return this.type;
	}
}
