package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbPointRule;
import cn.net.iccard.member.service.TblMbPointRuleManager;
import org.hi.test.HiTestCase;

public class TestTblMbPointRuleCase extends HiTestCase {


	public void testBusiness(){
		TblMbPointRuleManager bizMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
	}
	
}