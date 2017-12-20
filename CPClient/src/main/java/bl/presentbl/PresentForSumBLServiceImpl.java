package bl.presentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForSumPO;
import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import bl.utility.GoodsInSaleVoTransPo;
import blservice.presentblservice.PresentForSumBLService;
import dataService.presentDataService.PresentForSumDataService;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;
import util.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentForSumBLServiceImpl implements PresentForSumBLService {

	PresentForSumDataService presentForSumDataService = PresentForSumDataServiceHelper.getInstance().getPresentForSumDataService();
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getAll()
	 */
	@Override
	public List<PresentForSumVO> getAll() {
		// TODO Auto-generated method stub
		List<PresentForSumPO> polist;
		try {
			polist = presentForSumDataService.getPresentForSum();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<PresentForSumVO> volist = new ArrayList<PresentForSumVO>();
		
		for(PresentForSumPO po : polist){
			volist.add(poToVo(po));
		}
		
		return volist;
	}

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		try {
			return presentForSumDataService.insert();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#delete(int)
	 */
	@Override
	public DataRM delete(int id) {
		// TODO Auto-generated method stub
		try {
			return presentForSumDataService.deletePresentForSum(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#save(VO.presentVO.PresentForSumVO)
	 */
	@Override
	public DataRM save(PresentForSumVO vo) {
		// TODO Auto-generated method stub
		try {
			return presentForSumDataService.update(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	private PresentForSumVO poToVo(PresentForSumPO po){
		List<GoodsInSalePO> polist = po.getPresentList();
		List<GoodsInSaleVO> volist = new ArrayList<GoodsInSaleVO>();
		for(GoodsInSalePO i:polist){
			volist.add(GoodsInSaleVoTransPo.GoodsInSalePoToVo(i));
		}
		
		return new PresentForSumVO(po.getId(),po.getStartTime(), po.getFinishTime(), po.getSum(),volist, po.getSum());
	}
	
	private PresentForSumPO voToPo(PresentForSumVO vo){
		
		
		List<GoodsInSaleVO> volist = vo.getPresentList();
		List<GoodsInSalePO> polist = new ArrayList<GoodsInSalePO>();
		
		if(volist == null)
			polist = null;
		else{
		for(GoodsInSaleVO i:volist){
			polist.add(GoodsInSaleVoTransPo.GoodsInSaleVoToPo(i));
		}
		}
		return new PresentForSumPO(vo.getId(), vo.getStartTime(), vo.getFinishTime(), vo.getTotal(), polist, PresentState.SAVE, vo.getVoucher());
	}

}