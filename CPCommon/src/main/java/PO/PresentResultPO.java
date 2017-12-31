package PO;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;


/**     
* @author 李安迪
* @date 2017年12月31日
* @description
*/
public class PresentResultPO implements Remote,Serializable{
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 策略id列表,点击id可以查看详情
	 */
	List<Integer> presentId;
//	/**
//	 * 价格折让
//	 */
//	double price_discount;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
//	/**
//	 * 特价商品列表
//	 */
//	List<GoodsInSaleVO> goodsList;
	/**
	 *赠品列表
	 */	
	List<GoodsInSalePO> presentList;
	/**
	 *使用赠送策略后总价
	 */	
	double sum;
	public List<Integer> getPresentId() {
		return presentId;
	}
	public void setPresentId(List<Integer> presentId) {
		this.presentId = presentId;
	}
//	public double getPrice_discount() {
//		return price_discount;
//	}
//	public void setPrice_discount(double price_discount) {
//		this.price_discount = price_discount;
//	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public List<GoodsInSalePO> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<GoodsInSalePO> presentList) {
		this.presentList = presentList;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public PresentResultPO(List<Integer> presentId, double voucher,
			List<GoodsInSalePO> presentList, double sum) {
		super();
		this.presentId = presentId;
//		this.price_discount = price_discount;
		this.voucher = voucher;
		this.presentList = presentList;
		this.sum = sum;
	}
	
	public PresentResultPO(){}
}
