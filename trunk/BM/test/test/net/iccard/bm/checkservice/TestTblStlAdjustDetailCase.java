package test.net.iccard.bm.checkservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.checkservice.model.TblStlAdjustDetail;
import cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager;
import org.hi.test.HiTestCase;

public class TestTblStlAdjustDetailCase extends HiTestCase {


	public void testBusiness(){
		TblStlAdjustDetailManager bizMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
	}
	
}