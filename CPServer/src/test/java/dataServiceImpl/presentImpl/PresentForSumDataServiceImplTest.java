package dataServiceImpl.presentImpl;

import PO.GoodsInSalePO;
import PO.PresentForSumPO;
import org.junit.Test;
import util.DataRM;
import util.PresentState;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by julia98 on 2017/12/29.
 */
public class PresentForSumDataServiceImplTest {
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    PresentForSumPO po = new PresentForSumPO(1,Date.from(Instant.EPOCH), Date.from(Instant.now()),1, gpolist,PresentState.SAVE,1);
    List<PresentForSumPO> ppo = new ArrayList<>();
    @Test
    public void insert() throws Exception {
        assertEquals(1,new PresentForSumDataServiceImpl().insert());
    }

    @Test
    public void deletePresentForSum() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForSumDataServiceImpl().deletePresentForSum(1));
    }

    @Test
    public void update() throws Exception {
        gpolist.add(gpo);
        assertEquals(DataRM.SUCCESS,new PresentForSumDataServiceImpl().update(po));
    }

    @Test
    public void getPresentForSum() throws Exception {
        gpolist.add(gpo);
        ppo.add(po);
        assertEquals(ppo,new PresentForSumDataServiceImpl().getPresentForSum());
    }

    @Test
    public void getPresentForSum1() throws Exception {
        assertEquals(ppo,new PresentForSumDataServiceImpl().getPresentForSum(1));
    }

}