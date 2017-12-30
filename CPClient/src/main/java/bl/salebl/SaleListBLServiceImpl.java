package bl.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.SaleListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleListBLService;
import dataService.saleDataService.SaleListDataService;
import network.saleRemoteHelper.SaleListDataServiceHelper;
import resultmessage.DataRM;
import util.DateUtil;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleListBLServiceImpl implements SaleListBLService{

	SaleListDataService service = SaleListDataServiceHelper.getInstance().getSaleListDataService();
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		try {
			System.out.println(service);
			String id = service.insert();
			System.out.println(id);
			return id;
		//	return presentForSumDataService.insert();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) {
		// TODO Auto-generated method stub
		try {
			return service.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#save(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public DataRM save(SalesmanListVO vo) {
		try {
			vo.setState(State.IsDraft);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	@Override
	public DataRM approve(SalesmanListVO vo){
		try {
			vo.setState(State.IsApproved);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}
	
	@Override
	public DataRM reject(SalesmanListVO vo){
		try {
			vo.setState(State.IsRefused);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}
	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#commit(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public DataRM commit(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		try {
			vo.setState(State.IsCommitted);
			return service.commit(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#openAllDraft()
	 */
	@Override
	public List<SalesmanListVO> openAllDraft() {
		List<SalesmanListPO> polist = new ArrayList<SalesmanListPO>();
		List<SalesmanListVO> volist = new ArrayList<SalesmanListVO>();
		try {
			polist = service.openAllDraft();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	//		return volist;
		}
		for(SalesmanListPO po : polist){
			volist.add(poToVo(po));
		}
		return volist;
	}

/**
 * @param i
 * @return
 */
public SalesmanItemPO itemVoToPo(SalesmanItemVO i) {
	return new SalesmanItemPO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param i
 * @return
 */
public SalesmanItemVO itemPoToVo(SalesmanItemPO i) {
	return new SalesmanItemVO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param po
 * @return
 */
public List<SalesmanItemVO> generateVoList(SalesmanListPO po) {
	List<SalesmanItemPO> polist = po.getSaleListItems();
	List<SalesmanItemVO> volist = new ArrayList<SalesmanItemVO>();

	if(polist == null)
		volist = null;
	else{
	for(SalesmanItemPO i:polist){
		volist.add(itemPoToVo(i));
	}
	}
	return volist;
}

/**
 * @param svo
 * @return
 */
public List<SalesmanItemPO> generatePoList(SalesmanListVO vo) {
	List<SalesmanItemVO> volist = vo.getSaleListItems();
	List<SalesmanItemPO> polist = new ArrayList<SalesmanItemPO>();
	
	if(volist == null)
		polist = null;
	else{
	for(SalesmanItemVO i:volist){
		polist.add(itemVoToPo(i));
	}
	}
	return polist;
}

	public SalesmanListPO voToPo(SalesmanListVO vo) {
		SaleListVO svo = (SaleListVO)vo;
		List<SalesmanItemVO> volist = svo.getSaleListItems();
		List<SalesmanItemPO> polist = new ArrayList<SalesmanItemPO>();
		
		if(volist == null)
			polist = null;
		else{
		for(SalesmanItemVO i:volist){
			polist.add(itemVoToPo(i));
		}
		}
		return new SaleListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher());
//		return new SaleListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher());
	}



	public SalesmanListVO poToVo(SalesmanListPO po) {
		SaleListPO spo = (SaleListPO)po;
		List<SalesmanItemPO> polist = spo.getSaleListItems();
		List<SalesmanItemVO> volist = new ArrayList<SalesmanItemVO>();

		if(polist == null)
			volist = null;
		else{
		for(SalesmanItemPO i:polist){
			volist.add(itemPoToVo(i));
		}
		}
		//留了一个空项，看以后是存操作员的id还是名称
		return new SaleListVO(spo.getId(), spo.getOperator(),spo.getOperatorId(), spo.getState(),spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum(), spo.getSumBeforeRebate(), spo.getRebate(), spo.getVoucher());
	}

	
	
	
}
