package bl.listbl;

public interface Approvable {
    // 这个接口是所有需要审批的单据必须实现的接口。
    /*
    * 这里我解释一下单据通过审批之后的逻辑：
    * 1，任何单据过审批之后，调用自己包内的check方法，检查修改后各项数据的合法性
    * 2， 如果数据不合法，调用fail方法，返回相应内容或进行相关处理
    * 3，如果数据合法，调用replace方法替换掉数据库内的原有单据，并调用refresh方法改写其他数据库中的各项数据
    * 这里onApprove 方法给定了审批时的逻辑关系
    * fail 方法中，规定返回的string 是错误信息
     */

    public  boolean check();
    public void replace();
    public void refresh();
    public String fail();
    public default String onApprove(){
        if(check()){
            replace();
            refresh();
            return "success";
        }else{

            return fail();
        }

    }
}
