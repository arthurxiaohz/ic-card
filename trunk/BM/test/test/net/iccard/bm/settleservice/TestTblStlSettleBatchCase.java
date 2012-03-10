package test.net.iccard.bm.settleservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager;
import org.hi.test.HiTestCase;

public class TestTblStlSettleBatchCase extends HiTestCase {


	public void testBusiness(){
		TblStlSettleBatchManager bizMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
	}
	
}