package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import org.hi.test.HiTestCase;

public class TestTblTxPayMentRequestCase extends HiTestCase {


	public void testBusiness(){
		TblTxPayMentRequestManager bizMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
	}
	
}