package bl.storebl;

import VO.listVO.InfoListVO;
import VO.storeVO.PresentListVO;

import util.GreatListType;
import util.ResultMessage;

public class PresentList extends StoreList {
	PresentListVO vo;
	
	PresentList(PresentListVO vo){
		this.vo=vo;
	}
	public ResultMessage commit(){
		
		infoList.register(new InfoListVO(vo.listID,GreatListType.PRESENT,vo.VIPname,""));
		return ResultMessage.SUCCESS;
	}
	
}
