package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.service.TblMbInfoManager;
import org.hi.test.HiTestCase;

public class TestTblMbInfoCase extends HiTestCase {


	public void testBusiness(){
		TblMbInfoManager bizMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
	}
	
}