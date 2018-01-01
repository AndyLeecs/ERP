package bl.accountbl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import PO.account.FinanceListPO;
import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import VO.listVO.InfoListVO;
import bl.listbl.InfoList;
import bl.listbl.InfoList_Impl;
import blservice.accountblservice.AccountManagementService;
import blservice.accountblservice.FinanceListService;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.ApproveRM;
import resultmessage.CommitListRM;
import resultmessage.DataRM;
import resultmessage.DeleteListRM;
import resultmessage.SaveListRM;
import util.GreatListType;
import util.State;

public abstract class FinanceListImpl implements FinanceListService{
	
	String id = null;
	State currentState = null;		//如果当前为编辑状态，那么结束服务时要删除对应id的单据

	FinanceListDataService dataService;
	InfoList infoListService = new InfoList_Impl();
	AccountManagementService accountManagementService = new AccountManagementServiceImpl();
	
	public FinanceListImpl(FinanceListDataService dataService){
		this.dataService = dataService;
	}
	
	@Override
	public String newList() {
		try {
			String newid = dataService.getNewListId();
			if(newid == null || newid == "")
				return null;
			currentState = State.IsEditting;
			id = newid;
			return newid;
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	@Override
	public void endService(){
		if(id != null && currentState == State.IsEditting){
			delete(id);
		}
	}

	@Override
	public DeleteListRM delete(String id) {
		try {
			 DataRM datarm = dataService.delete(id);
			 switch(datarm){
			 case SUCCESS:
				 return DeleteListRM.SUCCESS;
			 case NOT_EXIST:
				 return DeleteListRM.NOT_EXIST;
			case FAILED:
				return DeleteListRM.SERVER_ERROR;
			default:
				break;
			 }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return DeleteListRM.NETWORK_ERROR;

	}

	@Override
	public SaveListRM save(FinanceListVO vo) {
		FinanceListPO po = voTopo(vo);
		try {
			DataRM datarm = dataService.update(po);
			switch(datarm){
			case SUCCESS:
				currentState = State.IsDraft;
				return SaveListRM.SUCCESS;
			case NOT_EXIST:
					DataRM insertRm = dataService.insert(po);		//还是有这种情况的。。
					switch(insertRm){
					case FAILED:
						return SaveListRM.SERVER_ERROR;
					case SUCCESS:
						currentState = State.IsDraft;
						return SaveListRM.SUCCESS;
					default:
						break;
					}
					break;
			case FAILED:
				return SaveListRM.SERVER_ERROR;
			default:
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return SaveListRM.NETWORK_ERROR;
	}

	@Override
	public CommitListRM commit(FinanceListVO vo) {
		vo.setState(State.IsCommitted);
		SaveListRM saverm = save(vo);
		switch(saverm){
		case NETWORK_ERROR:
			return CommitListRM.NETWORK_ERROR;
		case SERVER_ERROR:
			return CommitListRM.SERVER_ERROR;
		case SUCCESS:
			currentState = State.IsCommitted;
			infoListService.register(new InfoListVO(vo.getId(),getGreatListType(),vo.getOperator(),getKeyInfo(vo)));
			return CommitListRM.SUCCESS;
		default:
			break;
		}
		return CommitListRM.SERVER_ERROR;		
	}

	@Override
	public List<? extends FinanceListVO> openDraft() {
		try {
			@SuppressWarnings("unchecked")
			List<? extends FinanceListPO> listpo = (List<? extends FinanceListPO>) dataService.getList(State.IsDraft);
			return listpo.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<? extends FinanceListVO> openCommitted() {
		try {
			@SuppressWarnings("unchecked")
			List<? extends FinanceListPO> listpo = (List<? extends FinanceListPO>) dataService.getList(State.IsCommitted);
			return listpo.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountVO> findAccount() {
		return new AccountManagementServiceImpl().getAllAccount();
	}
	
	public ApproveRM approve(FinanceListVO vo){
		vo.setState(State.IsApproved);
		try {
			DataRM datarm = dataService.update(voTopo(vo));
			switch(datarm){
			case FAILED:
				return ApproveRM.SERVER_ERROR;
			case SUCCESS:
				infoListService.modify(true, vo.getId());
				return ApproveRM.OK;
			default:
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return ApproveRM.NETWORK_ERROR;
		}
		return ApproveRM.WRONG;
	}
	
	public void reject(FinanceListVO vo){
		vo.setState(State.IsRefused);
		try {
			dataService.update(voTopo(vo));
			infoListService.modify(false, vo.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	protected abstract FinanceListPO voTopo(FinanceListVO vo);
	
	protected abstract FinanceListVO poTovo(FinanceListPO po);
	
	protected abstract GreatListType getGreatListType();
	
	protected abstract String getKeyInfo(FinanceListVO vo);
}
