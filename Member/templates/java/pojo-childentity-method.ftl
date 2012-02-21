<#list entity.childEntity as child>
    public void set${child.childEntityName?cap_first}s(List<${child.childEntityName?cap_first}> ${child.childEntityName?uncap_first}s) {
        this.${child.childEntityName?uncap_first}s = ${child.childEntityName?uncap_first}s;
    }

    public List<${child.childEntityName?cap_first}> get${child.childEntityName?cap_first}s() {
        return this.${child.childEntityName?uncap_first}s;
    }
</#list>
    