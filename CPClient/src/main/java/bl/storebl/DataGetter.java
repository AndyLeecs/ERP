package bl.storebl;

import VO.storeVO.*;

import java.util.LinkedList;
import java.util.List;

public class DataGetter {
    //用于获取数据，在开发时先写好这个类，方便测试驱动。
    /*
    *这是一个工具类，用于从底层获得数据
    * 写这个类主要是因为数据库现在还没写好，接口层还没写，故而用它做一个桥梁
    * 等数据库写好了再用它去调用数据库的实现就可以（事实上二者最终可以合并）
    *  王瑞华 161250143 2017年12月2日
     */
     LinkedList<AlarmListVO> getAllAlarmList(){

         return null;
     }
     List<ReportListVO> getReportList(StoreListType type, StateType st){
             return null;
     }
    List<PresentListVO> getPresentList(StateType st){

         return null;
    }

    public String calcID(StoreListType lt) {
        return null;
    }
}
