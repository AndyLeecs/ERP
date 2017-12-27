package bl.goodsbl;

import PO.GoodsPO;
import VO.goodsVO.GoodsVO;
import VO.storeVO.StoreVO;
import bl.storebl.Store_Interface;
import bl.storebl.Store_InterfaceImpl;
import dataService.goodsDataService.GoodsDataService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品的增删改查逻辑
 */
public class Goods {
    GoodsDataService goodsDataService = GoodsDataServiceHelper.getInstance().getGoodsDataService();

    public String newGoodsID(){
        return null;
    }

    public ArrayList<GoodsVO> findGoods(String info, String type) throws RemoteException {
        ArrayList<GoodsPO> findGoodsList = (ArrayList<GoodsPO>) goodsDataService.findGoods(info,type);
        ArrayList<GoodsVO> retFindGoodsList = new ArrayList<>();
        for(int i = 0;i<findGoodsList.size();i++){
            retFindGoodsList.add(poToVO(findGoodsList.get(i)));
        }
        return retFindGoodsList;
    }

    public GoodsVO getGoods(String name,String category) throws RemoteException {
       	//return goodsVO;//tmp try
        return poToVO(goodsDataService.getGoods(name,category));
    }

    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        goodsDataService.deleteGoods(category,name);
        return ResultMessage.SUCCESS;

    }

    public ResultMessage modifyGoods(GoodsVO vo) throws RemoteException{
        goodsDataService.modifyGoods(voToPO(vo));
        return ResultMessage.SUCCESS;

    }

    public ResultMessage initAndSaveGoods(GoodsVO vo) {
        try {
			goodsDataService.initAndSaveGoods(voToPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Store_Interface store_interface = new Store_InterfaceImpl();
        store_interface.addStoreItem(voToStoreVO(goodsVO));
        return ResultMessage.SUCCESS;

    }

    //用于未经初始化的商品信息
    GoodsVO goodsVO = new GoodsVO("0"
            ,"商品分类"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0);

    private StoreVO voToStoreVO(GoodsVO goodsVO){
        StoreVO storeVO = new StoreVO(goodsVO.getGoodsName(),goodsVO.getGoodsID(),5,0);
        return storeVO;
    }

    private GoodsPO voToPO(GoodsVO goodsVO){
        GoodsPO po = new GoodsPO(goodsVO.getGoodsID()
                ,goodsVO.getGoodsCategory()
                ,goodsVO.getGoodsName()
                ,goodsVO.getGoodsType()
                ,goodsVO.getGoodsBuyPrice()
                ,goodsVO.getGoodsSellPrice()
                ,goodsVO.recentBuyPrice()
                ,goodsVO.recentSellPrice()
                ,null
        );
        po.setAutoId(goodsVO.getAutoId());
        po.setState(goodsVO.getState());
        return po;
    }

    private GoodsVO poToVO(GoodsPO goodsPO){
        GoodsVO vo = new GoodsVO(goodsPO.getGoodsID()
                ,goodsPO.getGoodsCategory()
                ,goodsPO.getGoodsName()
                ,goodsPO.getGoodsType()
                ,goodsPO.getGoodsBuyPrice()
                ,goodsPO.getGoodsSellPrice()
                ,goodsPO.getRecentBuyPrice()
                ,goodsPO.getRecentSellPrice());
        vo.setAutoId(goodsPO.getAutoId());
        vo.setState(goodsPO.getState());
        return vo;
    }
}
