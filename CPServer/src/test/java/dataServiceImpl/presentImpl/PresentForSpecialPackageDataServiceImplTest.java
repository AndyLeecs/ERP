package dataServiceImpl.presentImpl;

import PO.GoodsInSalePO;
import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import org.junit.Test;
import util.DataRM;
import util.PresentState;
import util.VIPGrade;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by julia98 on 2017/12/29.
 */
public class PresentForSpecialPackageDataServiceImplTest {
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    PresentForSpecialPackagePO po = new PresentForSpecialPackagePO(1, Date.from(Instant.EPOCH),Date.from(Instant.now()),gpolist, PresentState.SAVE,1);
    

    @Test
    public void insert() throws Exception {
        assertEquals(1,new PresentForSpecialPackageDataServiceImpl().insert());
    }

    @Test
    public void deletePresentForSpecialPackage() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForSpecialPackageDataServiceImpl().deletePresentForSpecialPackage(1));
    }

    @Test
    public void update() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForSpecialPackageDataServiceImpl().update(po));
    }

    @Test
    public void getPresentForSpecialPackage() throws Exception {
        assertEquals(po,new PresentForSpecialPackageDataServiceImpl().getPresentForSpecialPackage());
    }

    @Test
    public void getPresentForSpecialPackage1() throws Exception {
        gpolist.add(gpo);
        assertEquals(po,new PresentForSpecialPackageDataServiceImpl().getPresentForSpecialPackage(gpolist));
    }

}