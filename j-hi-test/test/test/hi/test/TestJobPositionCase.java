package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.JobPosition;
import org.hi.test.service.JobPositionManager;
import org.hi.test.HiTestCase;

public class TestJobPositionCase extends HiTestCase {


	public void testBusiness(){
		JobPositionManager bizMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
	}
	
}