package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.MbMchtInf;
import org.hi.test.service.MbMchtInfManager;
import org.hi.test.HiTestCase;

public class TestMbMchtInfCase extends HiTestCase {


	public void testBusiness(){
		MbMchtInfManager bizMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
	}
	
}