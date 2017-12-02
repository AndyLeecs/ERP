package VO.storeVO;

public class ReportListVO {
   public  StoreListType st;
    public int actualNum;
    public int Num;
   public  int delta;
   public  String goodsID;
   public  String listID;
   public  String GoodsName;

    ReportListVO(int actualNum,int Num,String goodsID,String listID,String GoodsName){
        this.actualNum=actualNum;
        this.Num=Num;
        this.GoodsName=GoodsName;
        this.goodsID=goodsID;
        this.listID=listID;
        if(actualNum>Num){
            this.st=StoreListType.OVERFLOW;
            this.delta=actualNum-Num;
        }else if(actualNum<Num){
            this.st=StoreListType.LOSS;
            this.delta=Num-actualNum;
        }
    }
}
