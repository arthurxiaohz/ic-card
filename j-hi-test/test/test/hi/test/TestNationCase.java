package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.Nation;
import org.hi.test.service.NationManager;
import org.hi.test.HiTestCase;

public class TestNationCase extends HiTestCase {


	public void testBusiness(){
		NationManager bizMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
	}
	
}