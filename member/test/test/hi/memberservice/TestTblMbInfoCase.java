package test.hi.memberservice;

import org.hi.SpringContextHolder;
import org.hi.memberservice.model.TblMbInfo;
import org.hi.memberservice.service.TblMbInfoManager;
import org.hi.test.HiTestCase;

public class TestTblMbInfoCase extends HiTestCase {


	public void testBusiness(){
		TblMbInfoManager bizMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
	}
	
}