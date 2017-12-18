package bl.goodsbl;

import dataService.goodsDataService.GoodsDataService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品分类的增删改查逻辑
 */
public class GoodsCategory {
    GoodsDataService goodsDataService = GoodsDataServiceHelper.getInstance().getGoodsDataService();

    public ResultMessage newGoodsCategory(String category, String parent){
        goodsDataService.newGoodsCategory(category);
        return ResultMessage.SUCCESS;

    }

    public ResultMessage deleteGoodsCategory(String category, String parent){
        goodsDataService.deleteGoodsCategory(category);
        return ResultMessage.SUCCESS;

    }

    public ResultMessage modifyGoodsCategory(String categoryNew,String categoryOld, String parent){
        goodsDataService.modifyGoodsCategory(categoryNew, categoryOld);
        return ResultMessage.SUCCESS;

    }

    public ArrayList<String> getAllCategory(String node){
        return (ArrayList<String>) goodsDataService.getAllCategory(node);
    }
}
