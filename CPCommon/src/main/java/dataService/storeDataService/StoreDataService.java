package dataService.storeDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.State;
import PO.StorePO;
import util.StoreListType;
public interface StoreDataService extends Remote,Serializable{
  public boolean checkID(String id);//检查某个库存项目ID 是否存在
  public StorePO getStorePO(String id);//把单个库存项抓上来，不存在的话返回NULL(检查过ID，所以其实不会不存在)
  public String calcID(StoreListType lt);//根据不同的单据类型，计算单据编号
  public LinkedList<AlarmListPO> getAlarmListPO();
}
