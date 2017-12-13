package dataServiceImpl.goodsImpl;

import PO.GoodsPO;
import dataService.goodsDataService.GoodsDataService;
import util.ResultMessage;

import java.util.List;

/**
 * Created by julia98 on 2017/12/13.
 */
public class GoodsDataServiceImpl implements GoodsDataService {
    @Override
    public String newGoods(String name, String category) {
        return null;
    }

    @Override
    public List findGoods(String info, String type) {
        return null;
    }

    @Override
    public GoodsPO getGoods(String name, String category) {
        return null;
    }

    @Override
    public ResultMessage deleteGoods(String category, String name) {
        return null;
    }

    @Override
    public ResultMessage modifyGoods(GoodsPO vo) {
        return null;
    }

    @Override
    public ResultMessage initAndSaveGoods(GoodsPO vo) {
        return null;
    }

    @Override
    public ResultMessage newGoodsCategory(String category) {
        return null;
    }

    @Override
    public ResultMessage deleteGoodsCategory(String category) {
        return null;
    }

    @Override
    public ResultMessage modifyGoodsCategory(String categoryNew, String categoryOld) {
        return null;
    }

    @Override
    public List getAllCategory() {
        return null;
    }
}
