package dataService.accountDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.ListPO;
import resultmessage.DataRM;
import util.State;

public interface CommonListDataService extends Remote{
	
	public String getNewListId() throws RemoteException;
	public DataRM insert(ListPO po) throws RemoteException;
	public DataRM delete(String id) throws RemoteException;
	public DataRM update(ListPO po) throws RemoteException;
	public List<? extends ListPO> getList(State state) throws RemoteException;
	public ListPO getList(String id) throws RemoteException;
	
	
}
