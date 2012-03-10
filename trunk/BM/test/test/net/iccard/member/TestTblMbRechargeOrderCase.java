package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;
import org.hi.test.HiTestCase;

public class TestTblMbRechargeOrderCase extends HiTestCase {


	public void testBusiness(){
		TblMbRechargeOrderManager bizMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
	}
	
}