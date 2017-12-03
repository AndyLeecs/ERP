package bl.storebl;

import VO.listVO.InfoListVO;

import VO.storeVO.ReportListVO;
import VO.storeVO.StoreListType;
import bl.listbl.InfoList;
import util.GreatListType;
import util.ResultMessage;

public class ReportList extends StoreList  {
    /*
    * 王瑞华 161250143 2017年12月2日
     */
    ReportListVO vo;
    InfoList infoList ;
    public ReportList(ReportListVO vo){
        this.vo=vo;
    }
    public ResultMessage commit(){
        //单据如果编辑完直接提交，需要从界面层自动先做一个保存草稿的操作。这个操作很关键。
        //提交的操作步骤是先把这个VO查到，然后调用注册接口
    	GreatListType glt;
    	if(vo.st.equals(StoreListType.LOSS)){
         glt=GreatListType.LOSS;
    	}else {
    		glt=GreatListType.OVERFLOW;
    	}
        infoList.register(new InfoListVO(vo.listID, glt,vo.GoodsName,Integer.toString(vo.delta)));
        //操作对象写的是被报损/报溢的商品；备注项写的是报损/报溢出数量
        return ResultMessage.SUCCESS;
    }
}
