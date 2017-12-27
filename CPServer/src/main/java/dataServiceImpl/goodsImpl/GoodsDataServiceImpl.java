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
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsName",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
                break;
            case "goodsType":
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsType",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
                break;
            case "goodsID":
                criterionClauseGenerator.generateFuzzyCriterion(l,"goodsID",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
                break;
        }
        return goodsUtil.Query(l);
    }

    @Override
    public GoodsPO getGoods(String name, String category) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"name",name);
        criterionClauseGenerator.generateFuzzyCriterion(l,"category",category);
        criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
        return goodsUtil.Query(l).get(0);//只需获取一个确切的商品信息 这里方法存疑
    }

    @Override
    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"name",name);
        criterionClauseGenerator.generateFuzzyCriterion(l,"category",category);
        criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
        goodsUtil.Query(l).get(0).setState(GoodsUtil.DELETE);
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
        GoodsCategoryPO goodsCategoryPO = (GoodsCategoryPO)(categoryUtil.get(po.getAutoId()));
        goodsCategoryPO.setState(GoodsUtil.DELETE);
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
//        criterionClauseGenerator.generateFuzzyCriterion(l,"state",GoodsUtil.EXIST);
        //GoodsUtil.DELETE.ordinal();
        //GoodsUtil.values()[GoodsUtil.DELETE.ordinal()];
        List<GoodsCategoryPO> list = categoryUtil.Query(l);
        //System.out.println(list.size());
        ArrayList<String> ret = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            ret.add(list.get(i).getGoodsCategoryName());
        }
        System.out.println("更改后的" + convertCharset(ret.get(0)));
        return ret;
    }
    public String convertCharset(String s) {  
        if (s != null) {  
            try {  
                int length = s.length();  
                byte[] buffer = new byte[length];  
                // 0x81 to Unicode 0x0081, 0x8d to 0x008d, 0x8f to 0x008f, 0x90  
                // to 0x0090, and 0x9d to 0x009d.  
                for (int i = 0; i < length; ++i) {  
                    char c = s.charAt(i);  
                    if (c == 0x0081) {  
                        buffer[i] = (byte) 0x81;  
                    } else if (c == 0x008d) {  
                        buffer[i] = (byte) 0x8d;  
                    } else if (c == 0x008f) {  
                        buffer[i] = (byte) 0x8f;  
                    } else if (c == 0x0090) {  
                        buffer[i] = (byte) 0x90;  
                    } else if (c == 0x009d) {  
                        buffer[i] = (byte) 0x9d;  
                    } else {  
                        buffer[i] = Character.toString(c).getBytes("CP1252")[0];  
                    }  
                }  
                String result = new String(buffer, "UTF-8");  
                return result;  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }
}