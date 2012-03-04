package test.hi.memberservice;

import org.hi.SpringContextHolder;
import org.hi.memberservice.model.TblMbRechargeOrder;
import org.hi.memberservice.service.TblMbRechargeOrderManager;
import org.hi.test.HiTestCase;

public class TestTblMbRechargeOrderCase extends HiTestCase {


	public void testBusiness(){
		TblMbRechargeOrderManager bizMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
	}
	
}