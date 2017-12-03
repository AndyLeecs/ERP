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
    
    public storeRM checkID(List<String> id){
    	//用于检查一组id是否存在，若有一个id不存在，则返回wrong_id
    	return null;
    }
    
    public storeRM checkID(String id){
		return null;
    	//用于检查一个ID是否存在，若不存在，则返回wrong_id
    }
    
    public storeRM checkAlarm(String id ,int subber){
    	//用于检查库存在减掉某个值之后的状态，可能不足，也可能触发报警，没问题的话返回success
		return null;
    	
    }
    
    public StoreVO getStoreVO(String id){
    	//用于查单个库存项
    	return null;
    }
    public ReportListVO getReportListVO(String id){
    	//查找单个库存报告单对象
		return null;
    	
    }
    public PresentListVO getPresentListVO(String id){
    	//查找单个库存赠送单对象
		return null;
    	
    }
}
