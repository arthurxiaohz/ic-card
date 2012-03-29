package cn.net.iccard.login;

import org.acegisecurity.Authentication;
import org.acegisecurity.userdetails.UserDetails;
import org.hi.SpringContextHolder;
import org.hi.framework.security.acegi.DaoAuthenticationUserDetailProvider;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.web.ServletContext;

import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class CustomizeDaoAuthenticationUserDetailProvider extends
		DaoAuthenticationUserDetailProvider {

	@Override
	protected Authentication createSuccessAuthentication(Object principal,
			Authentication authentication, UserDetails user) {

		Authentication _authentication = super.createSuccessAuthentication(
				principal, authentication, user);

		// 更新session中预支付订单id所对应订单的userName和creator
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager) SpringContextHolder
				.getBean(TblTxPayMentOrder.class);

		// 预支付
		Integer id = (Integer) ServletContext.getRequest().getSession()
				.getAttribute("prepaidId");

		if (null == id) {
			// 撤消
			id = (Integer) ServletContext.getRequest().getSession()
					.getAttribute("revocationId");
		}
		if (null == id) {
			// 退款
			id = (Integer) ServletContext.getRequest().getSession()
					.getAttribute("backId");
		}

		if (null != id) {
			TblTxPayMentOrder tblTxPayMentOrderTmp = tblTxPayMentOrderMgr
					.getTblTxPayMentOrderById(id);
			if (null == tblTxPayMentOrderTmp.getUserName()) {

				tblTxPayMentOrderTmp.setUserName(user.getUsername());
				tblTxPayMentOrderTmp.setCreator(((UserContext) user).getUser());
				tblTxPayMentOrderMgr
						.saveTblTxPayMentOrder(tblTxPayMentOrderTmp);
			}
		}

		return _authentication;
	}
}
