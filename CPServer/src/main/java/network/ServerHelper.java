package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.VIPDataService.VIPDataService;
import dataService.accountDataService.CollectionListDataService;
import dataService.goodsDataService.GoodsDataService;
import dataService.presentDataService.PresentDataService;
import dataService.presentDataService.PresentForMembershipDataService;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import dataService.presentDataService.PresentForSumDataService;
import dataServiceImpl.VIPImpl.VIPDataServiceImpl;
import dataServiceImpl.accountImpl.CollectionListDataServiceImpl;
import dataServiceImpl.goodsImpl.GoodsDataServiceImpl;
import dataServiceImpl.presentImpl.PresentDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForMembershipDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSpecialPackageDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;

public class ServerHelper {
	public int port = 1099;
	
	public ServerHelper(){
		initServer();
	}
	
	private void initServer(){
		try {
			LocateRegistry.createRegistry(port);
			System.out.println("successful connection");
			

//			StoreDataService storeDataService=new StoreDataServiceImpl();
//			Naming.bind("StoreDataService", storeDataService);
//			System.out.println("bind succeeded!");

//			ListDataService listDataService=new ListDataServiceImpl();
//			Naming.bind("ListDataService",listDataService);
//			System.out.println("表单类数据库绑定成功！");
			
			CollectionListDataService collectionListDataService = new CollectionListDataServiceImpl();
			Naming.bind("CollectionListDataService", collectionListDataService);
			System.out.println("CollectionListDataService bind Succeed");


			PresentDataService presentDataService=new PresentDataServiceImpl();
			Naming.bind("PresentDataService", presentDataService);
			System.out.println("bind succeeded!");
			
			PresentForSumDataService presentForSumDataService = new PresentForSumDataServiceImpl();
			Naming.bind("PresentForSumDataService", presentForSumDataService);
	
			PresentForMembershipDataService presentForMembershipDataService = new PresentForMembershipDataServiceImpl();
			Naming.bind("PresentForMembershipDataService", presentForMembershipDataService);
			
			PresentForSpecialPackageDataService presentForSpecialPackageDataService = new PresentForSpecialPackageDataServiceImpl();
			Naming.bind("PresentForSpecialPackageDataService", presentForSpecialPackageDataService);
//			SaleDataService saleDataService=new SaleDataServiceImpl();
//			Naming.bind("SaleDataService", saleDataService);
//			System.out.println("bind succeeded!");
//
			GoodsDataService goodsDataService=new GoodsDataServiceImpl();
			Naming.bind("GoodsDataService",goodsDataService);
			System.out.println("bind succeeded!");
//
			VIPDataService vipDataService=new VIPDataServiceImpl();
			Naming.bind("VIPDataService",vipDataService);
			System.out.println("bind succeeded!");
			//所有的service都要在这里绑定一下
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String []args){
		new ServerHelper();
	}
	
}
