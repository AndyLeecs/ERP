package dataService.goodsDataService;
import PO.GoodsCategoryPO;
import PO.GoodsPO;
import util.ResultMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GoodsDataService extends Remote,Serializable {
    public String newGoodsID() throws RemoteException;
    public List<GoodsPO> findGoods(String info, String type) throws RemoteException;
    public GoodsPO getGoods(String name, String category) throws RemoteException;
    public ResultMessage deleteGoods(String category, String name) throws RemoteException;
    public ResultMessage modifyGoods(GoodsPO vo) throws RemoteException;
    public ResultMessage initAndSaveGoods(GoodsPO po) throws RemoteException;
    public ResultMessage newGoodsCategory(GoodsCategoryPO po) throws RemoteException;
    public ResultMessage deleteGoodsCategory(GoodsCategoryPO po) throws RemoteException;
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO oldVO,GoodsCategoryPO newVO) throws RemoteException;
    public List getAllCategory(String node) throws RemoteException;

}
