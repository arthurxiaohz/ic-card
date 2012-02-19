package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Friends;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.FriendsManager;

public class FriendsManagerImpl extends ManagerImpl implements FriendsManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveFriends(Friends friends){
    	saveObject(friends);
    
    }

    public void removeFriendsById(Integer id){
    	removeObjectById(id);
    	
    }

    public Friends getFriendsById(Integer id){
   		return (Friends) getObjectById(id);
    }

    public List<Friends> getFriendsList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityFriends(Friends friends){
    	saveObject(friends);
    
    }

    public void removeSecurityFriendsById(Integer id){
    	removeObjectById(id);
    	
    }

    public Friends getSecurityFriendsById(Integer id){
   		return (Friends) getObjectById(id);
    }

    public List<Friends> getSecurityFriendsList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
