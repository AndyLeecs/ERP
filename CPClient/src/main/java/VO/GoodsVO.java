package VO;

public class GoodsVO {
	String goodsID;
	String goodsSort;
	String goodsName;
	String goodsType;
	String goodsCode;
	double goodsBuyPrice;
	double goodsSellPrice;
	double recentBuyPrice;
	double recentSellPrice;
	
	public GoodsVO(String a,String b,String c,String d,String e,double f,double g,double h,double i) {
		goodsID = a;
		goodsSort = b;
		goodsName = c;
		goodsType = d;
		goodsCode = e;
		goodsBuyPrice = f;
		goodsSellPrice = g;
		recentBuyPrice = h;
		recentSellPrice = i;
	}
	
	public String getGoods() {
		return  goodsID;
	}
	
	public String getGoodsSort() {
		return goodsSort;
	}
	
	public String getGoodsType() {
		return goodsType;
	}
	
	public String getGoodsCode() {
		return goodsCode;
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
