package bl.goodsbl;

import PO.GoodsCategoryPO;
import VO.goodsVO.GoodsCategoryVO;
import dataService.goodsDataService.GoodsDataService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品分类的增删改查逻辑
 */
public class GoodsCategory {
    GoodsDataService goodsDataService = GoodsDataServiceHelper.getInstance().getGoodsDataService();

    public ResultMessage newGoodsCategory(GoodsCategoryVO vo){
        try {
			goodsDataService.newGoodsCategory(voToPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResultMessage.SUCCESS;

    }

    public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo) throws RemoteException{
        goodsDataService.deleteGoodsCategory(voToPO(vo));
        return ResultMessage.SUCCESS;

    }

    public ResultMessage modifyGoodsCategory(GoodsCategoryVO oldVO, GoodsCategoryVO newVO) throws RemoteException{
        goodsDataService.modifyGoodsCategory(voToPO(oldVO),voToPO(newVO));
        return ResultMessage.SUCCESS;

    }

    public ArrayList<String> getAllCategory(String node) throws RemoteException{
    	//加一行输出
    	System.out.println("bl.goodsbl.GoodsCategory 获取所有商品分类");
    	for(int i =0;i<goodsDataService.getAllCategory(node).size();i++) {
    		System.out.println(goodsDataService.getAllCategory(node).get(i));
    	}
        return (ArrayList<String>) goodsDataService.getAllCategory(node);
    }

    private GoodsCategoryPO voToPO(GoodsCategoryVO vo){
        return vo ==null?null:new GoodsCategoryPO(vo.getGoodsCategoryName(),vo.getParentName(),null);
    }

}
