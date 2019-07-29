define(['jquery', 'layui', 'until'], function ($, LAYUI, until) {
	layui.use(['table', 'form'], function () {
		var table = layui.table;
		var form = layui.form;
		if(i18n == 'en_US'){
			table.render({
				elem: '#recordTable',
				url: contextPath + "/monthlyCard/recordTable",
				method: 'post',
				cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				skin: 'line',
				where: {
					sortName: 'parkName',
					direction: 'desc'
				},
				cols: [[
					{ field: 'parkName', title: 'parkName', sort: true, align: 'center' },
					{ field: 'licensePlate', title: 'licensePlate', sort: true, align: 'center' },
					{ field: 'carOwnerName', title: 'carOwnerName', sort: true, align: 'center' },
					{ field: 'paymentMoney', title: 'paymentMoney', sort: true, align: 'center' },
					{
						field: 'paymentTime', title: 'paymentTime', sort: true, align: 'center', templet: function (data) {
							if (data.paymentTime == null) {
								return "";
							} else {
								return until.formatDateTime(data.paymentTime);
							}
						}
					},
					{
						field: 'expiryTime', title: 'expiryTime', sort: true, align: 'center', templet: function (data) {
							if (data.expiryTime == null) {
								return "";
							} else {
								return until.formatDateTime(data.expiryTime);
							}
						}
					}
				]],
				response: {
					countName: 'totalElements',  //规定数据总数的字段名称，默认：count
					dataName: 'content' //规定数据列表的字段名称，默认：data
				},
				page: true
			});
		}else{
			table.render({
				elem: '#recordTable',
				url: contextPath + "/monthlyCard/recordTable",
				method: 'post',
				cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				skin: 'line',
				where: {
					sortName: 'parkName',
					direction: 'desc'
				},
				cols: [[
					{ field: 'parkName', title: '停车场名称', sort: true, align: 'center' },
					{ field: 'licensePlate', title: '车牌号', sort: true, align: 'center' },
					{ field: 'carOwnerName', title: '车主姓名', sort: true, align: 'center' },
					{ field: 'paymentMoney', title: '缴费金额', sort: true, align: 'center' },
					{
						field: 'paymentTime', title: '缴费时间', sort: true, align: 'center', templet: function (data) {
							if (data.paymentTime == null) {
								return "";
							} else {
								return until.formatDateTime(data.paymentTime);
							}
						}
					},
					{
						field: 'expiryTime', title: '到期时间', sort: true, align: 'center', templet: function (data) {
							if (data.expiryTime == null) {
								return "";
							} else {
								return until.formatDateTime(data.expiryTime);
							}
						}
					}
				]],
				response: {
					countName: 'totalElements',  //规定数据总数的字段名称，默认：count
					dataName: 'content' //规定数据列表的字段名称，默认：data
				},
				page: true
			});
		}

		table.on('sort(recordTable)', function (obj) {
			//注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			//console.log(obj.field); //当前排序的字段名
			//console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
			//console.log(this); //当前排序的 th 对象

			//尽管我们的 table 自带排序功能，但并没有请求服务端。
			//有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
			table.reload('recordTable', {
				initSort: obj, //记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
				where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
					field: obj.field, //排序字段
					order: obj.type //排序方式
				}
			});
		});
	});
});