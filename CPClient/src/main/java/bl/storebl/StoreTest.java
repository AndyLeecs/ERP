package bl.storebl;

import VO.storeVO.StoreVO;
import network.ServerConnector;

public class StoreTest {
DataGetter getter=new DataGetter();
DataSetter setter=new DataSetter();
StoreblController controller=new StoreblController();
	public static void main(String[] args) {
		ServerConnector sc=new ServerConnector();
		StoreTest test=new StoreTest();
            StoreVO vo=new StoreVO("测试_小灯佩奇","G2",10,100);
            vo.averagePrice=25;
            test.setter.insertStoreVO(vo);
	}

}
