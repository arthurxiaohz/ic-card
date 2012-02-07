<#if serviceTool.hasChild(entity)>
function ${entity.entityName?uncap_first}_addDetail(detailName){
	var size;
	var index;
	for(i = 0;i<${entity.entityName?uncap_first}_detailCounts.length;i++){
		if(detailName==${entity.entityName?uncap_first}_detailCounts[i].name){
				size = ${entity.entityName?uncap_first}_detailCounts[i].size;
				index = i;
				break;
		}
	}
	${entity.entityName?uncap_first}_detailObject.addLine(detailName, size);
	${entity.entityName?uncap_first}_detailCounts[index].size++;
}

function ${entity.entityName?uncap_first}_delDetail(id, detailName){
	${entity.entityName?uncap_first}_detailObject.deleteLine(id, detailName, event);
}
</#if>