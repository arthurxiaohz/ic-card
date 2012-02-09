package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.Experience;
import org.hi.test.service.ExperienceManager;
import org.hi.test.HiTestCase;

public class TestExperienceCase extends HiTestCase {


	public void testBusiness(){
		ExperienceManager bizMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
	}
	
}