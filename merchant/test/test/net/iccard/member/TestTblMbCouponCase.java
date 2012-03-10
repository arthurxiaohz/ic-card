package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbCoupon;
import cn.net.iccard.member.service.TblMbCouponManager;
import org.hi.test.HiTestCase;

public class TestTblMbCouponCase extends HiTestCase {


	public void testBusiness(){
		TblMbCouponManager bizMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
	}
	
}