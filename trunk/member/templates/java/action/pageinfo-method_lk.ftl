
	public ${lkField.lookupEntity.lkEntityName}PageInfo get${lkField.fieldName?cap_first}() {
		return ${lkField.fieldName?uncap_first};
	}

	public void set${lkField.fieldName?cap_first}(${lkField.lookupEntity.lkEntityName}PageInfo ${lkField.fieldName?uncap_first}) {
		this.${lkField.fieldName?uncap_first} = ${lkField.fieldName?uncap_first};
	}