package bl.storebl;


import VO.listVO.ListRM;
import VO.storeVO.*;
import blservice.storeblservice.StoreBLService;

import bl.storebl.DataGetter;
import java.util.LinkedList;
import java.util.List;

public class StoreblController implements StoreBLService{
    //控制器，负责分发库存类的职责
    // 王瑞华 161250143 2017年12月2日
    DataGetter getter=new DataGetter();
    DataSetter setter =new DataSetter();
    @Override
    public LinkedList<AlarmListVO> openAlarmList() {
        //查看全部库存报警单
        return getter.getAllAlarmList();
    }

    @Override
    public List<ReportListVO> openReportList(StoreListType lt, StateType st) {
        //查看库存报告单
        return getter.getReportList(lt,st);
    }

    @Override
    public List<PresentListVO> openPresentList(StateType st) {
        //查看赠送单
        return getter.getPresentList(st);
    }

    @Override
    public String toExcel(InventoryVO vo) {
        //这个方法先不实现，等数据库架好了再写
        return null;
    }

    @Override
    public String newList(StoreListType type) {
        return getter.calcID(type);
    }

    @Override
    public ListRM saveReportList( ReportListVO vo) {
    	//保存草稿单：
    	//再次说明：保存并提交这个操作需要手动调用保存并手动调用提交
    	vo.statetype=StateType.DRAFT;
        return setter.insertReportListVO(vo);
    }


    @Override
    public ListRM savePresentList(PresentListVO vo) {
    	vo.statetype=StateType.DRAFT;
        return setter.insertPresentListVO(vo);
    }

    @Override
    public ListRM commit(StoreListType type, String ID) {
    	if(type.equals(StoreListType.PRESENT)){
            PresentListVO vo =getter.getPresentListVO(ID);
            PresentList pl=new PresentList(vo);
            pl.commit();
            return ListRM.SUCCESS;
            
    	}else if(type.equals(StoreListType.OVERFLOW)||type.equals(StoreListType.LOSS)){
    		ReportListVO vo=getter.getReportListVO(ID);
    		ReportList rl=new ReportList(vo);
    		rl.commit();
    		return ListRM.SUCCESS;
    	}else{
        return ListRM.WRONG_LISTTYPE;
    	}
    }



    @Override
    public storeCheckVO store_check(String begintime, String endTime) {
        return null;
    }

    @Override
    public storeInventoryVO store_inventory(String day) {
        return null;
    }
}
