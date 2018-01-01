package blservice.VIPblservice;
/**
 * VIP收付款时修改他应收应付账款的接口
 * @author zxy
 *
 */
public interface VIPReceivableChangeService {
	public boolean collect(String VIPID, double amount);	//向客户收款amount，减少其应收，返回是否成功
	public boolean pay(String VIPID, double amount);		//向客户付款amount，减少其应付，返回是否成功
}
