package VO.listVO;

import bl.listbl.InfoList;
import util.GreatListType;
import util.ListType;

public class InfoListVO {
    public String id;  //单据编号
    public GreatListType type;  // 单据类型
    public String operater; //操作对象
    public String note; //备注
    public InfoListVO (String id,GreatListType type,String operator,String note){
        this.id=id;
        this.note=note;
        this.type=type;
        this.operater=operator;
    }

//  王瑞华 制作

}
