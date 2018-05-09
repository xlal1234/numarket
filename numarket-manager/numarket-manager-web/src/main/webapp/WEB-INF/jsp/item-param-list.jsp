<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemParamList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/item/param/list',method:'get',pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">ID</th>
        	<th data-options="field:'itemCatId',width:80">ItemCatorgyID</th>
        	<th data-options="field:'itemCatName',width:100">ItemCatorgy</th>
            <th data-options="field:'paramData',width:300,formatter:formatItemParamData">ItemParam</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">CreateDate</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">UpdateDate</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="EditItem" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function formatItemParamData(value , index){
		if(value == null || value == ""){
			return "waiting";
		}
		var json = JSON.parse(value);
		var array = [];
		$.each(json,function(i,e){
			array.push(e.group);
		});
		return array.join(",");
	}

    function getSelectionsIds(){
    	var itemList = $("#itemParamList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = [{
        text:'Add',
        iconCls:'icon-add',
        handler:function(){
        	TAOTAO.createWindow({
        		url : "/item-param-add",
        	});
        }
    },{
        text:'Edit',
        iconCls:'icon-edit',
        handler:function(){
        	$.messager.alert('Alert','To be continued!');
        }
    },{
        text:'Delete',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('Alert','Choose One Item!');
        		return ;
        	}
        	$.messager.confirm('Confirm','Are you sure delete '+ids+'\'s param？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/param/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('Alert','Delete Success!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>