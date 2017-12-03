package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import network.presentRemoteHelper.PresentDataServiceHelper;
import network.saleRemoteHelper.SaleDataServiceHelper;
import network.storeRemoteHelper.StoreDataServiceHelper;

/**
 * 连接服务器的类，在这里将每个DataService与对应的RemoteHelper进行连接
 * 
 *
 */
public class ServerConnector {
	String url = "rmi://localhost:1099/";
	
	StoreDataServiceHelper storeDataServiceHelper;
	SaleDataServiceHelper saleDataServiceHelper;
	PresentDataServiceHelper presentDataServiceHelper;
	
	public ServerConnector(){
		connectStoreDataService();
	}
	
	private void connectStoreDataService(){
		storeDataServiceHelper = StoreDataServiceHelper.getInstance();
		saleDataServiceHelper = SaleDataServiceHelper.getInstance();
		presentDataServiceHelper = PresentDataServiceHelper.getInstance();
		
		try {
			storeDataServiceHelper.setRemote(Naming.lookup(url+"StoreDataService"));
			saleDataServiceHelper.setRemote(Naming.lookup(url+"SaleDataService"));
			presentDataServiceHelper.setRemote(Naming.lookup(url+"PresentDataService"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
