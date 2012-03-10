package test.net.iccard.tx;

import org.hi.SpringContextHolder;
import cn.net.iccard.tx.model.TblTxTransfer;
import cn.net.iccard.tx.service.TblTxTransferManager;
import org.hi.test.HiTestCase;

public class TestTblTxTransferCase extends HiTestCase {


	public void testBusiness(){
		TblTxTransferManager bizMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
	}
	
}