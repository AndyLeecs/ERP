package VO.storeVO;

import java.util.ArrayList;
import java.util.List;

public class storeInventoryVO {
    //库存盘点的值对象
    //存储商品的名称、id、型号、库存数量、库存均价、出厂日期
    public int N;//商品总数（其实这个变量是没有必要的）
    public ArrayList<String> name ;
    public ArrayList<String> id;
    public ArrayList<String> model;//型号
    public ArrayList<Integer> number;
    public ArrayList<Double> averagePrice;
    public ArrayList<String> time;
}
