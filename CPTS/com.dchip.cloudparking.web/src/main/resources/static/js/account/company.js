define(['jquery', 'layui', 'until'], function ($, LAYUI, until) {
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        var cheakNameFlag = true;   //检查角色重名标志  false为重名，true 为不重名
        var oldAccountName;   //保存原来的角色名称
        var oldPhone; //保存原来的手机号码
        form.render();
        table.render({
            elem: '#accountTable',
            url: contextPath + "/account/rendTable",
            method: 'post',
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            skin: 'line',
            where: {
                sortName: 'nickname',
                direction: 'desc'
            },
            cols: [[
                {field: 'userName', title: '管理员账户', sort: true},
                {
                    field: 'accountType', title: '管理员类型', sort: true, templet: function (data) {
                        if (data.accountType == 1) {
                            return "系统管理员";
                        }else if(data.accountType == 2) {
                            return "公司管理员";
                        }else if(data.accountType == 3){
    						return "停车场管理员";
    					}else if(data.accountType == 4){
    						return "停车场保安";
    					}
                    }
                },
                {
                    field: 'companyName', title: '所属公司', sort: true, templet: function (data) {
                        if (data.companyName) {
                            return data.companyName;
                        } else {
                            return "无";
                        }
                    }
                },
                {field: 'sysRoleName', title: '角色名称', sort: true},
                {
                    field: 'createTime', title: '创建时间', sort: true, align: 'center', templet: function (data) {
                        if (data.createTime == null) {
                            return "";
                        } else {
                            return until.formatDateTime(data.createTime);
                        }
                    }
                },
                {
                    field: 'accountStatus', title: '账号状态', sort: true, align: 'center', templet: function (data) {
                        if (data.accountStatus == 1) {
                            return "<span style='color: green;'>正常</span>";
                        } else {
                            return "<span style='color: red;'>禁用</span>";
                        }
                    }
                },
                {
                    fixed: 'right',
                    field: 'accountStatus',
                    title: '操作',
                    align: 'center',
                    width: 180,
                    templet: function (data) {
                        var button = "";
                        if (data.userName == "admin") {
                            button = "无";
                        } else {
                            if (data.accountStatus == 1) {
                                button += "<button lay-event='accountStatusBar' class='layui-btn layui-btn-warm layui-btn-xs'>禁用</button>";
                            }else{
                            	button += "<button lay-event='accountStatusBar' class='layui-btn layui-btn-xs'>启用</button>";
                            }
                            if(data.sysRoleType == 3){
                            	button += "<button lay-event='editBar' class='layui-btn layui-btn-xs'>编辑</button>";
                            }
                            button += "<button lay-event='delBar' class='layui-btn layui-btn-danger layui-btn-xs'>删除</button>";
                        }
                        return button;
                    }
                }
            ]],
            response: {
                countName: 'totalElements',  //规定数据总数的字段名称，默认：count
                dataName: 'content' //规定数据列表的字段名称，默认：data
            },
            page: true
        });

        $("#companyId").val(companyId);
        $("#companyAccountRoleSel").empty();
    	$("#companyAccountRoleSel").append('<option value="" selected="selected">请选择角色</option>');
    	$.each(companyRoleList, function(i, obj){
    		$("#companyAccountRoleSel").append('<option value="'+ obj.id +'" >'+ obj.name +'</option>');
    	});
    	$("#parkingAccountRoleSel").empty();
    	$("#parkingAccountRoleSel").append('<option value="" selected="selected">请选择角色</option>');
    	$.each(parkingRoleList, function(i, obj){
    		$("#parkingAccountRoleSel").append('<option value="'+ obj.id +'" >'+ obj.name +'</option>');
    	});
        table.on('sort(accountTable)', function (obj) {
            table.reload('accountTable', {
                initSort: obj,
                where: {
                    field: obj.field, //排序字段
                    order: obj.type //排序方式
                }
            });
        });

        /**
         * 搜索方法
         */
        $("#searchAccount").click(function () {
            table.reload('accountTable', {
                where: { //设定异步数据接口的额外参数，任意设
                    searchUserName: $("#loginAccount").val(),
                    searchManagerType: $("#searchManagerType").val()
                },
                page: {curr: 1}  //重新从第 1 页开始
            });
        });

        /**
         * 添加停车场点击事件
         */
        $("#addAccount").click(function () {
            editAccount("add");
        });

        //失去焦点判断重名
        $(document).off("blur", "#userName").on("blur", "#userName", function () {
            var thisName = $(this).val();
            if ((thisName != oldAccountName) && (thisName)) {
                $.ajax({
                    url: contextPath + "/account/checkAccountName",
                    dataType: "json",
                    type: "post",
                    data: {
                        accountName: thisName
                    },
                    complete: function (XHR, TS) {
                        var returnObj = eval('(' + XHR.responseText + ')');
                        if (returnObj.code != 200) {
                            cheakNameFlag = false;
                            $("#userName").focus();
                            layer.msg(returnObj.msg, {time: 1500});
                        } else {
                            cheakNameFlag = true;
                        }
                    }
                });
            }
        });

        //编辑或添加管理员的具体操作
        function editAccount(type, data) {
            var showTitle = '编辑管理员信息';
            var responseUrl = "/account/addAccount";
            var parkingUserId = 0; //parking_user表的ID,用于全局
            if (type == "add") { //添加
                showTitle = '添加停车场管理员'
            } else { //编辑
                parkingUserId = data.parkingUserId;//编辑时给parking_user表的ID赋值,保存数据的时候需要用到。
                oldPhone = data.userName;//保留初始的手机号码，用于提交数据时进行对比是否有更改手机号码。
                responseUrl = "/account/editAccount";
            }
            var showContent = $('#showAccountContent').html();
            $('#showAccountContent').html("");
            
            layer.open({
                type: 1,
                id: 'showLayui',
                title: showTitle,//显示标题
                content: showContent, //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                area: ['500px', '500px'],
                btn: ['确定', '取消'],
                btnAlign: 'c',

                success: function (layero, index) {
                    $("#userName").change(function () {
                        var userName = $("#userName").val();
                        if (!(/^[a-zA-Z0-9_-]{4,16}$/.test(userName))) {
                            layer.msg("管理员账号只能输入字母，数字，下划线，减号");
                        }
                    });

                    fetchCompanyOptions(companyId);//调用方法,查找出该公司的所有停车场,渲染在所属停车场的下拉选择中
                    if (data) { //如果有数据，则进行页面赋值
                        oldAccountName = data.userName;//给原始账号赋值
                        $("#accountId").val(data.accountId);//管理员ID
                        $("#showAccountInitPW").addClass("none");//初始密码,不可见(编辑页面)

                        $("#showAccountParkingSel").removeClass("none");//停车场管理员:所属停车场,可见
                        $("#parkingAccount").removeClass("none");//停车场管理员:账号,可见
                        $("#name").removeClass("none");//停车场管理员:姓名,可见
                        $("#userPhone").val(data.userName);//停车场管理员:账号,赋值
                        $("#realName").val(data.realName);//停车场管理员:姓名,赋值
                        $("#showAccountCompanySel").removeClass("none");//停车场管理员的公司选择,可见

                        $("#companyId").val(data.companyId);//停车场管理员的所属公司,赋值
                        $("#accountParkingSel").val(data.parkingId);//所属停车场,赋值
                        form.render();//渲染页面
                        if(data.sysRoleType == 2){
                        	$("#companyAccountRoleSel").val(data.sysRoleId);//停车场管理员的角色选择,赋值
                        	$("#showParkingAccountRoleSel").addClass("none");//停车场管理员的角色选择,可见
                        	$("#showCompanyAccountRoleSel").removeClass("none");
                        	$("#showAccountParkingSel").addClass("none");//停车场管理员:所属停车场,可见
                        }else if(data.sysRoleType == 3){
                        	$("#parkingAccountRoleSel").val(data.sysRoleId);//停车场管理员的角色选择,赋值
                        	$("#showParkingAccountRoleSel").removeClass("none");//停车场管理员的角色选择,可见
                        	$("#showCompanyAccountRoleSel").addClass("none");
                        }
                    }

                    $("#userPhone").blur(function () {//当元素失去焦点时发生 blur 事件
                        var thisName = $(this).val();
                        if ((thisName != oldPhone) && (thisName)) {//如果手机号码有改动
                            $.ajax({//查询parking_user表里的数据,判断该手机号是否已被使用
                                url: contextPath + "/account/checkParkingUserName",
                                dataType: 'json',
                                type: 'post',
                                async: false,
                                data: {
                                    parkingUserName: thisName
                                },
                                complete: function (XHR, TS) {
                                    var returnObj = eval('(' + XHR.responseText + ')');
                                    if (returnObj.code != 200) {
                                        layer.msg(returnObj.msg, {icon: 2, time: 2500});
                                        $("#userPhone").val("");
                                        return false;
                                    }
                                }
                            });
                        }
                    });

                    function fetchCompanyOptions(companyId) {//通过公司ID查找出该公司的所有停车场
                        if (companyId != null) {
                            $("#showAccountParkingSel").removeClass("none");
                        }
                        $.ajax({
                            url: contextPath + "/account/getParking",
                            dataType: 'json',
                            type: 'post',
                            async: false,
                            data: {
                                companyId: companyId
                            },
                            complete: function (XHR, TS) {
                                var returnObj = eval('(' + XHR.responseText + ')');
                                if (returnObj.code != 200) {
                                    layer.msg("请选择所属公司", {time: 1500});
                                } else {
                                    $("#accountParkingSel").empty();
                                    $("#accountParkingSel").append('<option value="" selected="selected">请选择停车场</option>');
                                    $.each(returnObj.data, function (i, obj) {
                                        $("#accountParkingSel").append('<option value="' + obj.id + '" >' + obj.parkName + '</option>');
                                    });
                                    if (data) {
                                        $("#accountParkingSel").val(data.parkingId);
                                    }
                                    form.render();
                                }
                            }
                        });
                    };

                    form.render();
                }, //success结束

                yes: function (index, layero) { //确定按钮的操作

                    var userName = $("#userName").val();//管理员账号
                    var userPhone = $("#userPhone").val();//手机号
                    var realName = $("#realName").val();//姓名
                    var saveRoleType = 3; //停车场管理员类型
                    var saveRoleId = $("#parkingAccountRoleSel").val();//选择停车场管理员角色
                    var companyRoleId = $("#companyAccountRoleSel").val();//选择公司管理员角色
                    var saveCompany;
                    var saveParking;
                    saveCompany = companyId;//停车场管理员角色下的公司
                    saveParking = $("#accountParkingSel").val();//停车场管理员角色下的停车场
                    if (userPhone == "" || userPhone == null) {//手机号为空的情况
                        layer.msg("账号不能为空！", {anim: 6, time: 2000});
                        $("#userPhone").focus();
                        return;
                    } else {//手机号不为空的情况，验证号码的正确性
                        if (!until.isPoneAvailable(userPhone)) {
                            layer.msg("请填写正确的手机号码！", {anim: 6, time: 2000});
                            $("#userPhone").focus();
                            return;
                        }
                    }
                    if (realName == null || realName == "") {//姓名为空的情况下
                        layer.msg("姓名不能为空！", {anim: 6, time: 1500});
                        $("#realName").focus();
                        return;
                    }
                    if (saveRoleId == null || companyRoleId == null) {
                        layer.msg("没有选择角色", {anim: 6, time: 1500});
                        return;
                    }
                	if (saveCompany == null || saveCompany == "") {
                		layer.msg("没有选择所属公司", {anim: 6, time: 1500});
                		return;
                	}
                	if(data){
                		if(data.sysRoleType == 3){
                			if (saveCompany != null) {
                				if (saveParking == null || saveParking == "") {
                					layer.msg("没有选择所属停车场", {anim: 6, time: 1500});
                					return;
                				}
                			}
                		}else{
                			saveRoleType == 2;
                		}
                	}
                    //先不理
                    if (cheakNameFlag == false) {
                        layer.msg("角色名称不能重复", {anim: 6, time: 1500});
                        return;
                    }

                    //当验证都通过后跳入后台进行数据保存操作
                    $.ajax({
                        url: contextPath + responseUrl,
                        dataType: 'json',
                        type: 'post',
                        async: false,
                        data: {//后台需要获取的参数
                            accountId: $("#accountId").val(),
                            accountName: (saveRoleType == 1 ? userName : userPhone),
                            roleType: saveRoleType,
                            roleId: saveRoleId,
                            companyId: saveCompany,
                            parkingId: $("#accountParkingSel").val(),
                            parkingUserId: parkingUserId,
                            realName: realName
                        },
                        complete: function (XHR, TS) {
                            var returnObj = eval('(' + XHR.responseText + ')');
                            if (returnObj.code != 200) {
                                layer.msg(returnObj.msg, {icon: 2, time: 2500});
                            } else {
                                layer.msg("操作成功", {icon: 1, time: 2500});
                            }
                            layer.close(index);
                            table.reload('accountTable');
                        }
                    });
                },//确认按钮操作结束

                end: function () { //只要层被销毁了，end都会执行
                    $('#showAccountContent').html(showContent);
                }

            });
        } //编辑或添加停车场的具体操作 end


        //监听行工具事件
        table.on('tool(accountTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'accountStatusBar') {
                layer.confirm('是否禁用该账号', function (index) {
                    $.ajax({
                        url: contextPath + "/account/changeAccountStatus",
                        dataType: 'json',
                        type: 'post',
                        data: {
                            accountId: data.accountId,
                            accountStatus: data.accountStatus
                        },
                        complete: function (XHR, TS) {
                            var returnObj = eval('(' + XHR.responseText + ')');
                            if (returnObj.code != 200) {
                                layer.msg(returnObj.msg, {icon: 2, time: 1500});
                            }
                            layer.close(index);
                            table.reload('accountTable');
                        }
                    });
                });
            }
            if (obj.event === 'delBar') {
                layer.confirm('是否删除该账号', function (index) {
                    $.ajax({
                        url: contextPath + "/account/del",
                        dataType: 'json',
                        type: 'post',
                        data: {
                            accountId: data.accountId,
                            userName:data.userName,
                            accountType:data.accountType
                        },
                        complete: function (XHR, TS) {
                            var returnObj = eval('(' + XHR.responseText + ')');
                            if (returnObj.code != 200) {
                                layer.msg(returnObj.msg, {icon: 2, time: 1500});
                            }
                            layer.close(index);
                            table.reload('accountTable');
                        }
                    });
                });
            }
            if (obj.event === 'editBar') {
                editAccount("edit", data);
            }

        });//监听行工具事件结束
    });
});