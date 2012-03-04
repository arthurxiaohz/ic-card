package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxSmsLog;
import cn.net.iccard.tx.service.TblTxSmsLogManager;
import org.hi.test.HiTestCase;

public class TestTblTxSmsLogCase extends HiTestCase {


	public void testBusiness(){
		TblTxSmsLogManager bizMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
	}
	
}