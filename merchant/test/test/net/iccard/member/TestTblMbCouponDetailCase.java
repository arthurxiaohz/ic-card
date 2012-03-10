package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbCouponDetail;
import cn.net.iccard.member.service.TblMbCouponDetailManager;
import org.hi.test.HiTestCase;

public class TestTblMbCouponDetailCase extends HiTestCase {


	public void testBusiness(){
		TblMbCouponDetailManager bizMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
	}
	
}