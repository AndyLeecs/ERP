package ui.accountUI;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


class TransferItem{
	private final SimpleStringProperty account;
	private final SimpleDoubleProperty amount;
	private final SimpleStringProperty note;
	
	public TransferItem(String account, double amount, String note){
		this.account = new SimpleStringProperty(account);
		this.amount = new SimpleDoubleProperty(amount);
		this.note = new SimpleStringProperty(note);
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
	
}
