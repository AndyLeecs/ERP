package bl.accountbl;

import java.util.stream.Collectors;

import PO.account.CashExpenseListPO;
import PO.account.EntryItemPO;
import PO.account.FinanceListPO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.EntryItemVO;
import VO.accountVO.FinanceListVO;
import dataService.accountDataService.FinanceListDataService;
import util.DateUtil;

public class CashExpenseListImpl extends FinanceListImpl{
	public CashExpenseListImpl(FinanceListDataService dataService) {
		super(dataService);
	}

	@Override
	protected FinanceListPO voTopo(FinanceListVO vo) {
		CashExpenseListVO cvo = (CashExpenseListVO)vo;
		return new CashExpenseListPO(cvo.getId(),
									cvo.getOperator(),
									cvo.getOperatorId(),
									cvo.getState(),
									cvo.getAccount(),
									cvo.getEntryItem().stream().map(e -> entryItemVoToPo(e)).collect(Collectors.toList()),
									cvo.getTotalAmount(),
									DateUtil.getDateFromListID(cvo.getId())
									);
		
	}

	@Override
	protected FinanceListVO poTovo(FinanceListPO po) {
		CashExpenseListPO cpo = (CashExpenseListPO)po;
		return new CashExpenseListVO(cpo.getId(),
									cpo.getOperator(),
									cpo.getOperatorId(),
									cpo.getState(),
									cpo.getAccount(),
									cpo.getEntryItem().stream().map(e -> entryItemPoToVo(e)).collect(Collectors.toList()),
									cpo.getTotalAmount()
									);
	}
	
	private EntryItemPO entryItemVoToPo(EntryItemVO vo){
		return new EntryItemPO(vo.getEntryName(),vo.getAmount(),vo.getNote());
	}
	
	private EntryItemVO entryItemPoToVo(EntryItemPO po){
		return new EntryItemVO(po.getEntryName(),po.getAmount(),po.getNote());
	}

}
