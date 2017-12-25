package VO.accountVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.State;

public class CollectionListVO extends FinanceListVO{
	private String VIPID;
	private String VIPName;
	private List<TransferItemVO> transferItem;
	
	
	public CollectionListVO(String listID, String VIPID, String VIPName, String operator, List<TransferItemVO> transferItem, double totalAmount, State state){
		setId(listID);
		this.VIPID = VIPID;
		this.VIPName = VIPName;
		setOperator(operator);
		this.transferItem = new ArrayList<TransferItemVO>(transferItem);
		setTotalAmount(totalAmount);
		setState(state);
//		setDay(day);
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
	
	public List<TransferItemVO> getTransferItem() {
		return new ArrayList<TransferItemVO>(transferItem);
	}
	public void setTransferItem(List<TransferItemVO> transferItem) {
		this.transferItem = new ArrayList<TransferItemVO>(transferItem);
	}
	
	
	
}
