package PO;

import util.GreatListType;

public class StoreLogPO {
	//为了库存查看，必须记录下来每次库存变动的时间、商品ID、商品名称、变动原因、商品数量、涉及的单价
	public String time;
    private GreatListType Type;

    public GreatListType getType() {
        return Type;
    }

    public void setType(GreatListType type) {
        Type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GreatListType type;
	public int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String  autoId;

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }
}
