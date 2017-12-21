package dataService.goodsDataService;
import PO.GoodsCategoryPO;
import PO.GoodsPO;
import util.ResultMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GoodsDataService extends Remote,Serializable {
    public String newGoods(String name,String category);
    public List<GoodsPO> findGoods(String info, String type);
    public GoodsPO getGoods(String name, String category);
    public ResultMessage deleteGoods(String category, String name);
    public ResultMessage modifyGoods(GoodsPO vo);
    public ResultMessage initAndSaveGoods(GoodsPO vo);
    public ResultMessage newGoodsCategory(GoodsCategoryPO po);
    public ResultMessage deleteGoodsCategory(GoodsCategoryPO po);
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO oldVO,GoodsCategoryPO newVO);
    public List getAllCategory(String node);

}
