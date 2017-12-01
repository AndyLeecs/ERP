package dataServiceImpl_ClientRMI;
import DataService_RMI.StoreDataService;

import java.net.MalformedURLException;
import java.rmi.*;
public class StoreDataServiceImpl implements  StoreDataService {
    //王瑞华制作。
    private StoreDataService storeDataService;
    String url = "rmi://localhost:1099/";
    public  StoreDataServiceImpl(){
              //构造方法，在初次调用时建立远程连接。url 可以在main方法里设为全局变量
        try {
            storeDataService=(StoreDataService)Naming.lookup(url+"StoreDataService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
