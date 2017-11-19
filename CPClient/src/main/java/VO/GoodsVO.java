package VO;

public class GoodsVO {
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
	
	public GoodsVO(String a,String b,String c,String d,double f,double g,double h,double i) {
		goodsID = a;
		goodsCategory = b;
		goodsName = c;
		goodsType = d;
		goodsBuyPrice = f;
		goodsSellPrice = g;
		recentBuyPrice = h;
		recentSellPrice = i;
	}
	
	public String getGoods() {
		return  goodsID;
	}
	
	public String getGoodsCategory() {
		return goodsCategory;
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

}
