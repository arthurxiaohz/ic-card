package ${packageName};

import org.hi.SpringContextHolder;
import ${service.packageName}.model.${entity.entityName?cap_first};
import ${service.packageName}.service.${entity.entityName?cap_first}Manager;
import org.hi.test.HiTestCase;

public class Test${entity.entityName?cap_first}Case extends HiTestCase {


	public void testBusiness(){
		${entity.entityName?cap_first}Manager bizMgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
	}
	
}