package dataServiceImpl.goodsImpl;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;
import util.GoodsUtil;
import util.ResultMessage;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by julia98 on 2017/12/26.
 */
public class GoodsDataServiceImplTest {
    GoodsCategoryPO po = new GoodsCategoryPO("水晶灯","根节点",GoodsUtil.EXIST.ordinal());
    GoodsCategoryPO po2 = new GoodsCategoryPO("豪华水晶灯2","水晶灯",GoodsUtil.EXIST.ordinal());
    GoodsCategoryPO po3 = new GoodsCategoryPO("节能灯1","根节点",GoodsUtil.EXIST.ordinal());
    GoodsCategoryPO po4 = new GoodsCategoryPO("123a","abc",GoodsUtil.EXIST.ordinal());
    GoodsPO goodsPO = new GoodsPO("0"
            ,"商品分类"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0,GoodsUtil.EXIST);
    List<GoodsCategoryPO> poList;
    
    @org.junit.Test
    public void newGoodsID() throws Exception {
    	//new GoodsDataServiceImpl().newGoodsID();
    //	assertEquals("",new GoodsDataServiceImpl().newGoodsID());
    }

    @org.junit.Test
    public void findGoods() throws Exception {
    //	assertEquals("",new GoodsDataServiceImpl().findGoods("水晶灯", "goodsName"));
    }

    @org.junit.Test
    public void getGoods() throws Exception {
    	assertEquals(goodsPO,new GoodsDataServiceImpl().getGoods("商品名称", "商品分类"));
    }

    @org.junit.Test
    public void deleteGoods() throws Exception {
    }

    @org.junit.Test
    public void modifyGoods() throws Exception {
    }

    @org.junit.Test
    public void initAndSaveGoods() throws Exception {
    	//assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().initAndSaveGoods(goodsPO));
    }

    @org.junit.Test
    public void newGoodsCategory() throws Exception {
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po4));
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po2));
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po3));
    }

    @org.junit.Test
    public void deleteGoodsCategory() throws Exception {
    }

    @org.junit.Test
    public void modifyGoodsCategory() throws Exception {
    }

    @org.junit.Test
    public void getAllCategory() throws Exception {
    	    //assertEquals("豪华水晶灯2",new GoodsDataServiceImpl().getAllCategory("水晶灯").get(0));
    }

}