package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import network.storeRemoteHelper.StoreDataServiceHelper;

/**
 * 连接服务器的类，在这里将每个DataService与对应的RemoteHelper进行连接
 * 
 *
 */
public class ServerConnector {
	String url = "rmi://localhost:1099/";
	
	StoreDataServiceHelper storeDataServiceHelper;
	
	public ServerConnector(){
		connectStoreDataService();
	}
	
	private void connectStoreDataService(){
		storeDataServiceHelper = StoreDataServiceHelper.getInstance();
		try {
			storeDataServiceHelper.setRemote(Naming.lookup(url+"StoreDataService"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
