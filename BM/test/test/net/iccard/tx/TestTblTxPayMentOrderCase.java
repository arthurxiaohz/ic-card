package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import org.hi.test.HiTestCase;

public class TestTblTxPayMentOrderCase extends HiTestCase {


	public void testBusiness(){
		TblTxPayMentOrderManager bizMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
	}
	
}