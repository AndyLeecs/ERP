package PO.account;

import java.util.ArrayList;
import java.util.List;

import util.State;

public class CollectionListPO extends FinanceListPO{
	private String VIPID;
	private String VIPName;
	private List<TransferItemPO> transferItem;
	
	
	public CollectionListPO(String listID, String VIPID, String VIPName, String operator, List<TransferItemPO> transferItem, double totalAmount, State state){
		setId(listID);
		this.VIPID = VIPID;
		this.VIPName = VIPName;
		setOperator(operator);
		this.transferItem = new ArrayList<TransferItemPO>(transferItem);
		setTotalAmount(totalAmount);
		setState(state);
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
	
	public List<TransferItemPO> getTransferItem() {
		return new ArrayList<TransferItemPO>(transferItem);
	}
	public void setTransferItem(List<TransferItemPO> transferItem) {
		this.transferItem = new ArrayList<TransferItemPO>(transferItem);
	}
	
	
	
}