package dataService.accountDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.ListPO;
import util.DataRM;
import util.State;

public interface CommonListDataService extends Remote, Serializable{
	
	public String getNewListId() throws RemoteException;
	public DataRM insert(ListPO po) throws RemoteException;
	public DataRM delete(String id) throws RemoteException;
	public DataRM update(ListPO po) throws RemoteException;
	public List<ListPO> getList(State state) throws RemoteException;
	
	
}
