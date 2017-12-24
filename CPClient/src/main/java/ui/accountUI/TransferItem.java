package ui.accountUI;

import VO.accountVO.TransferItemVO;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TransferItem{
	private final SimpleStringProperty account;
	private final SimpleDoubleProperty amount;
	private final SimpleStringProperty note;
	private final SimpleBooleanProperty deleted;
	
	public TransferItem(String account, double amount, String note, boolean deleted){
		this.account = new SimpleStringProperty(account);
		this.amount = new SimpleDoubleProperty(amount);
		this.note = new SimpleStringProperty(note);
		this.deleted = new SimpleBooleanProperty(deleted);
	}

	public String getAccount() {
		return account.get();
	}
	
	public void setAccount(String account){
		this.account.set(account);
	}
	
	public double getAmount(){
		return amount.get();
	}
	
	public void setAmount(double amount){
		this.amount.set(amount);
	}
	
	public String getNote(){
		return note.get();
	}
	
	public void setNote(String note){
		this.note.set(note);
	}
	
	public Boolean getDeleted(){
		return deleted.get();
	}
	
	public void setDeleted(boolean deleted){
		this.deleted.set(deleted);
	}
	
	public TransferItemVO toVO(){
		return new TransferItemVO(account.get(),amount.get(),note.get());
	}
	
}
