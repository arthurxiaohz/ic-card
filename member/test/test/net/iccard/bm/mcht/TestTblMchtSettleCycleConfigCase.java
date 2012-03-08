package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtSettleCycleConfig;
import cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager;
import org.hi.test.HiTestCase;

public class TestTblMchtSettleCycleConfigCase extends HiTestCase {


	public void testBusiness(){
		TblMchtSettleCycleConfigManager bizMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
	}
	
}