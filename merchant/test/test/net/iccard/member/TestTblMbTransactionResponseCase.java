package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbTransactionResponse;
import cn.net.iccard.member.service.TblMbTransactionResponseManager;
import org.hi.test.HiTestCase;

public class TestTblMbTransactionResponseCase extends HiTestCase {


	public void testBusiness(){
		TblMbTransactionResponseManager bizMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
	}
	
}