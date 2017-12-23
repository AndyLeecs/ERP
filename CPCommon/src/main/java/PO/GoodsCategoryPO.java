package PO;

import java.io.Serializable;
import java.util.Map;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsCategoryPO implements Serializable{
	String goodsCategoryName;
    String parentName;
    private String autoId;//sql自动生成

    public GoodsCategoryPO(String goodsCategoryName, String parentName) {
        this.goodsCategoryName = goodsCategoryName;
        this.parentName = parentName;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

	public String getAutoId() {
		return autoId;
	}

	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}

//		public CategoryVO(String id, String name, String parentID, Map<String, String> childCategoryList,
//				Map<String, String> goods) {
//			super();
//			this.id = id;
//			this.name = name;
//			ParentID = parentID;
//			this.childCategoryList = childCategoryList;
//			this.goods = goods;
//		}
//		public String getId() {
//			return id;
//		}
//		public void setId(String id) {
//			this.id = id;
//		}
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public String getParentID() {
//			return ParentID;
//		}
//		public void setParentID(String parentID) {
//			ParentID = parentID;
//		}
//		public Map<String, String> getChildCategoryList() {
//			return childCategoryList;
//		}
//		public void setChildCategoryList(Map<String, String> childCategoryList) {
//			this.childCategoryList = childCategoryList;
//		}
//		public Map<String, String> getGoods() {
//			return goods;
//		}
//		public void setGoods(Map<String, String> goods) {
//			this.goods = goods;
//		} 
//	    
	
}
