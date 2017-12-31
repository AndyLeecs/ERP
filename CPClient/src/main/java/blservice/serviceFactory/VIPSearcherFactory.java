package blservice.serviceFactory;

import bl.VIPbl.VIPFuzzySearch;
import bl.VIPbl.VIPFuzzySearchImpl;

public class VIPSearcherFactory {
	public static VIPFuzzySearch getVIPFuzzySearchService(){
		return new VIPFuzzySearchImpl();
	}
}
