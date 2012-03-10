package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxTransferRequest;
import cn.net.iccard.tx.service.TblTxTransferRequestManager;
import org.hi.test.HiTestCase;

public class TestTblTxTransferRequestCase extends HiTestCase {


	public void testBusiness(){
		TblTxTransferRequestManager bizMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
	}
	
}