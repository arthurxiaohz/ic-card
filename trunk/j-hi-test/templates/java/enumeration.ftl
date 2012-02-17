package ${service.packageName}.model;

import java.io.Serializable;

public class ${entity.entityName?cap_first} implements Serializable{

<#list entity.enumeration as enumeration>
	/**
	 * ${enumeration.enuLabel}
	 */
	public static final int ${entity.entityName?upper_case}_${enumeration.enuValue?upper_case} = ${(serviceTool.getSeedData(service, entity) + enumeration_index)?c};
</#list>

}