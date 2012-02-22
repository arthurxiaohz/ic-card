

function deleteRole(url){
	if(!window.confirm("删除角色会使与该角色对应所有用户的权限无效,确定要删除这个记录吗?")){
		return ;
	}
	document.formSearch.action=url;
	document.formSearch.submit();
}