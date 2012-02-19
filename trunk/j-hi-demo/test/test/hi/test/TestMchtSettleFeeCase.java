package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.MchtSettleFee;
import org.hi.test.service.MchtSettleFeeManager;
import org.hi.test.HiTestCase;

public class TestMchtSettleFeeCase extends HiTestCase {


	public void testBusiness(){
		MchtSettleFeeManager bizMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
	}
	
}