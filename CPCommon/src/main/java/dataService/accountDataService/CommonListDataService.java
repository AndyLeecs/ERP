package dataService.accountDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

import PO.ListPO;
import util.DataRM;
import util.State;

public interface CommonListDataService extends Remote, Serializable{
	
	public String getNewListId();
	public DataRM insert(ListPO po);
	public DataRM delete(String id);
	public DataRM update(ListPO po);
	public List<ListPO> getList(State state);
	
	
}
