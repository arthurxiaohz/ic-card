package test.net.iccard.bm.checkservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.checkservice.model.TblStlErrorDetail;
import cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager;
import org.hi.test.HiTestCase;

public class TestTblStlErrorDetailCase extends HiTestCase {


	public void testBusiness(){
		TblStlErrorDetailManager bizMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
	}
	
}