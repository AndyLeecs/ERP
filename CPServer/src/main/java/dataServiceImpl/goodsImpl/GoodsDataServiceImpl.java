package dataServiceImpl.goodsImpl;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import dataHelper.BasicUtil;
import dataHelper.HibernateUtil;
import dataService.goodsDataService.GoodsDataService;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by julia98 on 2017/12/13.
 */
public class GoodsDataServiceImpl implements GoodsDataService {
    BasicUtil<GoodsPO> goodsUtil;
    BasicUtil<GoodsCategoryPO> categoryUtil;

    public GoodsDataServiceImpl() throws RemoteException {

        goodsUtil = new HibernateUtil<GoodsPO>(GoodsPO.class);
    }
    //要写一个生成商品id的方法
    @Override
    public String newGoodsID() {
        return null;
    }

    @Override
    public List findGoods(String info, String type) {
        switch (type){
            case "goodsName":
                break;
            case "goodsType":
                break;
            case "goodsID":
                break;
        }

        return goodsUtil.fuzzyQuery(info, type);
    }

    @Override
    public GoodsPO getGoods(String name, String category) {
        return goodsUtil.exactQuery(name,category).get(0);//只需获取一个确切的商品信息 这里方法存疑
    }

    @Override
    public ResultMessage deleteGoods(String category, String name) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyGoods(GoodsPO po) {
        goodsUtil.update(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage initAndSaveGoods(GoodsPO po) {
        goodsUtil.insert(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage newGoodsCategory(GoodsCategoryPO po) {
        categoryUtil.insert(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteGoodsCategory(GoodsCategoryPO po) {
        return null;
    }

    @Override
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO oldVO, GoodsCategoryPO newVO) {
        return null;
    }

    @Override
    public List getAllCategory(String node) {
        //if(node == "") 返回全部分类
        return categoryUtil.fuzzyQuery("parentName",node);
    }
}
