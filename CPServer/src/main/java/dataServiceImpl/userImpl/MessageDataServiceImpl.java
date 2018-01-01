package dataServiceImpl.userImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.user.MessagePO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.HibernateUtil;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.userDataService.MessageDataService;
import resultmessage.DataRM;
import util.UserType;

public class MessageDataServiceImpl extends UnicastRemoteObject implements MessageDataService{

	
	private static final long serialVersionUID = 5801522716518730770L;
	BasicUtil<MessagePO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;

	public MessageDataServiceImpl() throws RemoteException {
		basicUtil = new HibernateUtil<MessagePO>(MessagePO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}

	@Override
	public List<MessagePO> getAllMessage(UserType type) throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"type", type);
		OrderClause o = orderClauseGenerator.generateDescOrder("date");
		return basicUtil.Query(l, o);	
	}

	@Override
	public DataRM insert(MessagePO po) throws RemoteException {
		int id = basicUtil.insertForAuto(po);
		if(id == -2)
			return DataRM.EXIST;
		if(id == -1)
			return DataRM.FAILED;
		return DataRM.SUCCESS;
	}

	

	

}
