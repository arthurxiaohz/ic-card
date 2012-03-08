package test.net.iccard.bm.accounting;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.service.ActAccountManager;
import org.hi.test.HiTestCase;

public class TestActAccountCase extends HiTestCase {


	public void testBusiness(){
		ActAccountManager bizMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
	}
	
}