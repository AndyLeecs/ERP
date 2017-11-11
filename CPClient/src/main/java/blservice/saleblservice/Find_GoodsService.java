package blservice.saleblservice;

import java.util.List;

import VO.GoodsVO;
import VO.SalesmanListType;

/**     
* @author 李安迪
* @date 2017年11月11日
* @description
*/
public interface Find_GoodsService {
	public List<GoodsVO> findGoods(String info);
}
