define(['jquery', 'layui', 'until'], function ($, LAYUI, until) {
    var table;
    var form;
    var mainControlData = new Array();//主控板的数据集合
    layui.use(['table', 'form', 'laydate'], function () {
    	var cheakNameFlag = true; 
    	var oldlicensePlateName;
        table = layui.table;
        form = layui.form;
        
		$("#searchUId").empty();
        $("#searchUId").append('<option value="" selected="selected">请选择唯一识别码</option>');
        $.each(groundLockUIdList,function(i,obj){
            $("#searchUId").append('<option value="'+obj.groundUid+'">'+obj.groundUid+'</option>');
        });
        
        form.render();
        if(i18n == 'en_US'){
        	table.render({
                elem: '#groundLockModelTable',
                url: contextPath + "/groundLock/rendering",
                method: 'post',
                cellMinWidth: 150,//全局定义常规单元格的最小宽度，layui 2.2.1 新增
                skin: 'line',
                where: {
                    sortName: 'id',
                    direction: 'desc'
                },
                cols: [[
                    {field: 'groundUid', title: 'groundUid', align: 'center', sort:true},
                    {field: 'licensePlate', title: 'licensePlate', align: 'center', sort:true, templet: function(data){
                    	if(data.licensePlate == null){
                    		return "未绑定车牌号";
                    	}else{
                    		return data.licensePlate;
                    	}
                    }},
                    {field: 'mac', title: 'mainMac', align: 'center', sort:true, templet: function(data){
                    	if(data.mac == null){
                    		return "未绑定主控板";
                    	}else{
                    		return data.mac;
                    	}
                    }},
                    {field: 'parkName', title: 'parkName', align: 'center', sort:true},
                    {field: 'currentState', title: 'currentState', align: 'center', sort:true, templet: function(data){
    	                	if(data.currentState == 1){
    	                		return "打开";
    	                	} else if(data.currentState == 2){
    	                		return "关闭";
    	                	} else {
    	                		return "";
    	                	}
                    	}
                    },
                    {
                        field: 'createTime', title: 'createTime', align: 'center', sort:true, templet: function (data) {
                            if (data.createTime == null) {
                                return "";
                            } else {
                                return until.formatDateTime(data.createTime);
                            }
                        }
                    },
                    {field: 'remark', title: 'remark', align: 'center', sort:true, templet: function(data){
    	                	if(data.remark == null){
    	                		return "无";
    	                	}else{
    	                		return data.remark;
    	                	}
                    	}
                    },
                    {field: 'right', title: 'right', toolbar: '#groundLockTableBarEnglish', align: 'center',width:180}
                ]],
                response: {
                    countName: 'totalElements', //规定数据总数的字段名称，默认：count
                    dataName: 'content' //规定数据列表的字段名称，默认：data
                },
                page: true
            });
        }else{
        	table.render({
                elem: '#groundLockModelTable',
                url: contextPath + "/groundLock/rendering",
                method: 'post',
                cellMinWidth: 150,//全局定义常规单元格的最小宽度，layui 2.2.1 新增
                skin: 'line',
                where: {
                    sortName: 'id',
                    direction: 'desc'
                },
                cols: [[
                    {field: 'groundUid', title: '地锁唯一识别码', align: 'center', sort:true},
                    {field: 'licensePlate', title: '车牌号', align: 'center', sort:true, templet: function(data){
                    	if(data.licensePlate == null){
                    		return "未绑定车牌号";
                    	}else{
                    		return data.licensePlate;
                    	}
                    }},
                    {field: 'mac', title: '主控板mac', align: 'center', sort:true, templet: function(data){
                    	if(data.mac == null){
                    		return "未绑定主控板";
                    	}else{
                    		return data.mac;
                    	}
                    }},
                    {field: 'parkName', title: '所属停车场', align: 'center', sort:true},
                    {field: 'currentState', title: '当前状态', align: 'center', sort:true, templet: function(data){
    	                	if(data.currentState == 1){
    	                		return "打开";
    	                	} else if(data.currentState == 2){
    	                		return "关闭";
    	                	} else {
    	                		return "";
    	                	}
                    	}
                    },
                    {
                        field: 'createTime', title: '创建时间', align: 'center', sort:true, templet: function (data) {
                            if (data.createTime == null) {
                                return "";
                            } else {
                                return until.formatDateTime(data.createTime);
                            }
                        }
                    },
                    {field: 'remark', title: '备注', align: 'center', sort:true, templet: function(data){
    	                	if(data.remark == null){
    	                		return "无";
    	                	}else{
    	                		return data.remark;
    	                	}
                    	}
                    },
                    {field: 'right', title: '操作', toolbar: '#groundLockTableBar', align: 'center',width:180}
                ]],
                response: {
                    countName: 'totalElements', //规定数据总数的字段名称，默认：count
                    dataName: 'content' //规定数据列表的字段名称，默认：data
                },
                page: true
            });
        }
        
      //切换英文
		if(i18n == 'en_US'){
			$("#groundUid").empty();
			$("#groundUid").append('Uid');
			$("#searchGroundLock").empty();
			$("#searchGroundLock").append('Search');
			$("#choseMainControl").empty();
			$("#choseMainControl").append('MainControl');
			$("#lockUid").empty();
			$("#lockUid").append('lockUid');
			$("#LicensePlate").empty();
			$("#LicensePlate").append('LicensePlate');
		}
        
      //失去焦点判断重名
/*        $(document).off("blur", "#lockLicensePlate").on("blur", "#lockLicensePlate", function(){
        	var thisName = $(this).val();
			if((thisName != oldlicensePlateName) && (thisName)){
				$.ajax({
					url: contextPath + "/groundLock/checkgroundLockName",
					dataType: "json",
					type: "post",
					data: {
						licensePlate: thisName
					},
					complete: function(XHR, TS){
						var returnObj = eval('('+ XHR.responseText +')');
						if(returnObj.code != 200){
							cheaklicensePlateName = false;
							layer.msg(returnObj.msg, {time: 1500});
						}else{
							cheaklicensePlateName = true;	 							 
						}
					}
				});
			}else{
				cheaklicensePlateName = true;
			}
		});*/
        
        /**
		 * 搜索方法
		 */
		$("#searchGroundLock").click(function() {
			table.reload('groundLockModelTable', {
				  where : { //设定异步数据接口的额外参数，任意设
					  searchUId: $("#searchUId").val()
				  },
				   page : {curr: 1 }  //重新从第 1 页开始
			});
		 });
		
        /**
		  * 监听行工具事件
		  */
        table.on('tool(groundLockModelTable)', function(obj) {
        	var data = obj.data;
        	var titelDel = "真的删除吗";
            if(i18n == 'en_US'){
            	 titelDel = "Do you really delete it?";
            }
		     if(obj.event === 'del') { //执行删除方法
		         layer.confirm(titelDel, function(index) {
		        	 $.ajax({
	 					  url : contextPath+"/groundLock/delete",
	 				 dataType : 'json',
	 					 type : 'post',
	 					async : false,
	 					 data : {
	 						groundId: data.id
	 					  },
	 				 complete : function(XHR, TS) {
	 						  var returnObj = eval('(' + XHR.responseText + ')');
	 						  if(returnObj.code != 200) {
	 							 layer.msg(returnObj.msg, {icon: 2, time: 1500});
	 						  } else {
	 							 layer.msg("操作成功", {icon: 1, time: 1500});		 							 
	 						  }
	 						 table.reload('groundLockModelTable');
	 					  }
	 				});//ajax结束
		         });
		     } else if(obj.event === 'edit') {//执行编辑方法
		    	 editGroundLock("edit", data);
		     }
		});

        
          //添加抵地锁按钮点击事件
//        $("#addGroundLockModel").click(function () {
//        	editGroundLock("add");
//        });
        
        //编辑或添加管理员的具体操作
        function editGroundLock(type,data){
        	var showTitle ='编辑';
        	var responseUrl =  "/groundLock/edit";
        	var groundUid =  0;
 /*       	if(type == "add"){
        		showTitle = '添加';
        		responseUrl = "/groundLock/add";
        	}*/
        	var showContent = $('#showGroundLockDetail').html();
        	$('#showGroundLockDetail').html("");
        	layer.open({
        		type : 1,
        		  id : 'showLayui',
        	   title : showTitle,
        	 content : showContent,
        	    area : '600px',
        	     btn : ['确定','取消'],
        	btnAlign : 'c',
        	
        	 success : function(layero, index){
        		 
        		 layui.use(['form', 'layer'], function () {
	        		 var form = layui.form;
	                 var layer = layui.layer;
	        		 $("#selectMainControl").empty();
	                 $("#selectMainControl").append('<option value="" selected="selected">请选择主控板</option>');
	                 $.each(mainControlList,function(i,obj){
	                     $("#selectMainControl").append('<option value="'+obj.id+'">'+obj.mac+'</option>');
	                 });
	                 /*$("#groundLockUIdPut").empty();
	                 $("#groundLockUIdPut").append('<option value="" selected="selected">请选择唯一识别码</option>');
	                 $.each(groundLockUIdList,function(i,obj){
	                     $("#groundLockUIdPut").append('<option value="'+obj.groundUid+'">'+obj.groundUid+'</option>');
	                 });*/
	                 
	                 if(type == "edit"){
	        			 $("#selectMainControl").val(data.mainId);
	        			 $("#groundLockUIdPut").val(data.groundUid);
	        			 $("#lockLicensePlate").val(data.licensePlate)
	        			 oldlicensePlateName = data.licensePlate;
	        			 groundUid = data.groundUid;
	        		 }
	                 form.render();  //重新渲染表单
	                 
	                 $("#lockLicensePlate").change(function() {
							var str = $("#lockLicensePlate").val();
							if(!isLicensePlate(str)){
								layer.msg("请输入正确车牌号");
								 cheakNameFlag = false;
								return;
							}else{
								cheakNameFlag = true;
								return;
							}
						});
	                 
        		 });
        	 },//success结束
        	 yes: function(index, layero){
        		 var msgArr = ["主控板不能为空","车牌号不能为空","地锁唯一识别码不能为空"];//提示语集合
        		 var clsArr = ["#selectMainControl","#lockLicensePlate","groundLockUIdPut"];  //id集合
        		 var validateFlag = until.validate(msgArr, clsArr); //非空验证 需要引入工具js文件until
        		 if(validateFlag){
        			 layer.msg(validateFlag,{anim: 6, time: 2500});
        			 return;
        		 }
        		 if(cheakNameFlag == false){
	 					layer.msg("请输入正确的车牌号" , {anim: 6, time: 1500});  
	 					return ;
	 				}
     		 
/*        		 if(cheaklicensePlateName == false){
	 					layer.msg("车牌号已存在" , {anim: 6, time: 1500});  
	 					return ;
	 				}*/
//        		 if(type == "add"){
//        			 groundUid =  $("#groundLockUIdPut").val();
//        		 }
    			 $.ajax({
 					    url : contextPath + responseUrl,
 					    dataType : 'json',
 					    type : 'post',
 					    async : false,
 					    data : {
 					    	groundUid: $("#groundLockUIdPut").val(),
 					    	mainControlId: $("#selectMainControl").val(),
 					    	licensePlate: $("#lockLicensePlate").val()
 					  },
 					complete : function(XHR, TS) {
 						  var returnObj = eval('(' + XHR.responseText + ')');
 						  if(returnObj.code != 200) {
 							 layer.msg(returnObj.msg, {icon: 2, time: 1500});
 						  } else {
 							 layer.msg("操作成功", {icon: 1, time: 1500});		 							 
 						  }
 						 layer.close(index); 
 						 table.reload('groundLockModelTable');
 					}
 				});
    	 	},
    	 	end: function(){ //只要层被销毁了，end都会执行
 				$('#showGroundLockDetail').html(showContent);
 			}
    	});
    }
        		 
});
    
	function isLicensePlate(str){
		var reg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;	
		if(!reg.test(str)){
			return false;
		}
		return true;
	}
});