package bl.storebl;

import VO.ListVO;
import VO.listVO.ListRM;
import VO.storeVO.*;
import blservice.storeblservice.StoreBLService;
import util.ListType;
import bl.storebl.DataGetter;
import java.util.LinkedList;
import java.util.List;

public class StoreblController implements StoreBLService{
    //控制器，负责分发库存类的职责
    // 王瑞华 161250143 2017年12月2日
    DataGetter getter=new DataGetter();
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
    public ListRM saveReportList(StoreListType type, ReportListVO vo) {
        return null;
    }


    @Override
    public ListRM savePresentList(PresentListVO vo) {
        return null;
    }

    @Override
    public ListRM commit(StoreListType type, String ID) {
        return null;
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
