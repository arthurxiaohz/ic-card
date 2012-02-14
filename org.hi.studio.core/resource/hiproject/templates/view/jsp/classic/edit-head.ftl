  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="${service.serviceName}/${entity.entityName?cap_first}.js"></script>
<#list entity.childEntity as childEntity>
  <script type="text/javascript" src="${childEntity.childServiceName}/${childEntity.childEntityName?cap_first}.js"></script>
</#list>
