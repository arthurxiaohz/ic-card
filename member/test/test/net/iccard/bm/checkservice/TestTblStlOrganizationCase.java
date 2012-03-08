package test.net.iccard.bm.checkservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.checkservice.model.TblStlOrganization;
import cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager;
import org.hi.test.HiTestCase;

public class TestTblStlOrganizationCase extends HiTestCase {


	public void testBusiness(){
		TblStlOrganizationManager bizMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
	}
	
}