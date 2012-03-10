package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;
import org.hi.test.HiTestCase;

public class TestTblMchtInfoCase extends HiTestCase {


	public void testBusiness(){
		TblMchtInfoManager bizMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
	}
	
}