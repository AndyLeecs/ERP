package bl.salebl;

import bl.listbl.SalesBussinessSituation;

public class SalesBussinessSituation_Impl implements SalesBussinessSituation {
	/*
	 * 把所有销售单遍历一遍，累加一下每张单据的折让后金额，返回加起来的数值
	 */
	@Override
	public double getSalesIncome() {
		// 获取折让后销售总收入
		return 0;
	}

    /*
     * 把所有销售单遍历一遍，累加一下每张单据总共折让了多少钱，返回加起来的数值
     */
	@Override
	public double getSalesDiscount() {
		// 获取销售折让总额
		return 0;
	}

	/*
     * 把所有销售退货单据遍历一遍，计算单据金额之和
     */
	@Override
	public double getSalesReturnOutcome() {
		// 获取销售退货支出总额
		return 0;
	}

	/*
     * 把所有进货退货单据遍历一遍，计算所有单据金额之和
     */
	@Override
	public double getStockReturnIncome() {
		// 获取进货退货收入总额
		return 0;
	}

	/*
     * 把所有进货单遍历一遍，计算所有单据金额之和
     */
	@Override
	public double getstockOutcome() {
		// 获取进货支出总额
		return 0;
	}
    
}
