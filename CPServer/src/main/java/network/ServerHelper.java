package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.VIPDataService.VIPDataService;
import dataService.goodsDataService.GoodsDataService;
import dataService.presentDataService.PresentDataService;
import dataService.presentDataService.PresentForSumDataService;
import dataService.saleDataService.SaleDataService;
import dataService.storeDataService.StoreDataService;
import dataServiceImpl.VIPImpl.VIPDataServiceImpl;
import dataServiceImpl.goodsImpl.GoodsDataServiceImpl;
import dataServiceImpl.presentImpl.PresentDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;
import dataServiceImpl.saleImpl.SaleDataServiceImpl;
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
			
			StoreDataService storeDataService=new StoreDataServiceImpl();
			Naming.bind("StoreDataService", storeDataService);
			System.out.println("bind succeeded!");

			PresentDataService presentDataService=new PresentDataServiceImpl();
			Naming.bind("PresentDataService", presentDataService);
			System.out.println("bind succeeded!");
			
			PresentForSumDataService presentForSumDataService = new PresentForSumDataServiceImpl();
			Naming.bind("PresentForSumDataService", presentForSumDataService);
			
//			SaleDataService saleDataService=new SaleDataServiceImpl();
//			Naming.bind("SaleDataService", saleDataService);
//			System.out.println("bind succeeded!");
//
//			GoodsDataService goodsDataService=new GoodsDataServiceImpl();
//			Naming.bind("goodsDateService",goodsDataService);
//			System.out.println("bind succeeded!");
//
//			VIPDataService vipDataService=new VIPDataServiceImpl();
//			Naming.bind("VIPDataService",vipDataService);
//			System.out.println("bind succeeded!");
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
