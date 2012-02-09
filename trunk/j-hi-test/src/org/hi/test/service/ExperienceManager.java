package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Experience;
import org.hi.framework.service.Manager;

public interface ExperienceManager extends Manager{
    
    public void saveExperience(Experience experience);

    public void removeExperienceById(Integer id);

    public Experience getExperienceById(Integer id);

    public List<Experience> getExperienceList(PageInfo pageInfo);
    
    public void saveSecurityExperience(Experience experience);

    public void removeSecurityExperienceById(Integer id);

    public Experience getSecurityExperienceById(Integer id);

    public List<Experience> getSecurityExperienceList(PageInfo pageInfo);    
}
