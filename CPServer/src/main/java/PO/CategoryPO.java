package PO;

import java.io.Serializable;
import java.util.Map;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class CategoryPO implements Serializable{
		/**
		 * 商品分类编号
		 */
	    String id;
		/**
		 * 名称
		 */	    
	    String name;
		/**
		 * 父节点编号
		 */
	    String parentID;
		/**
		 * 子节点列表
		 */
	    Map<String, String> childCategoryList;
		/**
		 * 分类下商品列表
		 */
	    Map<String, String> goods;
	    
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
