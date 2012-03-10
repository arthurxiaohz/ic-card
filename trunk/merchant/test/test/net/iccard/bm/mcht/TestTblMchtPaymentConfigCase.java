package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtPaymentConfig;
import cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager;
import org.hi.test.HiTestCase;

public class TestTblMchtPaymentConfigCase extends HiTestCase {


	public void testBusiness(){
		TblMchtPaymentConfigManager bizMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
	}
	
}