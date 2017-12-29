package dataServiceImpl.presentImpl;

import PO.GoodsInSalePO;
import PO.PresentForMembershipPO;
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
public class PresentForMembershipDataServiceImplTest {
    List<PresentForMembershipPO> list;
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    PresentForMembershipPO po = new PresentForMembershipPO(1, Date.from(Instant.EPOCH),Date.from(Instant.now()),1,gpolist, PresentState.SAVE,1, VIPGrade.GradeOne,1);


    @Test
    public void insert() throws Exception {
        assertEquals(1,new PresentForMembershipDataServiceImpl().insert());
    }

    @Test
    public void deletePresentForMembership() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForMembershipDataServiceImpl().deletePresentForMembership(1));
    }

    @Test
    public void update() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForMembershipDataServiceImpl().update(po));
    }

    @Test
    public void getPresentForMembership() throws Exception {
        assertEquals(list,new PresentForMembershipDataServiceImpl().getPresentForMembership());
    }

    @Test
    public void getPresentForMembership1() throws Exception {
        gpolist.add(gpo);
        assertEquals(list,new PresentForMembershipDataServiceImpl().getPresentForMembership(VIPGrade.GradeOne));
    }

}