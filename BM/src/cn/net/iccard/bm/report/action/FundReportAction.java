package cn.net.iccard.bm.report.action;

import java.util.Date;
import java.util.List;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.base.report.excel.action.struts.JXLSExcelBaseAction;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.bm.settleservice.model.SettleApplyStatus;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager;
import cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager;

/**
 * 资金划付表
 * 
 * @author Angi
 * 
 */
public class FundReportAction extends JXLSExcelBaseAction {

	private TblStlSettleBatch tblStlSettleBatch;

	private String currentDate = DateUtils.format(new Date(), "yyyy/MM/dd");

	private List resultList;

	@Override
	public void prepare() {
		TblStlSettleBatchManager tblStlSettleBatchManagerMgr = (TblStlSettleBatchManager) SpringContextHolder
				.getBean(TblStlSettleBatch.class);
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager) SpringContextHolder
				.getBean(TblStlSettleApply.class);
		int id = Integer.parseInt(getParameter("id"));
		tblStlSettleBatch = tblStlSettleBatchManagerMgr
				.getTblStlSettleBatchById(id);
		// 结算中
		resultList = tblStlSettleApplyMgr.getObjects(FilterFactory
				.getSimpleFilter("tblStlSettleBatch", id).addCondition(
						"settleApplyStatus",
						SettleApplyStatus.SETTLEAPPLYSTATUS_SETTLING));
	}

	public TblStlSettleBatch getTblStlSettleBatch() {
		return tblStlSettleBatch;
	}

	public void setTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch) {
		this.tblStlSettleBatch = tblStlSettleBatch;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

}
