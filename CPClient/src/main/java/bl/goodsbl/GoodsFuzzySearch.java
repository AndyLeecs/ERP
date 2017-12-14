package bl.goodsbl;

import java.util.List;

/**
 * Created by julia98 on 2017/12/14.
 * 模糊查询商品的包间接口 供其他包调用
 */
public interface GoodsFuzzySearch {

    /**
     * 以商品ID模糊查找
     * @param idInfo
     * @return 符合条件的商品列表
     */
    public List getGoodsInID(String idInfo);

    /**
     * 以商品名称模糊查找
     * @param goodsNameInfo
     * @return 符合条件的商品列表
     */
    public List getGoodsInGoodsName(String goodsNameInfo);

    /**
     * 以商品分类模糊查找
     * @param goodsCategoryInfo
     * @return 符合条件的商品列表
     */
    public List getGoodsInCategory(String goodsCategoryInfo);


}
