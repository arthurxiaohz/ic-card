package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.StaffPageInfo;
import org.hi.test.model.Staff;
import org.hi.test.service.StaffManager;

public class StaffAction extends BaseAction{
	private Staff staff;
	private StaffPageInfo pageInfo;
	private List<Staff> staffs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存staff
	 */
	public String saveStaff() throws Exception {
		StaffManager staffMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
		if(super.perExecute(staff)!= null) return returnCommand();
		staffMgr.saveStaff(staff);
		super.postExecute(staff);
		return returnCommand();
	}
	
	
	/**
	 * 删除staff
	 */
	public String removeStaff() throws Exception {
		StaffManager staffMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
		staffMgr.removeStaffById(staff.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些staff
	 */
	public String removeAllStaff() throws Exception {
		StaffManager staffMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer staffid = new Integer( ids[i] );
				staffMgr.removeStaffById(staffid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看staff
	 */
	public String viewStaff() throws Exception {
		StaffManager staffMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
		staff = staffMgr.getStaffById(staff.getId());
		return returnCommand();
	}
	
	/**
	 * staff列表
	 */
	public String staffList() throws Exception {
		StaffManager staffMgr = (StaffManager)SpringContextHolder.getBean(Staff.class);
		pageInfo = pageInfo == null ? new StaffPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		staffs = staffMgr.getSecurityStaffList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public StaffPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(StaffPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
