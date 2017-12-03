package bl.storebl;

import VO.listVO.InfoListVO;
import VO.storeVO.PresentListVO;
import bl.listbl.InfoList;
import util.GreatListType;
import util.ResultMessage;

public class PresentList extends StoreList {
	PresentListVO vo;
	InfoList infolist;
	PresentList(PresentListVO vo){
		this.vo=vo;
	}
	public ResultMessage commit(){
		
		infolist.register(new InfoListVO(vo.listID,GreatListType.PRESENT,vo.VIPname,""));
		return ResultMessage.SUCCESS;
	}
	
}
