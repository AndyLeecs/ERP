package VO.VIPVO;

public class VIPVO {
      public String id; //编号
      public String category; //分类
      VIPGrade grade ; //级别
      String name ; //姓名
      String phoneNumber ;//电话号码
      String email ; //电子邮箱
      String address; //地址
      String locationID ; //邮编
      double collection;//应收
      double collection_limit ;//应收额度
      double payment  ; //应付
      String executive; // 默认业务员
      
      public VIPVO(String name,String phoneNumber,String email,String address,String locationID){
    	  this.address=address;
    	  this.email=email;
    	  this.phoneNumber=phoneNumber;
    	  this.name=name;
    	  this.locationID=locationID;
    	  
      }
      
      @Override
      public String toString() {
    	  String result = "ID:" + id + "Category:" + category + "Grade:" + grade + "Name:" + name + "PhoneNumber:" + phoneNumber + "email:" + email + "Address:" + address + "LocationID:" + locationID + "Collection:" + collection + "CollectionLimit:" + collection_limit + "Payment:" + payment + "Executive:" + executive;
		return result;
    	  
      }
      
//	public double getCollection() {
//		return collection;
//	}
//	public void setCollection(double collection) {
//		this.collection = collection;
//	}
//	public double getCollecton_limit() {
//		return collecton_limit;
//	}
//	public void setCollecton_limit(double collecton_limit) {
//		this.collecton_limit = collecton_limit;
//	}
//	public double getPayment() {
//		return payment;
//	}
//	public void setPayment(double payment) {
//		this.payment = payment;
//	}
//	public Grade getLevel() {
//		return grade;
//	}
//	public void setLevel(Grade grade) {
//		this.grade = grade;
//	}
      
}