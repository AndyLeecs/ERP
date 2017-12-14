package bl.goodsbl;

import PO.GoodsPO;
import VO.goodsVO.GoodsVO;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品的增删改查
 */
public class Goods {

    private GoodsPO voToPO(GoodsVO goodsVO){
        return goodsVO == null ? null : new GoodsPO(goodsVO.getGoodsID()
                ,goodsVO.getGoodsCategory()
                ,goodsVO.getGoodsName()
                ,goodsVO.getGoodsType()
                ,goodsVO.getGoodsBuyPrice()
                ,goodsVO.getGoodsSellPrice()
                ,goodsVO.recentBuyPrice()
                ,goodsVO.recentSellPrice());
    }

    private GoodsVO poToVO(GoodsPO goodsPO){
        return goodsPO == null ? null : new GoodsVO(goodsPO.getGoodsID()
                ,goodsPO.getGoodsCategory()
                ,goodsPO.getGoodsName()
                ,goodsPO.getGoodsType()
                ,goodsPO.getGoodsBuyPrice()
                ,goodsPO.getGoodsSellPrice()
                ,goodsPO.recentBuyPrice()
                ,goodsPO.recentSellPrice());
    }
}
