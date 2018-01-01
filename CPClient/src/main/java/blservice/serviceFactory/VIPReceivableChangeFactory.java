package blservice.serviceFactory;

import blservice.VIPforAccountService.VIPReceivableChangeService;
import blservice.VIPforAccountService.VIPReceivableChangeServiceImpl;
/**
 * 请不要删除此类
 * 谢谢
 * @author zxy
 *
 */
public class VIPReceivableChangeFactory {
	public static VIPReceivableChangeService getVIPReceivableChangeService(){
		return new VIPReceivableChangeServiceImpl();
	}
}
