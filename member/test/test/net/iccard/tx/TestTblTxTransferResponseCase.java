package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxTransferResponse;
import cn.net.iccard.tx.service.TblTxTransferResponseManager;
import org.hi.test.HiTestCase;

public class TestTblTxTransferResponseCase extends HiTestCase {


	public void testBusiness(){
		TblTxTransferResponseManager bizMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
	}
	
}