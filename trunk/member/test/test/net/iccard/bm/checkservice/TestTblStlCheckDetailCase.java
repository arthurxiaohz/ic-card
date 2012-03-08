package test.net.iccard.bm.checkservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.checkservice.model.TblStlCheckDetail;
import cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager;
import org.hi.test.HiTestCase;

public class TestTblStlCheckDetailCase extends HiTestCase {


	public void testBusiness(){
		TblStlCheckDetailManager bizMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
	}
	
}