package test.net.iccard.bm.settleservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;
import org.hi.test.HiTestCase;

public class TestTblStlCleaningDetailCase extends HiTestCase {


	public void testBusiness(){
		TblStlCleaningDetailManager bizMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
	}
	
}