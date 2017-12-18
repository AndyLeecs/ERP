package bl.goodsbl;

import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsBLServiceImpl implements GoodsBLService {
    GoodsDataServiceHelper goodsDataServiceHelper;
    Goods goods = new Goods();

    GoodsVO goodsVO1 = new GoodsVO("0"
            ,"1"
            ,"2"
            ,"3"
            ,4
            ,5
            ,6
            ,7);

    GoodsVO goodsVO2 = new GoodsVO("01"
            ,"11"
            ,"21"
            ,"31"
            ,41
            ,51
            ,61
            ,71);


    @Override
    public String newGoods(String name, String category) {
        return goods.newGoods(name,category);
    }

    @Override
    public List<GoodsVO> findGoods(String info, String type) {
        ArrayList<GoodsVO> goodsVOS = new ArrayList<>();
        goodsVOS.add(goodsVO1);
        goodsVOS.add(goodsVO2);
        return null;
    }

    @Override
    public GoodsVO getGoods(String name, String category) {
        return null;
    }
    
    @Override
    public ResultMessage deleteGoods(String category, String name) {
        return null;
    }

    @Override
    public ResultMessage modifyGoods(GoodsVO vo) {
        return null;
    }

    @Override
    public ResultMessage initAndSaveGoods(GoodsVO vo) {
        return null;
    }

    @Override
    public ResultMessage newGoodsCategory(String category, String parent) {
        return null;
    }

    @Override
    public ResultMessage deleteGoodsCategory(String category, String parent) {
        return null;
    }

    @Override
    public ResultMessage modifyGoodsCategory(String categoryNew, String categoryOld, String parent) {
        return null;
    }

    @Override
    public List getAllCategory(String node) {
        return null;
    }
}
