package PO;

import java.io.Serializable;
import java.util.Date;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class StorePO  implements Serializable{
	/**
     * 商品编号	
    */
	String id;
	/**
     * 商品名称
    */	
	String name;
	/**
     * 商品型号
    */
	String type;
	/**
     * 库存数量
    */
	int storeNumber;
	/**
     * 库存均价
    */
	double storeAveragePrice;
//批次批号好像取消了
	/**
//     *批次	
//    */
//	int batch;
//	/**
//     * 批号
//    */
//	String lotNumber;
	/**
     * 出厂日期	
    */
	Date releaseDate;
	/**
     * 警戒数量	
    */
	int alertNumber;
//		public StoreVO(String id, String name, String type, int number, double averagePrice, int batch,
//				String lotNumber, Date date, int alertNumber) {
//			super();
//			this.id = id;
//			this.name = name;
//			this.type = type;
//			this.number = number;
//			this.averagePrice = averagePrice;
//			this.batch = batch;
//			this.lotNumber = lotNumber;
//			this.date = date;
//			this.alertNumber = alertNumber;
//		}
//		public String getId() {
//			return id;
//		}
//		public void setId(String id) {
//			this.id = id;
//		}
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public String getType() {
//			return type;
//		}
//		public void setType(String type) {
//			this.type = type;
//		}
//		public int getNumber() {
//			return number;
//		}
//		public void setNumber(int number) {
//			this.number = number;
//		}
//		public double getAveragePrice() {
//			return averagePrice;
//		}
//		public void setAveragePrice(double averagePrice) {
//			this.averagePrice = averagePrice;
//		}
//		public int getBatch() {
//			return batch;
//		}
//		public void setBatch(int batch) {
//			this.batch = batch;
//		}
//		public String getLotNumber() {
//			return lotNumber;
//		}
//		public void setLotNumber(String lotNumber) {
//			this.lotNumber = lotNumber;
//		}
//		public Date getDate() {
//			return date;
//		}
//		public void setDate(Date date) {
//			this.date = date;
//		}
//	public int getAlertNumber() {
//		return alertNumber;
//	}
//	public void setAlertNumber(int alertNumber) {
//		this.alertNumber = alertNumber;
//	}
//	    
}
