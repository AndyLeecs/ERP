package bl.storebl;

import VO.listVO.ListRM;
import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreVO;
import VO.storeVO.storeRM;

public class DataSetter {
   //用于调用数据层接口中的方法，向数据层插入数据
	//工具类，为方便测试和优化结构写的。
	//王瑞华 2017年12月3日
	public storeRM insertStoreVO(StoreVO vo){
	//向数据库中插入一个库存项目，若该ID不存在，则允许插入，否则不允许。
		//其实我觉得ID合法性也有必要检查一下
		//数据层写好了以后就可以直接调数据库的方法
		return null;
		
	}
	
	public storeRM addStore(String id,int adder){
		//向库存里添加某种商品的数量
		//其实同时应该记录一下为什么添加，有三种原因，报溢、销售退货、进货
		//只要ID对，加是一定会成功的。
		return null;
		
	}
	
	public storeRM subStore(String id,int subber){
		//向数据库减少某种商品的数量
		return null;
	}
	
	public void insertAlarmListVO (AlarmListVO vo){
		//向数据库插入库存报警单值对象
		
	}
	
	public ListRM insertReportListVO(ReportListVO vo){
		return ListRM.SUCCESS;
		//向数据库中插入库存报告单的值对象（保存状态为草稿）
	}
	public ListRM insertPresentListVO(PresentListVO vo){
		return  ListRM.SUCCESS;
	}
}
