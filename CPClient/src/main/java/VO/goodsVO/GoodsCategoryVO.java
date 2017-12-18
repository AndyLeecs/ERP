package VO.goodsVO;

/**
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class GoodsCategoryVO {
	String goodsCategoryName;
	String parentName;

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
	    
	public GoodsCategoryVO(String goodsCategoryName, String parentName) {
	this.goodsCategoryName = goodsCategoryName;
	this.parentName = parentName;
	}
}
