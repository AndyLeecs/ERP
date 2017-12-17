package bl.utility;

import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.goodsVO.GoodsVO;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class GoodsTransGoodsInSale {
	public static List<GoodsInSaleVO> GoodsTransGoodsInSaleInList(List<GoodsVO> list){
		System.out.println("goods trans goods in sale");
		System.out.println(list);
		List<GoodsInSaleVO> returnList = new ArrayList<GoodsInSaleVO>();
		for(GoodsVO i : list){
			GoodsInSaleVO returnVo = new GoodsInSaleVO(i.getGoodsID(),i.getGoodsName(),1);
			returnList.add(returnVo);
		}
		System.out.println(returnList);
		return returnList;
	}
}
