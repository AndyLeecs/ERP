package bl.goodsbl;

import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/14.
 * 生成商品编号
 */
public class GoodsUtility {
    int goodsIDcounter = 0;
    ArrayList<String> goodsIDList = new ArrayList<>();

    public String generateGoodsID(){
        goodsIDcounter++;
        String goodsID = String.valueOf(goodsIDcounter);
        while(goodsID.length() < 8){
            goodsID = "0" + goodsID;
        }
        goodsID = "G" + goodsID;
        goodsIDList.add(goodsID);
        return goodsID;
    }
}
