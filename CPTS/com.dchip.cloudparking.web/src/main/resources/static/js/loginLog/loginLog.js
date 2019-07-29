define(['jquery', 'layui', 'until'], function($, LAY, until){
	layui.use(['table', 'form', 'layer'], function(){
		var table = layui.table;
		var form = layui.form;
		var layer = layui.layer;
		 if(i18n == 'en_US'){
				table.render({
					elem: '#loginLogTable',
					url: contextPath+"/loginLog/rendering",
					method: 'post',
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					skin: 'line',
					where: { //默认排序字段
						sortName: 'id',
						direction: 'desc'
					},
				    cols: [[
				      { field:'id', title: 'id', sort: true, align: 'center', hide: true},
				      { field:'userName', title: 'userName', sort: true, align: 'center', },
				      { field:'type', title: 'type', align: 'center',templet:function(data){
							if(data.type == 1){
								return "系统管理员";
							}else if(data.type == 2){
								return "停车场管理员";
							}else{
								return "未知";
							}
						  }},
				      { field:'ip', title: 'IP', sort: true, align: 'center'},
				      { field:'loginAt', title: 'loginTime', sort: true, align: 'center',templet:function(data){
							if(data.loginAt == null){
								return "";
							}else {
								return until.formatDateTime(data.loginAt);
							}
						  }},
				    ]],
				    response: {
				        countName: 'totalElements', //规定数据总数的字段名称，默认：count
				        dataName: 'content' //规定数据列表的字段名称，默认：data
				      }, 
					page: true
				}); 
		 }else{
				table.render({
					elem: '#loginLogTable',
					url: contextPath+"/loginLog/rendering",
					method: 'post',
					cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					skin: 'line',
					where: { //默认排序字段
						sortName: 'id',
						direction: 'desc'
					},
				    cols: [[
				      { field:'id', title: 'id', sort: true, align: 'center', hide: true},
				      { field:'userName', title: '用户名', sort: true, align: 'center', },
				      { field:'type', title: '用户类型', align: 'center',templet:function(data){
							if(data.type == 1){
								return "系统管理员";
							}else if(data.type == 2){
								return "停车场管理员";
							}else{
								return "未知";
							}
						  }},
				      { field:'ip', title: '用户IP', sort: true, align: 'center'},
				      { field:'loginAt', title: '登录时间', sort: true, align: 'center',templet:function(data){
							if(data.loginAt == null){
								return "";
							}else {
								return until.formatDateTime(data.loginAt);
							}
						  }},
				    ]],
				    response: {
				        countName: 'totalElements', //规定数据总数的字段名称，默认：count
				        dataName: 'content' //规定数据列表的字段名称，默认：data
				      }, 
					page: true
				}); 
		 }

		
		/**
		 * 排序方法
		 */
		table.on('sort(loginLogTable)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			table.reload('loginLogTable', {
			    initSort: obj, //记录初始排序，如果不设的话，将无法标记表头的排序状态
			    where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
			    	sortName: obj.field, //排序字段
			        direction: obj.type //排序方式
			    }
			});
		});
	
	});
});