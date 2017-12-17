package PO;

import java.io.Serializable;

public class GoodsPO implements Serializable{
	/**
	 * 商品编号
	 */
	String goodsID;


	/**
	 * 商品名称
	 */
	String goodsName;
	/**
	 * 商品分类
	 */
	String goodsCategory;
	/**
	 * 商品类型
	 */
	String goodsType;
	/**
	 * 商品进价
	 */
	double goodsBuyPrice;
	/**
	 * 商品零售价
	 */
	double goodsSellPrice;
	/**
	 * 最近进价
	 */
	double recentBuyPrice;

    /**
     * 最近零售价
     */
    double recentSellPrice;

    /**
     * 数据库自动生成的id
     */
    private String autoId;

    public double getRecentBuyPrice() {
        return recentBuyPrice;
    }

    public void setRecentBuyPrice(double recentBuyPrice) {
        this.recentBuyPrice = recentBuyPrice;
    }

    public Object getRecentSellPrice() {
        return recentSellPrice;
    }

    public void setRecentSellPrice(double recentSellPrice) {
        this.recentSellPrice = recentSellPrice;
    }

	public String getAutoId() {
		return autoId;
	}

	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}

	public GoodsPO(String goodsID,String goodsCategory,String goodsName,String goodsType
			,double goodsBuyPrice,double goodsSellPrice,double recentBuyPrice,double recentSellPrice) {
		this.goodsID = goodsID;
		this.goodsCategory = goodsCategory;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsBuyPrice = goodsBuyPrice;
		this.goodsSellPrice = goodsSellPrice;
		this.recentBuyPrice = recentBuyPrice;
		this.recentSellPrice = recentSellPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsID() {
		return  goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setGoodsBuyPrice(double goodsBuyPrice) {
		this.goodsBuyPrice = goodsBuyPrice;
	}

	public void setGoodsSellPrice(double goodsSellPrice) {
		this.goodsSellPrice = goodsSellPrice;
	}

	public String getGoodsType() {
		return goodsType;
	}



	public double getGoodsBuyPrice() {
		return goodsBuyPrice;
	}

	public double getGoodsSellPrice() {
		return goodsSellPrice;
	}

	public double recentBuyPrice() {
		return recentBuyPrice;
	}

	public double recentSellPrice() {
		return recentSellPrice;
	}

	public void setGoodsName(String newGoodsName){
		this.goodsName = newGoodsName;
	}

}
