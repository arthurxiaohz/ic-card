package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.test.action.StaffPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class ExperiencePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Timestamp  f_startTime;
 	protected  String  f_startTime_op;
	protected  Timestamp  f_startTime01;
	protected  String  f_startTime01_op;
	protected  Timestamp  f_endTime;
 	protected  String  f_endTime_op;
	protected  Timestamp  f_endTime01;
	protected  String  f_endTime01_op;
	protected  String  f_place;
 	protected  String  f_place_op;
	protected  String  f_task;
 	protected  String  f_task_op;
	protected  String  f_people;
 	protected  String  f_people_op;

 	protected  StaffPageInfo staff;
 	protected  HiUserPageInfo creator;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public Timestamp getF_startTime() {
        return this.f_startTime;
    }
    
    public void setF_startTime(Timestamp f_startTime) {
        this.f_startTime = f_startTime;
    }
    
    public String getF_startTime_op() {
        return this.f_startTime_op;
    }
    
    public void setF_startTime_op(String f_startTime_op) {
        this.f_startTime_op = f_startTime_op;
    }
    public Timestamp getF_startTime01() {
        return this.f_startTime01;
    }
    
    public void setF_startTime01(Timestamp f_startTime01) {
        this.f_startTime01 = f_startTime01;
    }
    
    public String getF_startTime01_op() {
        return this.f_startTime01_op;
    }
    
    public void setF_startTime01_op(String f_startTime01_op) {
        this.f_startTime01_op = f_startTime01_op;
    }
   
    public Timestamp getF_endTime() {
        return this.f_endTime;
    }
    
    public void setF_endTime(Timestamp f_endTime) {
        this.f_endTime = f_endTime;
    }
    
    public String getF_endTime_op() {
        return this.f_endTime_op;
    }
    
    public void setF_endTime_op(String f_endTime_op) {
        this.f_endTime_op = f_endTime_op;
    }
    public Timestamp getF_endTime01() {
        return this.f_endTime01;
    }
    
    public void setF_endTime01(Timestamp f_endTime01) {
        this.f_endTime01 = f_endTime01;
    }
    
    public String getF_endTime01_op() {
        return this.f_endTime01_op;
    }
    
    public void setF_endTime01_op(String f_endTime01_op) {
        this.f_endTime01_op = f_endTime01_op;
    }
   
    public String getF_place() {
        return this.f_place;
    }
    
    public void setF_place(String f_place) {
        this.f_place = f_place;
    }
    
    public String getF_place_op() {
        return this.f_place_op;
    }
    
    public void setF_place_op(String f_place_op) {
        this.f_place_op = f_place_op;
    }
   
    public String getF_task() {
        return this.f_task;
    }
    
    public void setF_task(String f_task) {
        this.f_task = f_task;
    }
    
    public String getF_task_op() {
        return this.f_task_op;
    }
    
    public void setF_task_op(String f_task_op) {
        this.f_task_op = f_task_op;
    }
   
    public String getF_people() {
        return this.f_people;
    }
    
    public void setF_people(String f_people) {
        this.f_people = f_people;
    }
    
    public String getF_people_op() {
        return this.f_people_op;
    }
    
    public void setF_people_op(String f_people_op) {
        this.f_people_op = f_people_op;
    }
   
	public StaffPageInfo getStaff() {
		return staff;
	}

	public void setStaff(StaffPageInfo staff) {
		this.staff = staff;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
