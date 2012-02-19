package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Friends;
import org.hi.framework.service.Manager;

public interface FriendsManager extends Manager{
    
    public void saveFriends(Friends friends);

    public void removeFriendsById(Integer id);

    public Friends getFriendsById(Integer id);

    public List<Friends> getFriendsList(PageInfo pageInfo);
    
    public void saveSecurityFriends(Friends friends);

    public void removeSecurityFriendsById(Integer id);

    public Friends getSecurityFriendsById(Integer id);

    public List<Friends> getSecurityFriendsList(PageInfo pageInfo);    
}
