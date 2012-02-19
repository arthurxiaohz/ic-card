package ${service.packageName}.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import ${service.packageName}.action.${entity.entityName?cap_first}PageInfo;
import ${service.packageName}.model.${entity.entityName?cap_first};
import ${service.packageName}.service.${entity.entityName?cap_first}Manager;

public class ${entity.entityName?cap_first}Action extends BaseAction{
	private ${entity.entityName?cap_first} ${entity.entityName?uncap_first};
	private ${entity.entityName?cap_first}PageInfo pageInfo;
	private List<${entity.entityName?cap_first}> ${entity.entityName?uncap_first}s;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存${entity.entityLabel}
	 */
	public String save${entity.entityName?cap_first}() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		if(super.perExecute(${entity.entityName?uncap_first})!= null) return returnCommand();
		${entity.entityName?uncap_first}Mgr.save${entity.entityName?cap_first}(${entity.entityName?uncap_first});
		super.postExecute(${entity.entityName?uncap_first});
		return returnCommand();
	}
	
	
	/**
	 * 删除${entity.entityLabel}
	 */
	public String remove${entity.entityName?cap_first}() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		${entity.entityName?uncap_first}Mgr.remove${entity.entityName?cap_first}ById(${entity.entityName?uncap_first}.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些${entity.entityLabel}
	 */
	public String removeAll${entity.entityName?cap_first}() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer ${entity.entityName?uncap_first}id = new Integer( ids[i] );
				${entity.entityName?uncap_first}Mgr.remove${entity.entityName?cap_first}ById(${entity.entityName?uncap_first}id);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看${entity.entityLabel}
	 */
	public String view${entity.entityName?cap_first}() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		${entity.entityName?uncap_first} = ${entity.entityName?uncap_first}Mgr.get${entity.entityName?cap_first}ById(${entity.entityName?uncap_first}.getId());
		return returnCommand();
	}
	
	/**
	 * ${entity.entityLabel}列表
	 */
	public String ${entity.entityName?uncap_first}List() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		pageInfo = pageInfo == null ? new ${entity.entityName?cap_first}PageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		${entity.entityName?uncap_first}s = ${entity.entityName?uncap_first}Mgr.getSecurity${entity.entityName?cap_first}List(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public ${entity.entityName?cap_first} get${entity.entityName?cap_first}() {
		return ${entity.entityName?uncap_first};
	}

	public void set${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}) {
		this.${entity.entityName?uncap_first} = ${entity.entityName?uncap_first};
	}
	
	public List<${entity.entityName?cap_first}> get${entity.entityName?cap_first}s() {
		return ${entity.entityName?uncap_first}s;
	}

	public void set${entity.entityName?cap_first}s(List<${entity.entityName?cap_first}> ${entity.entityName?uncap_first}s) {
		this.${entity.entityName?uncap_first}s = ${entity.entityName?uncap_first}s;
	}

	public ${entity.entityName?cap_first}PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(${entity.entityName?cap_first}PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
