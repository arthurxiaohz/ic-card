package test.net.iccard.bm.checkservice;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.checkservice.model.TblStlCheckOrganizationControl;
import cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager;
import org.hi.test.HiTestCase;

public class TestTblStlCheckOrganizationControlCase extends HiTestCase {


	public void testBusiness(){
		TblStlCheckOrganizationControlManager bizMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
	}
	
}