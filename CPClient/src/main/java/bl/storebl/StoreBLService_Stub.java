package bl.storebl;

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
import blservice.storeblservice.StoreBLService;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class StoreBLService_Stub implements StoreBLService{

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#createList(VO.ListType)
	 */
	public String createList(ListType type) {
		// TODO Auto-generated method stub
		return "0001";
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#openDraftList()
	 */
	public Map<ListType, String> openDraftList() {
		// TODO Auto-generated method stub
		return new Map<ListType,String>();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#openList(VO.ListType, java.lang.String)
	 */
	public StoreListVO openList(ListType type, String id) {
		// TODO Auto-generated method stub
		return new StoreListVO();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#saveList(VO.ListType, VO.ListVO)
	 */
	public ResultMessage saveList(ListType type, ListVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#commitList(VO.ListType, VO.ListVO)
	 */
	public ResultMessage commitList(ListType type, ListVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
		
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#findGoods(java.lang.String, java.lang.String)
	 */
	public Map<String, String> findGoods(String id, String name) {
		// TODO Auto-generated method stub
		return new Map<String,String>();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#getGoods(java.lang.String)
	 */
	public GoodsVO getGoods(String id) {
		// TODO Auto-generated method stub
		return new GoodsVO();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#getStoreNumber(java.lang.String)
	 */
	public int getStoreNumber(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#getOverflowNumber(int)
	 */
	public int getOverflowNumber(int numberInReality) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#getLossNumber(int)
	 */
	public int getLossNumber(int numberInReality) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#check()
	 */
	public Set<StoreVO> check() {
		// TODO Auto-generated method stub
		return new Set<StoreVO>();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#view(VO.StoreViewStandardVO, java.util.Date, java.util.Date)
	 */
	public StoreViewVO view(StoreViewStandardVO vo, Date begin, Date end) {
		// TODO Auto-generated method stub
		return new StoreViewVO();
	}

	/* (non-Javadoc)
	 * @see storeblservice.StoreBLService#setAlert(java.util.Map)
	 */
	public ResultMessage setAlert(Map<String, Integer> alertMap) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
