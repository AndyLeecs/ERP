package PO;

import util.GreatListType;

public class InfoListPO {
	public String id;  //单据编号
    public GreatListType type;  // 单据类型
    public String operator; //操作人员
    public String note; //备注
    public InfoListPO (String id,GreatListType type,String operator,String note){
        this.id=id;
        this.note=note;
        this.type=type;
        this.operator=operator;
    }

//  王瑞华 制作
}