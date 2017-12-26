package bl.goodsbl;

import VO.goodsVO.GoodsCategoryVO;
import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsBLServiceImpl implements GoodsBLService {
    GoodsDataServiceHelper goodsDataServiceHelper;
    Goods goods = new Goods();
    GoodsCategory goodsCategory = new GoodsCategory();

    GoodsVO goodsVO1 = new GoodsVO("00000001"
            ,"分类1"
            ,"名称1"
            ,"类型1"
            ,100
            ,200
            ,100
            ,200);

    GoodsVO goodsVO2 = new GoodsVO("00000002"
            ,"分类2"
            ,"名称2"
            ,"类型2"
            ,100
            ,200
            ,100
            ,200);


    @Override
    public String newGoodsID() {
        return goods.newGoodsID();
    }

    @Override
    public List<GoodsVO> findGoods(String info, String type) {
        ArrayList<GoodsVO> goodsVOS = new ArrayList<>();
        goodsVOS.add(goodsVO1);
        goodsVOS.add(goodsVO2);
        return goodsVOS;
        //return goods.findGoods(info, type);
    }

    @Override
    public GoodsVO getGoods(String name, String category) {
        return goods.getGoods(name, category);
    }
    
    @Override
    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        return goods.deleteGoods(category, name);
    }

    @Override
    public ResultMessage modifyGoods(GoodsVO vo) {
        return goods.modifyGoods(vo);
    }

    @Override
    public ResultMessage initAndSaveGoods(GoodsVO vo) {
        return goods.initAndSaveGoods(vo);
    }

    @Override
    public ResultMessage newGoodsCategory(GoodsCategoryVO vo) {
        return goodsCategory.newGoodsCategory(vo);
    }

    @Override
    public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo) {
        return goodsCategory.deleteGoodsCategory(vo);
    }

    @Override
    public ResultMessage modifyGoodsCategory(GoodsCategoryVO oldVO, GoodsCategoryVO newVO) {
        return goodsCategory.modifyGoodsCategory(oldVO, newVO);
    }

    @Override
    public List getAllCategory(String node) throws RemoteException {
        return goodsCategory.getAllCategory(node);
    }
}
