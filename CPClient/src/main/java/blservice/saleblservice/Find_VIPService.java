package blservice.saleblservice;

import java.util.List;

import VO.SalesmanListType;
import VO.VIPVO;

/**     
* @author 李安迪
* @date 2017年11月11日
* @description
*/
public interface Find_VIPService {
	public List<VIPVO> findVIP(String info,SalesmanListType type);
}
