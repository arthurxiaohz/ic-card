package org.hi.i18n.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.Timezone;
import org.hi.framework.service.Manager;

public interface TimezoneManager extends Manager{
    
    public void saveTimezone(Timezone timezone);

    public void removeTimezoneById(Integer id);

    public Timezone getTimezoneById(Integer id);

    public List<Timezone> getTimezoneList(PageInfo pageInfo);
    
    public void saveSecurityTimezone(Timezone timezone);

    public void removeSecurityTimezoneById(Integer id);

    public Timezone getSecurityTimezoneById(Integer id);

    public List<Timezone> getSecurityTimezoneList(PageInfo pageInfo);    
}
