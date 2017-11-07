package blservice.storeblservice;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import VO.GoodsVO;
import VO.ListInitVO;
import VO.ListType;
import VO.ListVO;
import VO.StoreListVO;
import VO.StoreVO;
import VO.StoreViewStandardVO;
import VO.StoreViewVO;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public interface StoreBLService {
	public String createList(ListType type);
	public Map<ListType, String> openDraftList();
	public StoreListVO openList(ListType type, String id);
	public void saveList(ListType type, ListVO vo);
	public void commitList(ListType type, ListVO vo);
	public Map<String,String> findGoods(String id, String name);
	public GoodsVO getGoods(String id);
	public int getStoreNumber(String id);
	public int getOverflowNumber(int numberInReality);
	public int getLossNumber(int numberInReality);
	public Set<StoreVO> check();
	public StoreViewVO view(StoreViewStandardVO vo, Date begin, Date end);
	public void setAlert(Map<String, Integer> alertMap);
	
}
