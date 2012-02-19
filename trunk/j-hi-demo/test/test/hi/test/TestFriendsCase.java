package test.hi.test;

import org.hi.SpringContextHolder;
import org.hi.test.model.Friends;
import org.hi.test.service.FriendsManager;
import org.hi.test.HiTestCase;

public class TestFriendsCase extends HiTestCase {


	public void testBusiness(){
		FriendsManager bizMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
	}
	
}