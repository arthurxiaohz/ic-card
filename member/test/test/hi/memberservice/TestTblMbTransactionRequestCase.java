package test.hi.memberservice;

import org.hi.SpringContextHolder;
import org.hi.memberservice.model.TblMbTransactionRequest;
import org.hi.memberservice.service.TblMbTransactionRequestManager;
import org.hi.test.HiTestCase;

public class TestTblMbTransactionRequestCase extends HiTestCase {


	public void testBusiness(){
		TblMbTransactionRequestManager bizMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
	}
	
}