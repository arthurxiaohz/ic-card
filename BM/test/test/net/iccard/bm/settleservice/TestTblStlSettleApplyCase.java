package test.net.iccard.bm.settleservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager;
import org.hi.test.HiTestCase;

public class TestTblStlSettleApplyCase extends HiTestCase {


	public void testBusiness(){
		TblStlSettleApplyManager bizMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
	}
	
}