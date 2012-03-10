package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager;
import org.hi.test.HiTestCase;

public class TestTblMchtFeeConfigCase extends HiTestCase {


	public void testBusiness(){
		TblMchtFeeConfigManager bizMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
	}
	
}