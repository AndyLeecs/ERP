package bl.goodsbl;

/**
 * Created by julia98 on 2017/12/14.
 * 生成商品编号
 */
public class GoodsUtility {
    int goodsIDcounter = 0;

    public String generateGoodsID(){
        goodsIDcounter++;
        String goodsID = String.valueOf(goodsIDcounter);
        while(goodsID.length() < 8){
            goodsID = "0" + goodsID;
        }
        return goodsID;
    }
}
