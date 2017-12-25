package blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.List;

import PO.GoodsCategoryPO;
import VO.goodsVO.GoodsCategoryVO;
import VO.goodsVO.GoodsVO;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public interface GoodsBLService {

	public String newGoodsID();
	public List<GoodsVO> findGoods(String info,String type);
	public GoodsVO getGoods(String name,String category);
	public ResultMessage deleteGoods(String category,String name) throws RemoteException;//修改接口 把入口参数变更为分类名+商品名 之前为商品ID 我是在商品目录里面删除的 商品ID不利于调用
	public ResultMessage modifyGoods(GoodsVO vo);
	public ResultMessage initAndSaveGoods(GoodsVO vo);
	public ResultMessage newGoodsCategory(GoodsCategoryVO vo);//category包含新建分类整个路径 （如果是嵌套分类的话）
	public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo);
	public ResultMessage modifyGoodsCategory(GoodsCategoryVO oldVO,GoodsCategoryVO newVO);
	public List getAllCategory(String node);
}