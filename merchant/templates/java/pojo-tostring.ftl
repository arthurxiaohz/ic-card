   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb<#list serviceTool.getToString(entity) as printPropery><#if printPropery_index != 0>		</#if>${printPropery}
       </#list>
      
        return sb.toString();
   }

<#if serviceTool.hasPK(entity)>   
   public Serializable getPrimarykey(){
   		return ${serviceTool.getPKField(entity).fieldName};
   }
</#if>

