package dataServiceImpl.goodsImpl;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import dataHelper.*;
import dataService.goodsDataService.GoodsDataService;
import util.GoodsUtil;
import util.ResultMessage;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/13.
 */
public class GoodsDataServiceImpl extends UnicastRemoteObject implements GoodsDataService {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9102837563714201639L;
	BasicUtil<GoodsPO> goodsUtil;
    BasicUtil<GoodsCategoryPO> categoryUtil;
    CriterionClauseGenerator criterionClauseGenerator;

    public GoodsDataServiceImpl() throws RemoteException {
        goodsUtil = new HibernateUtil<GoodsPO>(GoodsPO.class);
        categoryUtil = new HibernateUtil<GoodsCategoryPO>(GoodsCategoryPO.class);
        criterionClauseGenerator = new HibernateCriterionClauseGenerator();
    }

    @Override
    public String newGoodsID() throws RemoteException{
        return ""+goodsUtil.insertForAuto(new GoodsPO());
    }

    @Override
    public List findGoods(String info, String type) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        switch (type){
            case "goodsName":
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsName",info);
                criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
                break;
            case "goodsType":
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsType",info);
                criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
                break;
            case "goodsID":
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsID",info);
                criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
                break;
        }
        return goodsUtil.Query(l);
    }

    @Override
    public GoodsPO getGoods(String name, String category) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"goodsName",name);
        criterionClauseGenerator.generateFuzzyCriterion(l,"goodsCategory",category);
        criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
        GoodsPO po = goodsUtil.Query(l).get(goodsUtil.Query(l).size()-1);
        System.out.println(po.getState());
        return po;//只需获取一个确切的商品信息 这里方法存疑
    }

    @Override
    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"goodsName",name);
        criterionClauseGenerator.generateFuzzyCriterion(l,"goodsCategory",category);
        criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
        GoodsPO po = goodsUtil.Query(l).get(goodsUtil.Query(l).size()-1);
        po.setState(GoodsUtil.DELETE);
        modifyGoods(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyGoods(GoodsPO po) throws RemoteException{
        goodsUtil.update(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage initAndSaveGoods(GoodsPO po) throws RemoteException{
        po.setState(GoodsUtil.EXIST);
        goodsUtil.insert(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage newGoodsCategory(GoodsCategoryPO po) throws RemoteException{
    	po.setState(GoodsUtil.EXIST);
        categoryUtil.insert(po);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteGoodsCategory(GoodsCategoryPO po) throws RemoteException{
    	System.out.println(po.getAutoId());
        GoodsCategoryPO goodsCategoryPO = (GoodsCategoryPO)(categoryUtil.get(po.getAutoId()));
        goodsCategoryPO.setState(GoodsUtil.DELETE);
        modifyGoodsCategory(null,goodsCategoryPO);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO oldPO, GoodsCategoryPO newPO) throws RemoteException{
        categoryUtil.update(newPO);
        return ResultMessage.SUCCESS;
    }

    @Override
    public List getAllCategory(String node) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"parentName",node);
        criterionClauseGenerator.generateExactCriterion(l,"state",GoodsUtil.EXIST);
        List<GoodsCategoryPO> list = categoryUtil.Query(l);
        //System.out.println(list.size());
        //ArrayList<String> ret = new ArrayList<>();
        //for(int i =0;i<list.size();i++){
         //   ret.add(list.get(i).getGoodsCategoryName());
        //}
        return list;
    }
}