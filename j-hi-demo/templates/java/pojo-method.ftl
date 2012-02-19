    public ${serviceTool.getFieldType(field)} get${field.fieldName?cap_first}() {
        return this.${field.fieldName};
    }
    
    public void set${field.fieldName?cap_first}(${serviceTool.getFieldType(field)} ${field.fieldName}) {
    		if((${field.fieldName} != null && this.${field.fieldName} == null) || 
				this.${field.fieldName} != null && (!this.${field.fieldName}.equals(${field.fieldName}) || ${field.fieldName} == null)){
        		this.setDirty(true);
        		this.oldValues.put("${field.fieldName}", this.${field.fieldName});
        	}
        this.${field.fieldName} = ${field.fieldName};
    }
    
    <#if field.isPrimaryKey && entity.entityType != 3>
     public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
    		if((version != null && this.version == null) || 
				this.version != null && (!this.version.equals(version) || version == null)){
        		this.setDirty(true);
        		this.oldValues.put("version", this.version);
        	}
        this.version = version;
    }
    
    </#if>
<#if field.isParent && serviceTool.getParentEntity(entity, allServices)?exists>
   public BaseObject getParentEntity(){
	   return this.${field.fieldName?uncap_first};
   }
   
   public void setParentEntity(BaseObject parent){
	   this.${field.fieldName?uncap_first} = (${serviceTool.getFieldType(field)})parent;
   }
   
</#if>
 	