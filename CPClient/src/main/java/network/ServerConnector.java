package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.user.MessagePO;
import PO.user.UserPO;
import network.accountRemoteHelper.AccountDataServiceHelper;
import network.accountRemoteHelper.CashExpenseListDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;
import network.saleRemoteHelper.SaleListDataServiceHelper;
import network.saleRemoteHelper.SaleProjectionDataServiceHelper;
import network.saleRemoteHelper.SaleReturnListDataServiceHelper;
import network.saleRemoteHelper.StockListDataServiceHelper;
import network.userRemoteHelper.MessageDataServiceHelper;
import network.userRemoteHelper.UserDataServiceHelper;
import util.DateUtil;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

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
		insertAdmin();
	}
	
	private void addServices(){
//		dataServiceHelpers.add(StoreDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
		
		dataServiceHelpers.add(AccountDataServiceHelper.getInstance());
		dataServiceHelpers.add(CollectionListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
		dataServiceHelpers.add(CashExpenseListDataServiceHelper.getInstance());
		
		dataServiceHelpers.add(UserDataServiceHelper.getInstance());
		dataServiceHelpers.add(MessageDataServiceHelper.getInstance());
		
//		dataServiceHelpers.add(PresentForMembershipDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PresentForSpecialPackageDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSumDataServiceHelper.getInstance());
//		
//		
//		dataServiceHelpers.add(GoodsDataServiceHelper.getInstance());
//		dataServiceHelpers.add(VIPDataServiceHelper.getInstance());
//		dataServiceHelpers.add(StockReturnListDataServiceHelper.getInstance());
		dataServiceHelpers.add(StockListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleReturnListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleProjectionDataServiceHelper.getInstance());

		
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
//		testService();
	}
	
	
	//TODO delete it when bl finish!
	public static void testService(){
		UserType type = UserType.Stockman;
		MessagePO po = new MessagePO("进货", "进100个小灯", DateUtil.getDate("20171230"), type);
		try {
//			System.out.println(MessageDataServiceHelper.getInstance().getDataService().insert(po));
			System.out.println(MessageDataServiceHelper.getInstance().getDataService().getAllMessage(type).get(2).getContent());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertAdmin(){
		UserPO po = new UserPO();
		po.setName("admin");
		po.setPassword("123");
		po.setType(UserType.Administrator);
		po.setGrade(UserGrade.Manager);
		po.setPermission(UserPermission.Highest);
		try {
			System.out.println(UserDataServiceHelper.getInstance().getDataService().insert(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
