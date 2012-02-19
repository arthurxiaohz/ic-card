package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.FriendsPageInfo;
import org.hi.test.model.Friends;
import org.hi.test.service.FriendsManager;

public class FriendsAction extends BaseAction{
	private Friends friends;
	private FriendsPageInfo pageInfo;
	private List<Friends> friendss;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存朋友
	 */
	public String saveFriends() throws Exception {
		FriendsManager friendsMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
		if(super.perExecute(friends)!= null) return returnCommand();
		friendsMgr.saveFriends(friends);
		super.postExecute(friends);
		return returnCommand();
	}
	
	
	/**
	 * 删除朋友
	 */
	public String removeFriends() throws Exception {
		FriendsManager friendsMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
		friendsMgr.removeFriendsById(friends.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些朋友
	 */
	public String removeAllFriends() throws Exception {
		FriendsManager friendsMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer friendsid = new Integer( ids[i] );
				friendsMgr.removeFriendsById(friendsid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看朋友
	 */
	public String viewFriends() throws Exception {
		FriendsManager friendsMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
		friends = friendsMgr.getFriendsById(friends.getId());
		return returnCommand();
	}
	
	/**
	 * 朋友列表
	 */
	public String friendsList() throws Exception {
		FriendsManager friendsMgr = (FriendsManager)SpringContextHolder.getBean(Friends.class);
		pageInfo = pageInfo == null ? new FriendsPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		friendss = friendsMgr.getSecurityFriendsList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Friends getFriends() {
		return friends;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}
	
	public List<Friends> getFriendss() {
		return friendss;
	}

	public void setFriendss(List<Friends> friendss) {
		this.friendss = friendss;
	}

	public FriendsPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(FriendsPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
