<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/content/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/content/query/list',queryParams:{categoryId:0}">
		    <thead>
		        <tr>
		            <th data-options="field:'id',width:30">ID</th>
		            <th data-options="field:'title',width:120">Title</th>
		            <th data-options="field:'subTitle',width:100">SubTitle</th>
		            <th data-options="field:'titleDesc',width:120">Description</th>
		            <th data-options="field:'url',width:60,align:'center',formatter:TAOTAO.formatUrl">Link</th>
		            <th data-options="field:'pic',width:50,align:'center',formatter:TAOTAO.formatUrl">Image</th>
		            <th data-options="field:'pic2',width:50,align:'center',formatter:TAOTAO.formatUrl">Image2</th>
		            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">Create Date</th>
		            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">Update Date</th>
		        </tr>
		    </thead>
		</table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	tree.tree({
		onClick : function(node){
			if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					categoryId :node.id
		        });
			}
		}
	});
});
var contentListToolbar = [{
    text:'Add',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('！！','Choose A Category First!');
    		return ;
    	}
    	TT.createWindow({
			url : "/content-add"
		}); 
    }
},{
    text:'Edit',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('！！','Choose one for Edit!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('！！','Please Choose One !');
    		return ;
    	}
		TT.createWindow({
			url : "/content-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				$("#contentEditForm").form("load",data);
				
				// 实现图片
				if(data.pic){
					$("#contentEditForm [name=pic]").after("<a href='"+data.pic+"' target='_blank'><img src='"+data.pic+"' width='80' height='50'/></a>");	
				}
				if(data.pic2){
					$("#contentEditForm [name=pic2]").after("<a href='"+data.pic2+"' target='_blank'><img src='"+data.pic2+"' width='80' height='50'/></a>");					
				}
				
				contentEditEditor.html(data.content);
			}
		});    	
    }
},{
    text:'Delete',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('!!','No Item had been Selected!');
    		return ;
    	}
    	$.messager.confirm('Check','Are you sure delete '+ids+' ？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/content/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('!!','Delete Successfully!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
}];
</script>