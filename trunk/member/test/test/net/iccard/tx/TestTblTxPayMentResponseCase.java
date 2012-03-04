package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;
import org.hi.test.HiTestCase;

public class TestTblTxPayMentResponseCase extends HiTestCase {


	public void testBusiness(){
		TblTxPayMentResponseManager bizMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
	}
	
}