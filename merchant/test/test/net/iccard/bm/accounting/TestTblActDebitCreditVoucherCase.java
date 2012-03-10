package test.net.iccard.bm.accounting;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager;
import org.hi.test.HiTestCase;

public class TestTblActDebitCreditVoucherCase extends HiTestCase {


	public void testBusiness(){
		TblActDebitCreditVoucherManager bizMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
	}
	
}