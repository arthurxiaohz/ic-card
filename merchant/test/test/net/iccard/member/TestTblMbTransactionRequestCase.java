package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;
import org.hi.test.HiTestCase;

public class TestTblMbTransactionRequestCase extends HiTestCase {


	public void testBusiness(){
		TblMbTransactionRequestManager bizMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
	}
	
}