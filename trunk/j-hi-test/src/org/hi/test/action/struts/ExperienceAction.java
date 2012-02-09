package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.ExperiencePageInfo;
import org.hi.test.model.Experience;
import org.hi.test.service.ExperienceManager;

public class ExperienceAction extends BaseAction{
	private Experience experience;
	private ExperiencePageInfo pageInfo;
	private List<Experience> experiences;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存Experience
	 */
	public String saveExperience() throws Exception {
		ExperienceManager experienceMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
		if(super.perExecute(experience)!= null) return returnCommand();
		experienceMgr.saveExperience(experience);
		super.postExecute(experience);
		return returnCommand();
	}
	
	
	/**
	 * 删除Experience
	 */
	public String removeExperience() throws Exception {
		ExperienceManager experienceMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
		experienceMgr.removeExperienceById(experience.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些Experience
	 */
	public String removeAllExperience() throws Exception {
		ExperienceManager experienceMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer experienceid = new Integer( ids[i] );
				experienceMgr.removeExperienceById(experienceid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看Experience
	 */
	public String viewExperience() throws Exception {
		ExperienceManager experienceMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
		experience = experienceMgr.getExperienceById(experience.getId());
		return returnCommand();
	}
	
	/**
	 * Experience列表
	 */
	public String experienceList() throws Exception {
		ExperienceManager experienceMgr = (ExperienceManager)SpringContextHolder.getBean(Experience.class);
		pageInfo = pageInfo == null ? new ExperiencePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		experiences = experienceMgr.getSecurityExperienceList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public ExperiencePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(ExperiencePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
