package cn.net.iccard.batch;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.base.schedule.quartz.JobDetail;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.bm.accounting.model.SettleStatus;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import cn.net.iccard.bm.accounting.service.TblActAccountDetailManager;
import cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager;

/**
 * 到期交易自动确认支付
 * 
 * @author Angi
 * 
 */
public class ExpiredTxAutoConfirm extends JobDetail {

	protected final Log log = LogFactory.getLog(getClass());

	private TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager) SpringContextHolder
			.getBean(TblActAccountDetail.class);

	private TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager) SpringContextHolder
			.getBean(TblActTransferVoucher.class);

	@Override
	public void execute() {

		List tblActAccountDetails = tblActAccountDetailMgr
				.getObjects(FilterFactory.getSimpleFilter("expiredDate",
						DateUtils.format(new Date(), "yyyyMMdd"),
						Filter.OPERATOR_LESS_EQ).addCondition("settleStatus",
						SettleStatus.SETTLESTATUS_TOSETTLED));
		if (null == tblActAccountDetails || tblActAccountDetails.size() == 0) {
			log.info("no guarantee");
			return;
		}

		for (int i = 0; i < tblActAccountDetails.size(); i++) {
			TblActAccountDetail tblActAccountDetail = (TblActAccountDetail) tblActAccountDetails
					.get(i);

			log
					.info(((TblActTransferVoucher) tblActTransferVoucherMgr
							.getObjects(
									FilterFactory.getSimpleFilter("voucherNo",
											tblActAccountDetail.getVoucherNo()))
							.get(0)).getId());

		}
	}
}
