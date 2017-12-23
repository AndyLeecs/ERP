import java.rmi.RemoteException;

import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;

public class TestCase{
	public static void main(String[]args)
	{
		try {
			PresentForSumDataServiceImpl p = new PresentForSumDataServiceImpl();
			System.out.println(p.getPresentForSum());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
