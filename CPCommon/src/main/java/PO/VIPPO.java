package PO;

import java.io.Serializable;

public class VIPPO implements Serializable{
      public String id; //编号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String category; //分类

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    int grade ; //级别

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    String name ; //姓名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String phoneNumber ;//电话号码

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String email ; //电子邮箱

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String address; //地址

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String locationID ; //邮编

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    double  collection;//应收

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    double collecton_limit ;//应收额度

    public double getCollecton_limit() {
        return collecton_limit;
    }

    public void setCollecton_limit(double collecton_limit) {
        this.collecton_limit = collecton_limit;
    }

    double payment  ; //应付

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    String executive; // 默认业务员

    public String getExecutive() {
        return executive;
    }

    public void setExecutive(String executive) {
        this.executive = executive;
    }

    private String autoId; //数据库自动生成的id

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }
    public MemberPO(String name,String phoneNumber,String email,String address,String locationID){
    	  this.address=address;
     	  this.email=email;
    	  this.phoneNumber=phoneNumber;
    	  this.name=name;
    	  this.locationID=locationID;

      }
      
}
