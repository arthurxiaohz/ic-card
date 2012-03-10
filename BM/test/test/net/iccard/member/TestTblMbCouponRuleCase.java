package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbCouponRule;
import cn.net.iccard.member.service.TblMbCouponRuleManager;
import org.hi.test.HiTestCase;

public class TestTblMbCouponRuleCase extends HiTestCase {


	public void testBusiness(){
		TblMbCouponRuleManager bizMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
	}
	
}