package blservice.goodsblservice;

import java.util.List;
import java.util.Map;

import VO.CategoryVO;
import VO.GoodsVO;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public interface GoodsBLService {
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
}