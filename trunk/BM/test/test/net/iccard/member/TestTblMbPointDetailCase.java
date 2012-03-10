package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbPointDetail;
import cn.net.iccard.member.service.TblMbPointDetailManager;
import org.hi.test.HiTestCase;

public class TestTblMbPointDetailCase extends HiTestCase {


	public void testBusiness(){
		TblMbPointDetailManager bizMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
	}
	
}