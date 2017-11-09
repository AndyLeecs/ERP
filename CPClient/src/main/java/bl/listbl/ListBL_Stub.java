package bl.listbl;

import java.util.*;
import VO.*;
import blservice.listblservice.ListBL;

public class ListBL_Stub implements ListBL{
	ListVO listVO = new ListVO();

	public ArrayList checkList() {
		// TODO Auto-generated method stub
		return listVO.checkList();
	}

	public ArrayList checkSaleDetailForm(SaleDetailConditionVO vo) {
		// TODO Auto-generated method stub
		return vo.checkSaleDetailForm();
	}


	public ListVO getSpecificList(ListType type, String id) {
		// TODO Auto-generated method stub
		return listVO.getSpecificList(type, id);
	}

	public boolean hongchong(ListType type, String id) {
		// TODO Auto-generated method stub
		listVO.hongchong(type, id);	
		return true;
	}

	public String hongchongAndCopy(ListType type, String id) {
		// TODO Auto-generated method stub
		return listVO.hongchongAndCopy(type, id);
	}

	public BusinessCircumVO checkBusinessCircumForm(Date beginTime, Date endTime) {
		// TODO Auto-generated method stub
		BusinessCircumVO businessCircumVO = new BusinessCircumVO();
		return businessCircumVO.checkBusinessCircumForm();
	}

	public boolean approvalList(ListType type, String id, ListVO vo) {
		// TODO Auto-generated method stub
		listVO.approvalList(type, id, vo);
		return true;
	}

	public ArrayList checkBusinessProcessForm(BusinessProcessConditionVO vo) {
		// TODO Auto-generated method stub
		return vo.checkBusinessProcessForm();
	}

}
