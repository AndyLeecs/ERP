package bl.listbl;

import VO.listVO.ListRM;

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
    public ListRM toExcel(String  id);//把某一项表单导出excel.所有能够被审批的表单都必须实现这个方法。
    public default String onApprove(){
        if(check()){
            replace();
            refresh();  
            return "success";
        }else{

            return fail();
        }
        //这里写成default ，目的是规定审批操作的流程。
        // 对于具体的单据，在replace和refresh里面调用其他方法，操作数据，所以这两个方法本身是无参数的。（参数也不方便统一）
    }
}
