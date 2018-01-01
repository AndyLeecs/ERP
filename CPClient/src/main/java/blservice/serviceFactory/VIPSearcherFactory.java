package blservice.serviceFactory;

import blservice.VIPblservice.VIPFuzzySearch;
import bl.VIPbl.VIPFuzzySearchImpl;

public class VIPSearcherFactory {
	public static VIPFuzzySearch getVIPFuzzySearchService(){
		return new VIPFuzzySearchImpl();
	}
}
