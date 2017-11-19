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
public class GoodsBLService_Driver {
	
	List<CategoryVO> l = new ArrayList<CategoryVO> ();
	Map<String,String> child = new HashMap<String,String>();

	Map<String,String> goods = null;
	CategoryVO Categoryvo = new CategoryVO("", null, null, child, child);
	GoodsVO goodsvo = new GoodsVO(null, null, null, null,  0, 0, 0, 0);
	
	
public void drive(GoodsBLService goodsBLService){
	child.put("00000", "小台灯");
	l.add(new CategoryVO("00001", "台灯", "00002", child,
			goods));
	
	if(!(goodsBLService.addCategory(Categoryvo)))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.addGoods(goodsvo)))
		System.out.println("Success");
	else
		System.out.println("Fail");
		
	if(!(goodsBLService.deleteCategory(Categoryvo)))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.deleteGoods("0")))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.modifyCategory(Categoryvo)))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.modifyGoods(goodsvo)))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.getChildCategory(Categoryvo).equals(l)))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.getNewCategoryNumber().equals("00023")))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if(!(goodsBLService.getNewGoodsNumber(Categoryvo).equals("233")))
		System.out.println("Success");
	else
		System.out.println("Fail");
	
	if((goodsBLService.getStoreInfo(goodsvo) == 2000))
		System.out.println("Success");
	else
		System.out.println("Fail");
}

}
