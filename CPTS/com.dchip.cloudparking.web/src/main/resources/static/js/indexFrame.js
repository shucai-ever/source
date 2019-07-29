define(['jquery', 'until', 'layui', 'loadPage','csrf','translate'], function($, until){
	
	$(function(){
	    // do something
//	    var script=document.createElement("script");
//	    script.type="text/javascript";
//	    script.src="js/translate.js";
//	    document.getElementsByTagName('head')[0].appendChild(script);
	 
	    var value = sessionStorage.getItem("language");
	    document.onreadystatechange = function () {
	        if (document.readyState == 'complete') {
	            if(value==="1"){
	                Microsoft.Translator.Widget.Translate('zh-CHS', 'en', onProgress, onError, onComplete, onRestoreOriginal, 2000);
	            }
	        }
	    }
	    function onProgress(value) {
	    }
	    function onError(error) {
	    }
	    function onComplete() {
	        $("#WidgetFloaterPanels").hide();
	    }
	    function onRestoreOriginal() {
	    }
	});
	
	$("#changeLanguage").click(function(){debugger
		translate();
	});
	
	function translate(){debugger
	    var value = sessionStorage.getItem("language");
	    if(value==="1"){
	        sessionStorage.setItem("language", "0");
	    }else{
	        sessionStorage.setItem("language", "1");
	    }
	    window.location.reload();//刷新当前页面.
	}
	
	//首页菜单配置 start
	var menuListJson = menuListObj.replace(/&quot;/g,'"');
	var menuList = $.parseJSON(menuListJson);
	var addHtml;
	console.log(menuList);
	$.each(menuList, function(i,menu){
		addHtml += '<li class="layui-nav-item">';
		if(menu.hasOwnProperty("children") && menu.children.length>0){
			if(i18n != null && i18n == "en_US"){
				addHtml += '<a class=""><i class="'+ menu.iconcss +'"></i><span class="list-span-font"}">'+ menu.menuCss +'</span></a>';
				addHtml += '<dl class="layui-nav-child">';
					$.each(menu.children,function(c,child){
						addHtml += '<dd><a class="show-new-tab" data-url="'+ child.href +'" data-id="'+ child.id +'"><i class="'+ child.iconcss +'"></i><span class="list-span-font">'+ child.menuCss +'</span></a></dd>';
					});
				addHtml += '</dl>';
				}
			else{
				addHtml += '<a class=""><i class="'+ menu.iconcss +'"></i><span class="list-span-font"}">'+ menu.name +'</span></a>';
				addHtml += '<dl class="layui-nav-child">';
				$.each(menu.children,function(c,child){
					addHtml += '<dd><a class="show-new-tab" data-url="'+ child.href +'" data-id="'+ child.id +'"><i class="'+ child.iconcss +'"></i><span class="list-span-font">'+ child.name +'</span></a></dd>';
				});
				addHtml += '</dl>';
				}
		}else{
			if(i18n != null && i18n == "en_US"){
				addHtml += '<a class="show-new-tab" data-url="'+ menu.href +'" data-id="'+menu.id+'"><i class="'+ menu.iconcss +'"></i><span class="list-span-font">'+ menu.menuCss +'</span></a>';

			}else{
				addHtml += '<a class="show-new-tab" data-url="'+ menu.href +'" data-id="'+menu.id+'"><i class="'+ menu.iconcss +'"></i><span class="list-span-font">'+ menu.name +'</span></a>';
			}
		}
		addHtml += '</li>';
	});
	$("#showIndexMenu").html(addHtml);
	//首页菜单配置 end
	
	//IE11下要配置layui的文件路径，不然加上require下会执行不了
	layui.config({
		dir: contextPath + '/thirdplugin/layui/' 
	});
	
	/**
	 * 初始化layui
	 */
	layui.use(['element','layer'], function(){
		var $ = layui.jquery;
		var element = layui.element;  //Tab的切换功能，切换事件监听等，需要依赖element模块
		var layer = layui.layer;  //弹出层
		
		//监听导航点击
		element.on('nav(cloudParkingMenu)',
		function(elem) {
		    if ($(this).hasClass("show-new-tab")) {
		        var othis = $(this),
		        type = "tabAdd";
		        active[type].call(this, othis);
		    }
		});
		
		//切换页面
		$(document).off("click",".show-layui-tab-flag").on("click", ".show-layui-tab-flag", function(){
			var othis = $(this),
			type = "tabChange";
	        active[type].call(this, othis);
		});
		
		//删除按钮
		$(document).off("click",".layui-tab-close").on("click",".layui-tab-close",function(){
			var othis = $(this).parent(),
			type = "tabDelete";
	        active[type].call(this, othis);
		});
		
		var homepageStr = "平台主页";
		if(i18n != null && i18n == "en_US"){
			homepageStr = "Homepage of Platform";
		}else if(i18n != null && i18n == "zh_TW"){
			homepageStr = "平臺主頁";
		}
		//直接执行load首页操作
		element.tabAdd('showParkingTabBox', {
            title: '<i class="frame-title-icon index-title-icon"></i><span class="list-span-font">'+homepageStr+'<span>', 
            content: '<div class="load-tab-box" id="loadTabBoxNo0"></div>',
            id: "0"
        });		            
        LoadPage("loadTabBoxNo0", contextPath + "/homepage");
        element.tabChange('showParkingTabBox', 0);
        $(".show-layui-tab-flag.layui-this").attr("title","平台首页");
        $(".show-layui-tab-flag.layui-this").attr("data-url","/homepage");
        $(".show-layui-tab-flag.layui-this").attr("id","showIndexTab");

		//触发事件
		var active = {
		    tabAdd: function(othis) { //新增
		        var addFlag = 0;
		        $(".show-layui-tab-flag").each(function() { //检查标签页是否已打开
		            if ($(this).attr("lay-id") == othis.data('id')) {
		                addFlag = 1;
		            }
		        });
		        var loadTabBox = "loadTabBoxNo" + othis.data('id');
		        if (addFlag == 0) { //只有未打开的才可以新增
		            //新增一个Tab项		        	
		            element.tabAdd('showParkingTabBox', {
		                title: othis.html(), //tab标题
		                content: '<div class="load-tab-box" id="' + loadTabBox + '"></div>',
		                id: othis.data('id')
		            });		              
		        }
		        
		    	LoadPage(loadTabBox, contextPath + othis.data('url'));
		        element.tabChange('showParkingTabBox', othis.data('id'));
	            $(".show-layui-tab-flag.layui-this").attr("title",othis.find("span").html());
	            $(".show-layui-tab-flag.layui-this").attr("data-url",othis.data('url'));
		    },
		    tabDelete: function(othis) {
		        //删除指定Tab项
		    	$(othis).addClass("del-tab-flag");//添加删除falg
		    	var dthis = $(".show-layui-tab-flag.layui-this");
		    	var showId = dthis.attr("lay-id");
		    	$(".show-new-tab").each(function(){
		    		if($(this).attr("data-id") === showId) {
		    			$("dd").removeClass("layui-this");
		                $(".layui-nav-item").removeClass("layui-this");
		                $(this).parent().addClass("layui-this");
		                $(this).parent().parent().parent().addClass("layui-nav-itemed");
		    		}
		    	})
		    	var loadTabBox = "loadTabBoxNo" + dthis.attr('lay-id');
		    	$("#"+loadTabBox).html("");
		    	LoadPage(loadTabBox, contextPath + dthis.attr('data-url'));
		    },
		    tabChange: function(othis) {
		    	if(!$(othis).hasClass("del-tab-flag")){ //如果是已删除的就不执行
			    	$("dd").removeClass("layui-this");
	                $(".layui-nav-item").removeClass("layui-this");
	                $('a[data-id="'+$(othis).attr('lay-id')+'"]').parent().addClass("layui-this");
	                $('a[data-id="'+$(othis).attr('lay-id')+'"]').parent().parent().parent().addClass("layui-nav-itemed");
			        //切换到指定Tab项
			    	var loadTabBox = "loadTabBoxNo" + $(othis).attr('lay-id');
			    	$("#"+loadTabBox).html("");
			    	LoadPage(loadTabBox, contextPath + $(othis).attr('data-url'));
		    	}
		    }
		  };
		  
		  //用户首页禁止关闭
		  $("#showIndexTab").find("layui-tab-close").addClass("none");
		  var updatepasswordStr = "修改密码";
		  if(i18n != null && i18n == "en_US"){
			  updatepasswordStr = "update password";
		  }else if(i18n != null && i18n == "zh_TW"){
			  updatepasswordStr = "修改密碼";
		  }
		  //修改密码操作
		  $(document).off("click","#showIndexUpdatePW").on("click", "#showIndexUpdatePW", function(){
			  var showContent = $('#showIndexUpdatePWContent').html();
		 		$('#showIndexUpdatePWContent').html("");
		 		layer.open({
		 			type: 1,
		 			id: 'showLayui',
		 			title: updatepasswordStr,
		 			content: showContent, //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		 			area: '600px',
		 			btn: ['确定', '取消'],
		 			btnAlign: 'c',
		 			success: function(layero, index){//打开层之后可执行的回调
		 				layui.use(['form', 'layer'], function(){
		 					var form = layui.form;
		 					var layer = layui.layer;
		 					      
		 					form.render();  //重新渲染表单
		 				});
		 			},
		 			yes: function(index, layero){ //确定按钮
		 				var msgArr = ["原密码不能为空", "新密码不能为空", "确认密码不能为空"];  //提示语集合
		 				var clsArr = ["#sysOldPWInp", "#sysNewPWInp", "#sysConfirmPWInp"];  //id集合
		 				var validateFlag = until.validate(msgArr, clsArr); //非空验证 需要引入工具js文件until
		 				if(validateFlag){
		 					layer.msg(validateFlag , {anim: 6, time: 1500});  
		 					return ;
		 				};
		 				var numFlag = checkInpNum(clsArr); //检查长度是否小于6
		 				if(numFlag){
		 					layer.msg(numFlag , {anim: 6, time: 1500});  
		 					return ;
		 				};
		 				if($("#sysNewPWInp").val() != $("#sysConfirmPWInp").val()){
		 					layer.msg("新密码与确认密码不一致" , {anim: 6, time: 1500});  
		 					return ;a
		 				}
		 				$.ajax({
		 					  url: contextPath+"/account/updatePassWord",
		 					  dataType:'json',
		 					  type:'post',
		 					  async: false,
		 					  data : {
		 						  sysOldPWInp: $("#sysOldPWInp").val(),
		 						  sysNewPWInp : $("#sysNewPWInp").val()
		 					  },
		 					  complete: function(XHR, TS){
		 						  var returnObj = eval('(' + XHR.responseText + ')');
		 						  if(returnObj.code != 200){
		 							 layer.msg(returnObj.msg, {icon: 2, time: 1500});
		 						  }else{
		 							 layer.msg("修改成功，请重新登录", {icon: 1, time: 1500});	
		 							 layer.close(index); 
		 							 window.setTimeout(function(){
		 								window.location.href=contextPath+"/logOut";
		 							 }, 1000);
		 							 
		 						  }	 					 
		 					  }
		 				});
		 			    
		 			},
		 			end: function(){ //只要层被销毁了，end都会执行
		 				$('#showIndexUpdatePWContent').html(showContent);
		 			}
		 			
		 		});
		  });
		  
		  
	});
	
	  //设置内容高度
	  var showHeight;
	  showHeight = $(window).height();
	  $("#showLayuiTabContent").height(showHeight - 181);
	  //监听浏览器窗口大小变化
	  $(window).resize(function () {
		  showHeight = $(window).height();
		  $("#showLayuiTabContent").height(showHeight - 181);

		  //浏览器窗口大小变化时，隐藏tips框
          // console.log("window resize");
          $(".layui-table-tips-main").css("display","none");
          $(".layui-table-tips-c").css("display","none");
	  });

    $("#showLayuiTabContent").scroll(function () {
    	// console.log("showLayuiTabContent scroll");
        $(".layui-table-tips-main").css("display","none");
        $(".layui-table-tips-c").css("display","none");
    });
	  
	//检查是否达到6位
	function checkInpNum(clsArr) {
		var msg = [];
		var index = 0;
		for (var i = 0; i < clsArr.length; i++) {
			if ($(clsArr[i]).length == 0) {
				continue;
			}
			var val = $(clsArr[i]).val();
			if (val.length < 6) {
				msg = '密码长度不小于6位';
				$(clsArr[i]).focus();
				break;
			}
		}
		if (msg != "") {
			return msg;
		} else {
			return false;
		}
	}
	
	/**
	 * 禁用浏览器F5事件
	 */
	document.onkeydown = function(e) 
	{ 
		if ( event.keyCode==116) 
		{ 
			layer.closeAll();
			var showBoxId = $(".show-layui-tab-flag.layui-this").attr('lay-id');
			var showBoxUrl = $(".show-layui-tab-flag.layui-this").attr('data-url');
			var loadTabBox = "loadTabBoxNo" + showBoxId;
			LoadPage(loadTabBox, contextPath + showBoxUrl);
			event.keyCode = 0; 
			event.cancelBubble = true; 
			return false; 
		} 
	}
	
	//点击按钮去掉详情
	$(document).off("click",".layui-btn").on("click", ".layui-btn", function(){
		$(".layui-layer.layui-layer-tips.layui-table-tips").remove();
	});
	
	//禁用右键菜单
	var contextMenuBox = document.getElementById("contextMenuBox");
	contextMenuBox.oncontextmenu = function(e){
		console.log(11);
		return false;
	}
});