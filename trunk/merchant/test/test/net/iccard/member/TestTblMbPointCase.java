package test.net.iccard.member;

import org.hi.SpringContextHolder;
import cn.net.iccard.member.model.TblMbPoint;
import cn.net.iccard.member.service.TblMbPointManager;
import org.hi.test.HiTestCase;

public class TestTblMbPointCase extends HiTestCase {


	public void testBusiness(){
		TblMbPointManager bizMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
	}
	
}