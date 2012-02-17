/**
 * J-Hi Java快速开发平台
 * 数据库关联表: 查找带回、主从
 * @author zhanghuihua@msn.com
 */
(function($){
	/*
	 * {currentGroup:master, currentName:devLookup} 
	 * {currentGroup:master.items, currentName:itemLookup, index:0} 
	 */
	var _lookup = {currentGroup:"",currentName:"",index:-1, callback:""};
	var _util = {
		_lookupPrefix: function(){
			var indexStr = _lookup.index < 0 ? "" : "["+_lookup.index+"]";
			return _lookup.currentGroup + indexStr;
		},
		lookupPk: function(key){
			return _util._lookupPrefix() + "." + _lookup.currentName + "." + key;
		},
		lookupField: function(key){
			return _util._lookupPrefix() + ".hi_" + _lookup.currentName + "." + key;
		},
		lookupFilter:function(){
			var $box = navTab.getCurrentPanel();
			var result = "{";
			var index = 0;
			$box.find(":hidden").each(function(){
				var $input = $(this), inputName = $input.attr("name");
				if(_lookup.currentGroup == $input.attr("lookupGroup") 
						&& _lookup.currentName == $input.attr("lookupName") && inputName.indexOf("pageInfo.") >= 0){
					if(index > 0)
						result += ",";
					
					var attrs = inputName.substr("pageInfo.".length).split(".");
					var jsonLast = "";
					 for(var i = 0; i < attrs.length; i++){
						 if(i > 0)
							 jsonLast += "}";
						 
						 if(attrs.length > 1 && i > 0)
							 result += "{";
						 
						 result += attrs[i];
						 result += ":";
					 }
					 
					if($input.attr("id")){
						result += document.getElementById($input.attr("id")).value;
					}else{
						result += $input.attr("value");
					}					
					 
					result += jsonLast;
					
				index++;
				}
			});
			result += "}";
			return result;
		}
	};
	
	$.fn.extend({
		removeSelected: function(options){
			var op = $.extend({selectedIds:"orderIndexs"}, options);
			function getIds(){
				var ids = "";
				navTab.getCurrentPanel().find("input:checked").filter("[name=orderIndexs]").each(function(i){
					var val = $(this).val();
					ids += i==0 ? val : ","+val;
				});
				return ids;
			}
			return this.each(function(){
				var $this = $(this);

				$this.click(function(){
					var ids = getIds();
					if (!ids) {
						alertMsg.error("请选择要删除的记录");
						return false;
					}
					alertMsg.confirm($this.attr("title") || "确实要删除这些记录吗?", {
						okCall: function(){
							$.ajax({
								type:'POST', url:$this.attr('href'), dataType:'json', cache: false,
								data: {orderIndexs: ids},
								success: navTabAjaxDone,
								error: DWZ.ajaxError
							});
						}
					});
					
					return false;
				});
				
			});
		},
		lookup: function(){
			return this.each(function(){
				var $this = $(this), options = {mask:true, width:$this.attr('width')||820, height:$this.attr('height')||400};
				$this.click(function(event){
					_lookup = $.extend(_lookup, {
						currentGroup: $this.attr("lookupGroup") || "", 
						currentName:$this.attr("lookupName") || "",
						index: parseInt($this.attr("index")|| -1),
						callback:$this.attr("callback") || ""
					});
					$.pdialog.open($this.attr("href"), "_blank", $this.attr("title") || $this.text(), options);
					event.preventDefault();
				});
			});
		},
		suggest: function(){
			var op = {suggest$:"#suggest", suggestShadow$: "#suggestShadow"};
			var selectedIndex = -1;
			return this.each(function(){
				var $input = $(this).keydown(function(event){
					if (event.keyCode == DWZ.keyCode.ENTER) return false; //屏蔽回车提交
				});
				
				var searchFields=$input.attr('searchFields').split(",");
				
				function _show(){
					var offset = $input.offset();
					var iTop = offset.top+this.offsetHeight;
					var $suggest = $(op.suggest$);
					if ($suggest.size() == 0) $suggest = $('<div id="suggest"></div>').appendTo($('body'));
					
					
					$suggest.css({
						left:offset.left+'px',
						top:iTop+'px'
					}).show();
					
					_lookup = $.extend(_lookup, {
						currentGroup: $input.attr("lookupGroup") || "", 
						currentName:$input.attr("lookupName") || "",
						index: parseInt($input.attr("index")|| -1),
						callback:$input.attr("callback") || ""
					});
					
					$.ajax({
						type:'POST', dataType:"json", url:'common/lookupSuggest.jsp', cache: false,
						data:{className:$input.attr('suggestClass'), inputValue:$input.val().trim(), lookupSearchFields:$input.attr('searchFields'),
						filter:_util.lookupFilter(), lookupPrivileges:$input.attr('lookupPrivileges')},
						success: function(response){
							if (!response) return;
							var html = '<li lookupAttrs=\'{"id":"-1"';
							for (var i=0; i<searchFields.length; i++){
								html += ',"'+searchFields[i]+'":""';
							}
							
							html += '}\'><无></li>';
							var $beans = $(response.beans);
							
							$beans.each(function(i){
								var bean = $(this)[0], liLabel = '';
								
								for (var i=0; i<searchFields.length; i++){
									var str = eval("bean."+searchFields[i]);
									if (str) {
										if (liLabel) liLabel += '-';
										liLabel += str;
									}
								}
								
								html += '<li lookupAttrs=\''+DWZ.jsonToString(bean)+'\'>' + liLabel + '</li>';
							});
							$suggest.html('<ul>'+html+'</ul>').find("li").hoverClass("selected").click(function(){
								_select($(this));
							});
							
						},
						error: function(){
							$suggest.html('');
						}
					});

					$(document).bind("click", _close);
					return false;
				}
				function _select($item){
					var jsonStr =$item.attr('lookupAttrs');
					$.bringBackSuggest(jQuery.parseJSON(jsonStr));
				}
				function _close(){
					$(op.suggest$).html('').hide();
					selectedIndex = -1;
					$(document).unbind("click", _close);
				}
				
				$input.focus(_show).click(false).keyup(function(event){
					var $items = $(op.suggest$).find("li");
					switch(event.keyCode){
						case DWZ.keyCode.ESC:
						case DWZ.keyCode.TAB:
						case DWZ.keyCode.SHIFT:
						case DWZ.keyCode.HOME:
						case DWZ.keyCode.END:
						case DWZ.keyCode.LEFT:
						case DWZ.keyCode.RIGHT:
							break;
						case DWZ.keyCode.ENTER:
							_close();
							break;
						case DWZ.keyCode.DOWN:
							if (selectedIndex >= $items.size()-1) selectedIndex = -1;
							else selectedIndex++;
							break;
						case DWZ.keyCode.UP:
							if (selectedIndex < 0) selectedIndex = $items.size()-1;
							else selectedIndex--;
							break;
						default:
							_show();
					}
					$items.removeClass("selected");
					if (selectedIndex>=0) {
						var $item = $items.eq(selectedIndex).addClass("selected");
						_select($item);
					}
				});
			});
		},
		itemDetail: function(){
			return this.each(function(){
				var $table = $(this), $tbody = $table.find("tbody");
				var itemDetail = $table.attr("itemDetail") || "", fields=[];

				$table.find("tr:first th[type]").each(function(){
					var $th = $(this);
					var field = {
						type: $th.attr("type") || "text",
						patternDate: $th.attr("pattern") || "yyyy-MM-dd",
						patternDatetime: $th.attr("pattern") || "yyyy-MM-dd HH:mm:ss",
						name: $th.attr("name") || "",
						size: $th.attr("size") || "12",
						enumName: $th.attr("enumName") || "",
						lookupName: $th.attr("lookupName") || "",
						lookupUrl: $th.attr("lookupUrl") || "",
						suggestClass: $th.attr("suggestClass"),
						searchFields: $th.attr("searchFields"),
						styleClass: $th.attr("class"),
						callback:  $th.attr("callback"),
						id: $th.attr("id"),
						maxlength : $th.attr("maxlength") || ""
					};
					
					if(field.type == 'hidden')
						$th.hide();
					
					fields.push(field);
				});
				
				$tbody.find("a.btnDel").click(function(){
					var $btnDel = $(this);
					function delDbData(){
						$.ajax({
							type:'POST', dataType:"json", url:$btnDel.attr('href'), cache: false,
							success: function(){
								$btnDel.parents("tr:first").remove();
								initSuffix($tbody);
							},
							error: DWZ.ajaxError
						});
					}
					
					if ($btnDel.attr("title")){
						alertMsg.confirm($btnDel.attr("title"), {okCall: delDbData});
					} else {
						delDbData();
					}
					
					return false;
				});

				if (!$table.hasClass('noadd')) {
					var $addBut = $('<div class="button"><div class="buttonContent"><button type="button">新建</button></div></div>').insertBefore($table).find("button");
					var $rowNum = $('<input type="text" name="hi_rowNum" class="textInput" style="margin:2px;" value="1" size="2"/>').insertBefore($table);
	
					var trTm = "";
					$addBut.click(function(){
						if (! trTm) trTm = trHtml(fields, itemDetail, $table);
						var rowNum = 1;
						try{rowNum = parseInt($rowNum.val())} catch(e){}
	
						for (var i=0; i<rowNum; i++){
							var $tr = $(trTm.replaceAll("#index#", $tbody.find(">tr").size()));
							$tr.appendTo($tbody).initUI().find("a.btnDel").click(function(){
								$(this).parents("tr:first").remove();
								initSuffix($tbody);
								return false;
							});
						}
					});
				}
			});
			
			/**
			 * 删除时重新初始化下标
			 */
			function initSuffix($tbody) {
				$tbody.find('>tr').each(function(i){
					$(':input', this).each(function(){
						var $input = $(this);
						var name = $input.attr('name').replaceAll('\[[0-9]+\]','['+i+']');
						$input.attr('name', name);
					});
				});
			}
			function tdHtml(field, itemDetail, $table){
				var html = '', fieldName = itemDetail+'[#index#].'+field.name;
				var lookupFieldName = itemDetail+'[#index#].hi_'+field.lookupName+'.'+field.name;
				switch(field.type){
					case'del':
						html = '<a href="javascript:void(0)" class="btnDel '+field.styleClass+'">删除</a>';
						break;
					case 'lookup':
						var suggestFrag = '';
						if (field.suggestClass && field.searchFields) {
							suggestFrag = 'autocomplete="off" lookupGroup="'+itemDetail+'" lookupName="'+field.lookupName+'" index="#index#" suggestClass="'+field.suggestClass+'" searchFields="'+field.searchFields+'"';
						}
						
						if (field.lookupUrl)
							html += '<input type="hidden" name="'+itemDetail+'[#index#].'+field.lookupName+'.id"/>';
						
						html += '<input type="text" class="'+field.styleClass+'" name="'+lookupFieldName+'"'+suggestFrag+' size="'+field.size+'"';
						
						if( !field.lookupUrl)
							html += ' readonly="readonly"';
						
						if(field.callback)
							html += ' callback="' + field.callback + "\"";
								
						html += '/>';
						
						if (field.lookupUrl)
							html += '<a class="btnLook" href="'+field.lookupUrl+'" lookupGroup="'+itemDetail+'" lookupName="'+field.lookupName+'" index="#index#" title="查找带回">查找带回</a>';
						break;
					case 'attach':
						html = '<input type="hidden" name="'+itemDetail+'[#index#].'+field.lookupName+'.id"/>'
							+ '<input type="text" class="'+field.styleClass+'"  name="'+lookupFieldName+'" size="'+field.size+'" readonly="readonly"/>'
							+ '<a class="btnAttach" href="'+field.lookupUrl+'" lookupGroup="'+itemDetail+'" lookupName="'+field.lookupName+'" index="#index#" width="560" height="300" title="查找带回">查找带回</a>';
						break;
					case 'enum':
						$.ajax({
							type:"POST", dataType:"html", async: false,
							url:"common/select.jsp", 
							data:{enumName:field.enumName, inputName:fieldName}, 
							success:function(response){
								html = response;
							}
						});
						break;
					case 'date':
						html = '<input type="text" name="'+fieldName+'" class="date '+field.styleClass+'" pattern="'+field.patternDate+'" size="'+field.size+'"  readonly="readonly"/>'
							+'<a class="inputDateButton" href="javascript:void(0)">选择</a>';
						break;
					case 'datetime':
						html = '<input type="text" name="'+fieldName+'" class="date '+field.styleClass+'" pattern="'+field.patternDatetime+'" size="'+field.size+'"  readonly="readonly"/>'
							+'<a class="inputDateButton" href="javascript:void(0)">选择</a>';
						break;
					case 'hidden':
						html = '<input type="hidden" name="'+fieldName+'"/>';
						break;
					default:
						html = '<input type="text" class="'+field.styleClass+'" name="'+fieldName+'" size="'+field.size+'" maxlength="'+field.maxlength+'"/>';
						break;
				}
				
				if(field.type == 'hidden')
					return html;
				
				
				var tdAtt='<td';
				if(field.id)
					tdAtt += ' id='+ field.id +'[#index#]';
				
				var sytle = $table.find("tr:first th[name='"+field.name+"']").attr("style");
				if(sytle)
					tdAtt += ' style=\"'+ sytle + '\" ';
				
				return tdAtt + '>'+html+'</td>';
			}
			
			function trHtml(fields, itemDetail, $table){
				var html = '';
				$(fields).each(function(){
					html += tdHtml(this, itemDetail, $table);
				});
				return "<tr>"+html+"</tr>";
			}
		}
	});
	
	$.extend({
		
		bringBackSuggest: function(args){
			var $box = navTab.getCurrentPanel();
			$box.find(":input").each(function(){
				var $input = $(this), inputName = $input.attr("name");
				
				for (var key in args) {
					var name = ("id" == key) ? _util.lookupPk(key) : _util.lookupField(key);
					if (name == inputName) {
						$input.val(args[key]);
						break;
					}
				}
			});
			
			if(_lookup.callback){
				eval(_lookup.callback + "(args,_lookup.index)");
			}
		},
		bringBack: function(args){
			$.bringBackSuggest(args);
			$.pdialog.closeCurrent();
		}
	});
})(jQuery);
