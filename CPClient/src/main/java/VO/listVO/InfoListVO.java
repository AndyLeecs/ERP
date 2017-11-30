package VO.listVO;

import util.ListType;

public class InfoListVO {
    private String id;  //单据编号
    private ListType type;  // 单据类型
    private String operater; //操作对象
    private String note; //备注
//  王瑞华 制作
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
