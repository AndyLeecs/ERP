package bl.VIPbl;

/**
 * Created by julia98 on 2017/12/14.
 * 生成会员编号
 */
public class VIPUtility {
    int VIPIDcounter = 0;

    public String generateVIPID(){
        VIPIDcounter++;
        String VIPID = String.valueOf(VIPIDcounter);
        while(VIPID.length() < 8){
            VIPID = "0" + VIPID;
        }
        return VIPID;
    }
}
