package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbPointExchangeRule;
import cn.net.iccard.member.service.TblMbPointExchangeRuleManager;
import org.hi.test.HiTestCase;

public class TestTblMbPointExchangeRuleCase extends HiTestCase {


	public void testBusiness(){
		TblMbPointExchangeRuleManager bizMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
	}
	
}