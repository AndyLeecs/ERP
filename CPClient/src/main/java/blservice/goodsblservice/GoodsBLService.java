package blservice.goodsblservice;

import java.util.List;
import java.util.Map;

import VO.goodsVO.CategoryVO;
import VO.goodsVO.GoodsVO;
import VO.goodsVO.TreeVO;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public interface GoodsBLService {
	/*
		public List<CategoryVO> getChildCategory(CategoryVO vo);
		public String getNewCategoryNumber();
		public boolean addCategory(CategoryVO vo);
		public boolean deleteCategory(CategoryVO vo);
		public boolean modifyCategory(CategoryVO vo);
		public String getNewGoodsNumber(CategoryVO vo);
		public boolean addGoods(GoodsVO vo);
		public boolean deleteGoods(String id);
		public boolean modifyGoods(GoodsVO vo);
		public Map<String,String> searchGoods(String id, String name);
		public GoodsVO getGoods(String id);
		public int getStoreInfo(GoodsVO vo);
		*/

	public String newGoods(String name,String category);
	public List findGoods(String info,String type);
	public GoodsVO getGoods(String name,String category);
	public ResultMessage deleteGoods(String category,String name);//修改接口 把入口参数变更为分类名+商品名 之前为商品ID 我是在商品目录里面删除的 商品ID不利于调用
	public ResultMessage modifyGoods(GoodsVO vo);
	public ResultMessage initAndSaveGoods(GoodsVO vo);
	public ResultMessage newGoodsCategory(String category,String node);
	public ResultMessage deleteGoodsCategory(String category);
	public ResultMessage modifyGoodsCategory(String category);
	public List getAllCategory();
}