package bl.storebl;

import java.util.List;

import VO.storeVO.AlarmListVO;
import util.GreatListType;
import util.StoreListType;
import VO.storeVO.StoreVO;
import VO.storeVO.storeRM;

public class Store_InterfaceImpl implements Store_Interface {
	DataSetter ds=new DataSetter();
	DataGetter dg=new DataGetter();
  //用于实现库存类对外提供的修改库存的方法
	//在进入数据层访问之前先进行条件检查，防御式编程一下；另外分发一下要记录的进出库项目，为库存查看和盘点做准备。
	
	@Override
	public storeRM addStoreItem(StoreVO vo) {
		// 增加库存项
		if(dg.checkID(vo.ID).equals(storeRM.ID_NOT_EXIST)){
			return ds.insertStoreVO(vo);
		}else{
		return storeRM.ID_EXIST;
		}
	}

	@Override
	public storeRM plusNumber( String id, int adder,GreatListType type,double price) {
		// 增加库存数量
		if(dg.checkID(id).equals(storeRM.ID_NOT_EXIST)){
			return storeRM.ID_NOT_EXIST;
		}else{
			//重点：在这一步触发记录操作，为库存查看和库存盘点做准备
		return ds.addStore(id, adder,price);
		}
	}

	@Override
	public storeRM minusNumber( String id, int subber,GreatListType type) {
		// 减少库存数量
		if(dg.checkID(id).equals(storeRM.ID_NOT_EXIST)){
			return storeRM.ID_NOT_EXIST;
		}else{
			//重点：如果出现了下述SUCCESS/ALARM的情况，触发记录操作
			storeRM r=dg.checkAlarm(id, subber);
			switch(r){
			case SUCCESS:
				ds.subStore(id, subber);
				return storeRM.SUCCESS;
				
			case ALARM:
				ds.subStore(id, subber);
				// 触发库存报警单
				StoreVO v1=dg.getStoreVO(id);
				ds.insertAlarmListVO(new AlarmListVO(v1.alarmNum,v1.Num,dg.calcID(StoreListType.ALARM),v1.ID,v1.name));
				return storeRM.SUCCESS;
			case STORE_NOT_ENOUGH:
				return r;
			default:
				break;
			}

		}
		return null;
	}

	@Override
	public boolean check(List<String> id, List<Integer> subber) {
		// 检查一组商品库存是否够，不够的话不能修改数据（用于单据审批的检查数据中）
		boolean res=true;
		if(dg.checkID(id).equals(storeRM.ID_NOT_EXIST)){
			return false;
		}else{
		for(int i=0;i<id.size();i++){
			storeRM r=dg.checkAlarm(id.get(i), subber.get(i));
			if(r.equals(storeRM.STORE_NOT_ENOUGH)){
				res=false;
				break;
			}
		}
		}
		return res;
	}

}
