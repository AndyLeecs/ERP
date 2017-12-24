package dataServiceImpl.stroreImpl;
import java.util.ArrayList;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreLogPO;
import PO.StorePO;
import util.State;
import dataService.storeDataService.StoreDataService;
import util.StoreListType;
public class StoreDataServiceImpl implements  StoreDataService {

	@Override
	public boolean checkID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StorePO getStorePO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calcID(StoreListType lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<AlarmListPO> getAlarmListPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PresentListPO> getPresentListPO(State st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresentListPO getSinglePresentList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportListPO getSingleReportList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StoreLogPO> getStoreLogPO(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StorePO> getAllStorePO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertStoreItem(StorePO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceStoreItem(StorePO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addAlarmList(AlarmListPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertReportList(ReportListPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceReportList(ReportListPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertPresentList(PresentListPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replacePresentList(PresentListPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addStoreLogPO(StoreLogPO po) {
		// TODO Auto-generated method stub
		
	}
    
}
