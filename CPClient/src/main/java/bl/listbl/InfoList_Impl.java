package bl.listbl;

import VO.listVO.InfoListVO;
import VO.listVO.ListRM;

public class InfoList_Impl implements InfoList {

	@Override
	public ListRM register(InfoListVO vo) {
		// 注册信息表
		
		return ListRM.SUCCESS;
	}

	@Override
	public ListRM modify(boolean b, String id) {
		// 修改信息表
		return ListRM.SUCCESS;
	}

}
