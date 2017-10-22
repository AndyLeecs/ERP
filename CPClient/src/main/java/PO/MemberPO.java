package PO;

public class MemberPO {
      public String id; //编号
public String category; //分类
      private int level ; //级别
      public String name ; //姓名
      public String phoneNumber ;//电话号码
      public String email ; //电子邮箱
      public String address; //地址
      public String locationID ; //邮编
      private double collection;//应收
      private double collecton_limit ;//应收额度
      private double payment  ; //应付
      public MemberPO(String name,String phoneNumber,String email,String address,String locationID){
    	  this.address=address;
    	  this.email=email;
    	  this.phoneNumber=phoneNumber;
    	  this.name=name;
    	  this.locationID=locationID;
    	  
      }
	public double getCollection() {
		return collection;
	}
	public void setCollection(double collection) {
		this.collection = collection;
	}
	public double getCollecton_limit() {
		return collecton_limit;
	}
	public void setCollecton_limit(double collecton_limit) {
		this.collecton_limit = collecton_limit;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
      
}
