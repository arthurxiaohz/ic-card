<#assign pageInfoFieldName = field.fieldName?uncap_first>

    public ${serviceTool.getFieldType(field)} getF_${pageInfoFieldName}() {
        return this.f_${pageInfoFieldName};
    }
    
    public void setF_${pageInfoFieldName}(${serviceTool.getFieldType(field)} f_${pageInfoFieldName}) {
        this.f_${pageInfoFieldName} = f_${pageInfoFieldName};
    }
    
    public String getF_${pageInfoFieldName}_op() {
        return this.f_${pageInfoFieldName}_op;
    }
    
    public void setF_${pageInfoFieldName}_op(String f_${pageInfoFieldName}_op) {
        this.f_${pageInfoFieldName}_op = f_${pageInfoFieldName}_op;
    }
<#if fieldType == 4 || fieldType == 5>
    public ${serviceTool.getFieldType(field)} getF_${pageInfoFieldName}01() {
        return this.f_${pageInfoFieldName}01;
    }
    
    public void setF_${pageInfoFieldName}01(${serviceTool.getFieldType(field)} f_${pageInfoFieldName}01) {
        this.f_${pageInfoFieldName}01 = f_${pageInfoFieldName}01;
    }
    
    public String getF_${pageInfoFieldName}01_op() {
        return this.f_${pageInfoFieldName}01_op;
    }
    
    public void setF_${pageInfoFieldName}01_op(String f_${pageInfoFieldName}01_op) {
        this.f_${pageInfoFieldName}01_op = f_${pageInfoFieldName}01_op;
    }
</#if>   