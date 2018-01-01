package blservice.serviceFactory;

import blservice.VIPblservice.VIPFuzzySearch;
import bl.VIPbl.VIPFuzzySearchImpl;
/**
 * 请不要删除此类
 * 谢谢
 * @author zxy
 *
 */
public class VIPSearcherFactory {
	public static VIPFuzzySearch getVIPFuzzySearchService(){
		return new VIPFuzzySearchImpl();
	}
}
