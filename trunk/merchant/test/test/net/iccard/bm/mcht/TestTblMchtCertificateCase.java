package test.net.iccard.bm.mcht;

import org.hi.SpringContextHolder;
import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import cn.net.iccard.bm.mcht.service.TblMchtCertificateManager;
import org.hi.test.HiTestCase;

public class TestTblMchtCertificateCase extends HiTestCase {


	public void testBusiness(){
		TblMchtCertificateManager bizMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
	}
	
}