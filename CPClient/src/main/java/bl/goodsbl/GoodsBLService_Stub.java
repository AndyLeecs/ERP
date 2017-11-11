package bl.goodsbl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import VO.CategoryVO;
import VO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsBLService_Stub implements GoodsBLService{

	//CategoryVO	
    String id;
    String name;
    String ParentID;
    Map<String, String> childCategoryList;
    Map<String, String> goods;
    
    //goodsVO
	String goodsID;
	String goodsSort;
	String goodsName;
	String goodsType;
	String goodsCode;
	double goodsBuyPrice;
	double goodsSellPrice;
	double recentBuyPrice;
	double recentSellPrice;
	
	
	public GoodsBLService_Stub(String id, String name, String parentID, Map<String, String> childCategoryList,
			Map<String, String> goods, String goodsID, String goodsSort, String goodsName, String goodsType,
			String goodsCode, double goodsBuyPrice, double goodsSellPrice, double recentBuyPrice,
			double recentSellPrice) {
		super();
		this.id = id;
		this.name = name;
		ParentID = parentID;
		this.childCategoryList = childCategoryList;
		this.goods = goods;
		this.goodsID = goodsID;
		this.goodsSort = goodsSort;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsCode = goodsCode;
		this.goodsBuyPrice = goodsBuyPrice;
		this.goodsSellPrice = goodsSellPrice;
		this.recentBuyPrice = recentBuyPrice;
		this.recentSellPrice = recentSellPrice;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#getChildCategory(VO.CategoryVO)
	 */
	public List<CategoryVO> getChildCategory(CategoryVO vo) {
		// TODO Auto-generated method stub
		List<CategoryVO> l = new ArrayList<CategoryVO> ();
		Map<String,String> child = new HashMap<String,String>();
		child.put("00000", "小台灯");
		Map<String,String> goods = null;
		
		
		l.add(new CategoryVO("00001", "台灯", "00002", child,
				goods));
		
		return l;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#getNewCategoryNumber()
	 */
	public String getNewCategoryNumber() {
		// TODO Auto-generated method stub
		
		return "00023";
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#addCategory(VO.CategoryVO)
	 */
	public boolean addCategory(CategoryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#deleteCategory(VO.CategoryVO)
	 */
	public boolean deleteCategory(CategoryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#modifyCategory(VO.CategoryVO)
	 */
	public boolean modifyCategory(CategoryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#getNewGoodsNumber(VO.CategoryVO)
	 */
	public String getNewGoodsNumber(CategoryVO vo) {
		// TODO Auto-generated method stub
		return "233";
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#addGoods(VO.GoodsVO)
	 */
	public boolean addGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#deleteGoods(java.lang.String)
	 */
	public boolean deleteGoods(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#modifyGoods(VO.GoodsVO)
	 */
	public boolean modifyGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#searchGoods(java.lang.String, java.lang.String)
	 */
	public Map<String, String> searchGoods(String id, String name) {
		// TODO Auto-generated method stub
		Map<String,String> child = new HashMap<String,String>();
		child.put("00000", "小台灯");
		return child;
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#getGoods(java.lang.String)
	 */
	public GoodsVO getGoods(String id) {
		// TODO Auto-generated method stub
		return new GoodsVO("00000","00001","明亮灯","00002","00003",200,300,200,300);
	}

	/* (non-Javadoc)
	 * @see goodsblservice.GoodsBLService#getStoreInfo(VO.GoodsVO)
	 */
	public int getStoreInfo(GoodsVO vo) {
		// TODO Auto-generated method stub
		return 2000;
	}

}