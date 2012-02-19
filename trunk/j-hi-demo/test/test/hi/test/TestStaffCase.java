package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.Staff;
import org.hi.test.service.StaffManager;
import org.hi.test.HiTestCase;

public class TestStaffCase extends HiTestCase {


	public void testBusiness(){
		StaffManager bizMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
	}
	
}