package test.net.iccard.bm.accounting;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import cn.net.iccard.bm.accounting.service.TblActAccountDetailManager;
import org.hi.test.HiTestCase;

public class TestTblActAccountDetailCase extends HiTestCase {


	public void testBusiness(){
		TblActAccountDetailManager bizMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
	}
	
}