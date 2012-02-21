   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ${entity.entityName}) ) return false;
		 ${entity.entityName} castOther = ( ${entity.entityName} ) other; 
		 
         <#assign pkFeild = serviceTool.getPKField(entity)>
		 return <#if serviceTool.hasPK(entity)> ( (this.get${pkFeild.fieldName?cap_first}()==castOther.get${pkFeild.fieldName?cap_first}()) || ( this.get${pkFeild.fieldName?cap_first}()!=null && castOther.get${pkFeild.fieldName?cap_first}()!=null && this.get${pkFeild.fieldName?cap_first}().equals(castOther.get${pkFeild.fieldName?cap_first}()) )<#else>super.equals(other)</#if> );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.<#if serviceTool.hasExtendEntity(entity)>appendSuper(super.hashCode())<#else>append(get${pkFeild.fieldName?cap_first}())</#if>;
		hcb.append("${entity.entityName?cap_first}".hashCode());
        return hcb.toHashCode();
    }