package org.hi.metadata.hsc.constant;

public class ORMappingType {
	
	public static final String ORM_TYPE_HIBERNATE = "hibernate";
	public static final String ORM_TYPE_IBATIS = "ibatis";
	public static final String ORM_TYPE_IBATIS3 = "ibatis3";
	
	public static String getOutputFileType(String ormType){
		if(ormType.equals(ORM_TYPE_HIBERNATE))
			return ".hbm.xml" ;
		if(ormType.equals(ORM_TYPE_IBATIS))
			return ".ism.xml" ;
		if(ormType.equals(ORM_TYPE_IBATIS3))
			return ".ism3.xml" ;
		return "";
	}
	
	public static String templateFileName(String ormType){
		if(ormType.equals(ORM_TYPE_HIBERNATE))
			return "hbm.hbm" ;
		if(ormType.equals(ORM_TYPE_IBATIS))
			return "ism.ism" ;
		if(ormType.equals(ORM_TYPE_IBATIS3))
			return "ism3.ism3" ;
		return "";
	}
	
}
