package VO.listVO;

public class SalesDetailListVO {
	//销售明细表
	public String day;
	public String goodsName;
	public String model;//型号
	public int num;//数量
	public double  price ; //单价

	public double  sum;//总额（折让前）
	
	public SalesDetailListVO(String day,String goodsName ,String model,int num,double price){
		this.day=day;
		this.goodsName=goodsName;
		this.model=model;
		this.num=num;
		this.price=price;
		sum=num*price;
		
	}
	
	
}
