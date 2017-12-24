package VO.accountVO;

import java.util.ArrayList;
import java.util.List;

public class CollectionListVO extends FinanceListVO{
	private String listID;
	private String VIPID;
	private String VIPName;
	private String operator;
	private List<TransferItemVO> transferItem;
	private double totalAmount;
	
	public CollectionListVO(String listID, String VIPID, String VIPName, String operator, List<TransferItemVO> transferItem, double totalAmount){
		this.listID = listID;
		this.VIPID = VIPID;
		this.VIPName = VIPName;
		this.operator = operator;
		this.transferItem = new ArrayList<TransferItemVO>(transferItem);
		this.totalAmount = totalAmount;
	}
	
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getVIPID() {
		return VIPID;
	}
	public void setVIPID(String vIPID) {
		VIPID = vIPID;
	}
	public String getVIPName() {
		return VIPName;
	}
	public void setVIPName(String vIPName) {
		VIPName = vIPName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<TransferItemVO> getTransferItem() {
		return new ArrayList<TransferItemVO>(transferItem);
	}
	public void setTransferItem(List<TransferItemVO> transferItem) {
		this.transferItem = new ArrayList<TransferItemVO>(transferItem);
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
}
