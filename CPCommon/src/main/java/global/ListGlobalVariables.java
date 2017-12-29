package global;

/**
 * 对不起，我用了全局变量。。不过实在是无奈之举
 * 使用时，将用全路径进行引用
 * 想了想，其实那些resultmessage是不是也相当于全局变量
 * @author zxy
 *
 */
public interface ListGlobalVariables {
	public static final String LIST_FULL = "MAX";		//为了和网络异常情况区分开，单据已满时的返回的单据编号。

}
