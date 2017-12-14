package PO;

import java.io.Serializable;

public class VIPPO implements Serializable{

    public String id; //编号
    public String category; //分类
    int grade ; //级别
    String name ; //姓名
    String phoneNumber ;//电话号码
    String email ; //电子邮箱
    String address; //地址
    String locationID ; //邮编
    double  collection;//应收
    double collecton_limit ;//应收额度
    double payment  ; //应付
    String executive; // 默认业务员
    private String autoId; //数据库自动生成的id

    public VIPPO() {
    }

	public VIPPO(String name,String phoneNumber,String email,String address,String locationID){
  	  this.address=address;
   	  this.email=email;
  	  this.phoneNumber=phoneNumber;
  	  this.name=name;
  	  this.locationID=locationID;

    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
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

    public String getExecutive() {
        return executive;
    }

    public void setExecutive(String executive) {
        this.executive = executive;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }
      
}
