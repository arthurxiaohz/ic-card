package test.net.iccard.bm.accounting;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager;
import org.hi.test.HiTestCase;

public class TestTblActTransferVoucherCase extends HiTestCase {


	public void testBusiness(){
		TblActTransferVoucherManager bizMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
	}
	
}