package dataServiceImpl.goodsImpl;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClauseGenerator;
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
    CriterionClauseGenerator criterionClauseGenerator;

    public GoodsDataServiceImpl() throws RemoteException {

        goodsUtil = new HibernateUtil<GoodsPO>(GoodsPO.class);
        categoryUtil = new HibernateUtil<GoodsCategoryPO>(GoodsCategoryPO.class);
    }
    //要写一个生成商品id的方法
    @Override
    public String newGoodsID() {
        return ""+goodsUtil.insertForAuto(new GoodsPO("","","","",0,0,0,0));
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

        return null;
    }

    @Override
    public GoodsPO getGoods(String name, String category) {
        return goodsUtil.exactQuery(name,category).get(0);//只需获取一个确切的商品信息 这里方法存疑
    }

    @Override
    public ResultMessage deleteGoods(String category, String name) {
        //这里没找到删除数据的操作
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyGoods(GoodsPO po) {
        //这里更新商品信息的思路就是用现有新信息找到id 然后删掉原来的 插入现在的数据 不过还不知道这个update方法是不是已经做了我想做的事情
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
        //这里没有找到删除数据的方法
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO oldPO, GoodsCategoryPO newPO) {
        //更新数据是这个操作么
        categoryUtil.update(newPO);
        return null;
    }

    @Override
    public List getAllCategory(String node) {
        //if(node == "") 返回全部分类 需求是新建分类时判断重复
        return categoryUtil.fuzzyQuery("parentName",node);
    }
}
