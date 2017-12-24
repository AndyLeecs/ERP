package bl.storebl;

import VO.storeVO.StoreVO;
import VO.storeVO.storeRM;
import util.GreatListType;

import java.util.List;

public interface Store_Interface {
    // 库存包对层内各包提供的接口，包括三个基本接口：增加库存项、修改库存、检查操作正确性


    public storeRM addStoreItem(StoreVO vo);

    public storeRM plusNumber(String id,int adder,GreatListType type,double price);

    public storeRM minusNumber(String id,int subber,GreatListType type);

    /**
     * @param id  要出库的商品ID的列表
     * @param subber  要出库的商品的出库数量列表
     * @return  返回对操作是否能成功的预判
     */
    public boolean check(List<String> id,List<Integer> subber);
}
