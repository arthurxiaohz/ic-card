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

		Integer id = (Integer) ServletContext.getRequest().getSession()
				.getAttribute("id");

		if (null != id) {
			TblTxPayMentOrder tblTxPayMentOrderTmp = tblTxPayMentOrderMgr
					.getTblTxPayMentOrderById(id);
			if (null == tblTxPayMentOrderTmp.getCreator()) {

				tblTxPayMentOrderTmp.setUserName(user.getUsername());
				tblTxPayMentOrderTmp.setCreator(((UserContext) user).getUser());
				tblTxPayMentOrderMgr
						.saveTblTxPayMentOrder(tblTxPayMentOrderTmp);
			}
		}

		return _authentication;
	}
}
