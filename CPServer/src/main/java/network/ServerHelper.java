package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.VIPDataService.VIPDataService;
import dataService.goodsDataService.GoodsDataService;
import dataService.listDataService.ListDataService;
import dataService.presentDataService.PresentDataService;
import dataService.presentDataService.PresentForMembershipDataService;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import dataService.presentDataService.PresentForSumDataService;
import dataService.saleDataService.SaleDataService;
import dataService.storeDataService.StoreDataService;
import dataServiceImpl.VIPImpl.VIPDataServiceImpl;
import dataServiceImpl.goodsImpl.GoodsDataServiceImpl;
import dataServiceImpl.listImpl.ListDataServiceImpl;
import dataServiceImpl.presentImpl.PresentDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForMembershipDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSpecialPackageDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;
import dataServiceImpl.stroreImpl.StoreDataServiceImpl;

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
