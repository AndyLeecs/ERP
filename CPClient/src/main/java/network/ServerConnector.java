package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import bl.presentbl.PresentForSumBLServiceImpl;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;

/**
 * 连接服务器的类，在这里将每个DataService与对应的RemoteHelper进行连接
 * 
 *
 */
public class ServerConnector {
	String url = "rmi://localhost:1099/";
	
	List<DataServiceHelper> dataServiceHelpers = new ArrayList<DataServiceHelper>();
	
	public ServerConnector(){
		addServices();
		connectDataService();
	}
	
	private void addServices(){
//		dataServiceHelpers.add(StoreDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PresentForMembershipDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PresentForSpecialPackageDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSumDataServiceHelper.getInstance());
//		dataServiceHelpers.add(GoodsDataServiceHelper.getInstance());
//		dataServiceHelpers.add(VIPDataServiceHelper.getInstance());
		
		//哈哈，巧妙的设计了一番，每个helper只需在这里add一下就行了
	}
	
	private void connectDataService(){
		
		for(DataServiceHelper helper : dataServiceHelpers){
			String serviceName = helper.getServiceName();
			
			try {
				helper.setRemote(Naming.lookup(url+serviceName));
				System.out.println(serviceName + " connected");
			} catch (MalformedURLException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			} catch (NotBoundException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String [] args){
		new ServerConnector();
	}
}
