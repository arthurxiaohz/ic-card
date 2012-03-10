package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;
import org.hi.test.HiTestCase;

public class TestTblMchtUserCase extends HiTestCase {


	public void testBusiness(){
		TblMchtUserManager bizMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
	}
	
}