package test.hi.memberservice;

import org.hi.SpringContextHolder;
import org.hi.memberservice.model.TblMbTransactionResponse;
import org.hi.memberservice.service.TblMbTransactionResponseManager;
import org.hi.test.HiTestCase;

public class TestTblMbTransactionResponseCase extends HiTestCase {


	public void testBusiness(){
		TblMbTransactionResponseManager bizMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
	}
	
}