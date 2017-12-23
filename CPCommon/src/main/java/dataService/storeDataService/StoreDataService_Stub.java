package dataService.storeDataService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.State;
import PO.StoreLogPO;
import PO.StorePO;
import util.GreatListType;
import util.StoreListType;

public class StoreDataService_Stub implements StoreDataService{
	//官方提供维护的正版桩程序，欢迎大家调用。
	private int virtualID=101;
	@Override
	public boolean checkID(String id) {
		// 检查ID，暂且认为你给我的ID都是对的，这样程序比较好跑
		return true;
	}

	@Override
	public StorePO getStorePO(String id) {
		// 返回一个假的PO
		StorePO po=new StorePO ();
		po.alarmNum=10;
		po.averagePrice=50;
		po.Num=100;
		po.ID=id;
		po.name="小灯佩奇";
		return po;
	}

	@Override
	public String calcID(StoreListType lt) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String s=df.format(new Date());
		s=s+"_"+Integer.toString(virtualID);
		virtualID++;
		//假装在认真算一个ID
		return s;
	}

	@Override
	public LinkedList<AlarmListPO> getAlarmListPO() {
		// 返回一个报警单的值对象
		AlarmListPO po1=new AlarmListPO();
		po1.alarmNum=72;
		po1.currentNum=36;
		po1.goodsID="G160_20171223F";
		po1.goodsName="小灯佩奇";
		po1.listID="KCBJD_20171223001";
		AlarmListPO po2=new AlarmListPO();
		po2.alarmNum=70;
		po2.currentNum=3;
		po2.goodsID="G16_20171223T";
		po2.goodsName="小熊维尼";
		po2.listID="KCBJD_20171223002";
		LinkedList<AlarmListPO> list=new LinkedList<AlarmListPO>();
		list.add(po1);
		list.add(po2);
		return list;
	}

	@Override
	public ArrayList<PresentListPO> getPresentListPO(State st) {
		// 返回一组库存赠送单的值对象
		PresentListPO po1=new PresentListPO ();
		po1.id.add("G20171223_001");
		po1.name.add("小熊维尼");
		po1.num.add(10);
		po1.statetype=st;
		po1.listID="KCZSD_20171223_001";
		po1.operator="Tony_Wang";
		po1.time="2017-12-23 23:59:59";
		po1.VIPname="尊贵的VIP——高毓彬";
		ArrayList<PresentListPO> arr=new ArrayList<PresentListPO>();
		arr.add(po1);
		return arr;
	}

	@Override
	public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st) {
		// 返回一组库存报告单
		ReportListPO po=new ReportListPO();
		po.delta=10;
		po.statetype=st;
		po.st=type;
		po.Num=20;
		if(type==StoreListType.LOSS){
			po.actualNum=po.Num-po.delta;
		}else{
			po.actualNum=po.Num+po.delta;
		}
		po.listID="KCBGD_20170223_001";
		po.GoodsName="小灯佩奇";
		po.goodsID="G00000001F";
		po.time="2017-12-23 23:45:46";
		po.operator="很晚了还在勤奋的码代码的小华";
		
		ArrayList<ReportListPO> arr=new ArrayList<ReportListPO>();
		arr.add(po);
		return arr;
	}

	@Override
	public PresentListPO getSinglePresentList(String id) {
		PresentListPO po1=new PresentListPO ();
		po1.id.add("G20171223_001");
		po1.name.add("小熊维尼");
		po1.num.add(10);
		po1.statetype=State.IsApproved;
		po1.listID="KCZSD_20171223_001";
		po1.operator="Tony_Wang";
		po1.time="2017-12-23 23:59:59";
		po1.VIPname="尊贵的VIP——高毓彬";
		return po1;
	}

	@Override
	public ReportListPO getSingleReportList(String id) {
		ReportListPO po=new ReportListPO();
		po.delta=10;
		po.statetype=State.IsCommitted;
		po.st=StoreListType.LOSS;
		po.Num=20;
	
			po.actualNum=po.Num-po.delta;

		po.listID=id;
		po.GoodsName="小灯佩奇";
		po.goodsID="G00000001F";
		po.time="2017-12-23 23:45:46";
		po.operator="很晚了还在勤奋的码代码的小华";
		return po;
	}

	@Override
	public ArrayList<StoreLogPO> getStoreLogPO(String beginTime, String endTime) {
		StoreLogPO po1=new StoreLogPO ();
		po1.id="G0002222111333";
		po1.name="小猪佩奇和小狗道吉";
		po1.num=50;
		po1.price=410.35;
		po1.time="2017-12-23 23:45:54";
		po1.type=GreatListType.SALE;
		ArrayList<StoreLogPO> arr=new ArrayList<StoreLogPO>();
		arr.add(po1);
		return arr;
	}

	@Override
	public ArrayList<StorePO> getAllStorePO() {
		StorePO po=new StorePO ();
		po.alarmNum=10;
		po.averagePrice=50;
		po.Num=100;
		po.ID="G0011234-001";
		po.name="小灯佩奇";
		ArrayList<StorePO> arr=new ArrayList<StorePO>();
		arr.add(po);
		return arr;
	}

	@Override
	public boolean insertStoreItem(StorePO po) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean replaceStoreItem(StorePO po) {
		
		return true;
	}

	@Override
	public void addAlarmList(AlarmListPO po) {
		
		
	}

	@Override
	public boolean insertReportList(ReportListPO po) {
		
		return true;
	}

	@Override
	public boolean replaceReportList(ReportListPO po) {
		
		return true;
	}

	@Override
	public boolean insertPresentList(PresentListPO po) {
		
		return true;
	}

	@Override
	public boolean replacePresentList(PresentListPO po) {
		
		return true;
	}

	@Override
	public void addStoreLogPO(StoreLogPO po) {
		
		
	}

}
