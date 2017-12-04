package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import network.accountRemoteHelper.PaymentListDataServiceHelper;
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
	
	List<DataServiceHelper> dataServiceHelpers = new ArrayList<DataServiceHelper>();
	
//	StoreDataServiceHelper storeDataServiceHelper;
//	SaleDataServiceHelper saleDataServiceHelper;		//安迪你的这两个再自己写一下吧，我就不帮你写啦，记得实现接口哦～
//	PresentDataServiceHelper presentDataServiceHelper;
//	PaymentListDataServiceHelper paymentListDataServiceHelper;
	
	public ServerConnector(){
		addServices();
		connectStoreDataService();
	}
	
	private void addServices(){
		dataServiceHelpers.add(StoreDataServiceHelper.getInstance());
		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentDataServiceHelper.getInstance());		
		//哈哈，巧妙的设计了一番，每个helper只需在这里add一下就行了
	}
	
	private void connectStoreDataService(){
		
		for(DataServiceHelper helper : dataServiceHelpers){
			String serviceName = helper.getServiceName();
			
			try {
				helper.setRemote(Naming.lookup(url+serviceName));
			} catch (MalformedURLException e) {
				System.out.println(serviceName + "connectedFailed");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println(serviceName + "connectedFailed");
				e.printStackTrace();
			} catch (NotBoundException e) {
				System.out.println(serviceName + "connectedFailed");
				e.printStackTrace();
			}
			
		}
		
//		storeDataServiceHelper = StoreDataServiceHelper.getInstance();
//		saleDataServiceHelper = SaleDataServiceHelper.getInstance();
//		presentDataServiceHelper = PresentDataServiceHelper.getInstance();
//		paymentListDataServiceHelper = PaymentListDataServiceHelper.getInstance();
//		try {
//			storeDataServiceHelper.setRemote(Naming.lookup(url+"StoreDataService"));
//			saleDataServiceHelper.setRemote(Naming.lookup(url+"SaleDataService"));
//			presentDataServiceHelper.setRemote(Naming.lookup(url+"PresentDataService"));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			e.printStackTrace();
//		}
//		


	}
}
