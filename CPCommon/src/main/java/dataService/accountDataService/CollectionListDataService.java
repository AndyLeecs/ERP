package dataService.accountDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

import PO.account.CollectionListPO;
import util.DataRM;
import util.State;

public interface CollectionListDataService extends Remote, Serializable{
	
	public String getNewCollectionListId();
	public DataRM insert(CollectionListPO po);
	public DataRM deleteCollectionList(String id);
	public DataRM update(CollectionListPO po);
	public List<CollectionListPO> getCollectionList(State state);
	
	
}
