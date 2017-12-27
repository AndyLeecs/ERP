package PO;

import util.GoodsUtil;

import java.io.Serializable;
import java.util.Map;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsCategoryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9022883235329228560L;
	String goodsCategoryName;
    String parentName;
    private int autoId;
    private GoodsUtil state = GoodsUtil.EXIST;

    public GoodsCategoryPO(String goodsCategoryName, String parentName, GoodsUtil state) {
        this.goodsCategoryName = goodsCategoryName;
        this.parentName = parentName;
        this.state = state;
    }

    public GoodsCategoryPO() {
    }

    public void setState(GoodsUtil state) {
        this.state = state;
    }

    public GoodsUtil getState() {
        return state;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
}