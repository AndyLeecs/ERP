package bl.storebl;

import VO.storeVO.*;
import dataService.storeDataService.StoreDataService;

import util.StoreListType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import PO.AlarmListPO;
import PO.State;
import PO.StorePO;

public class DataGetter {
    //用于获取数据，在开发时先写好这个类，方便测试驱动。
    /*
    *这是一个工具类，用于从底层获得数据
    * 写这个类主要是因为数据库现在还没写好，接口层还没写，故而用它做一个桥梁
    * 等数据库写好了再用它去调用数据库的实现就可以（事实上二者最终可以合并）
    *  王瑞华 161250143 2017年12月2日
     */
	StoreDataService sds;
     LinkedList<AlarmListVO> getAllAlarmList(){
         LinkedList<AlarmListVO> voList=new LinkedList<AlarmListVO>();
         LinkedList<AlarmListPO> poList=sds.getAlarmListPO();
         for(int i=poList.size()-1;i>=0;i--){
        	 //倒序处理一下，最近的单据最先显示
        	 AlarmListVO vo=new AlarmListVO(poList.get(i).alarmNum, poList.get(i).currentNum,
        			 poList.get(i).listID, poList.get(i).goodsID, poList.get(i).goodsName);
        	 voList.add(vo);
         }
         return voList;
     }
     ArrayList<ReportListVO> getReportList(StoreListType type, State st){
             return null;
     }
    ArrayList<PresentListVO> getPresentList(State st){

         return null;
    }

    public String calcID(StoreListType lt) {
        return sds.calcID(lt);
    }
    
    public storeRM checkID(List<String> id){
    	//用于检查一组id是否存在，若有一个id不存在，则返回wrong_id
    	
    	for(int i=0;i<id.size();i++){
    		if(sds.checkID(id.get(i))==false){
    			return storeRM.ID_NOT_EXIST;
    		}
    	}
    	return storeRM.SUCCESS;
    }
    
    public storeRM checkID(String id){
    	if(sds.checkID(id)==true){
    		return storeRM.SUCCESS;
    	}else{
    		
    		return storeRM.ID_NOT_EXIST;
    	}
		
    	//用于检查一个ID是否存在，若不存在，则返回wrong_id
		//这里检查的是库存项的ID，不是表单的ID
    }
    
    public storeRM checkAlarm(String id ,int subber){
    	//用于检查库存在减掉某个值之后的状态，可能不足，也可能触发报警，没问题的话返回success
    	StoreVO vo =getStoreVO(id);
    	if(vo==null){
    		return storeRM.ID_NOT_EXIST;//防御式编程一下
    	}
    	if(vo.Num-subber<0){
    		return storeRM.STORE_NOT_ENOUGH;
    	}else if(vo.Num-subber<=vo.alarmNum){
    		return storeRM.ALARM;
    	}else{
    		return storeRM.SUCCESS;
    	}
		
    	
    }
    
    public StoreVO getStoreVO(String id){
    	//用于查单个库存项
    	StorePO po=sds.getStorePO(id);
    	StoreVO vo=new StoreVO(po.name, po.ID, po.alarmNum, po.Num);
    	vo.averagePrice=po.averagePrice;
    	
    	return vo;
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
