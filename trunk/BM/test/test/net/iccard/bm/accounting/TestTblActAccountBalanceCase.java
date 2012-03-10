package test.net.iccard.bm.accounting;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import org.hi.test.HiTestCase;

public class TestTblActAccountBalanceCase extends HiTestCase {


	public void testBusiness(){
		TblActAccountBalanceManager bizMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
	}
	
}