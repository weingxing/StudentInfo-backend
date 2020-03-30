layui.use(['form', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layuimini = layui.layuimini;

    table.render({
        elem: '#currentTableId',
        url: 'teacher/getAll',
        // data: data.content,
        toolbar: '#toolbarDemo',
        defaultToolbar: ['filter', 'exports', 'print', {
            title: '提示',
            layEvent: 'LAYTABLE_TIPS',
            icon: 'layui-icon-tips'
        }],
        cols: [[
            {type: "checkbox", width: 50, fixed: "left", align: "center"},
            {field: 'tno', width: 150, title: '工号', align: "center"},
            {field: 'name', width: 150, title: '姓名', align: "center"},
            {field: 'clazz', width: 150, title: '行政班级', align: "center"},
            {field: 'openid', width: 400, title: 'openid', align: "center"},
            {title: '操作', minWidth: 150, templet: '#currentTableBar', fixed: "right", align: "center"}
        ]],
        limits: [10, 15, 20, 25, 50],
        limit: 15,
        page: true
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = JSON.stringify(data.field);


        //执行搜索重载
        table.reload('currentTableId', {
            url: '/page/teacher/search',
            where: {
                keyword: data.field.keyword
            },
            limits: [10, 15, 20, 25, 50],
            limit: 15,
            page: true
        });

        return false;
    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {

        var index = layer.open({
            title: '添加用户',
            type: 2,
            shade: 0.2,
            maxmin:true,
            shadeClose: true,
            area: ['100%', '100%'],
            content: '/page/teacher/add.html',
        });
        $(window).on("resize", function () {
            layer.full(index);
        });

        return false;
    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId')
            , data = checkStatus.data;

        if (data.length === 0){
            layer.msg("未选择用户", {time: 1500});
        } else {
            layer.confirm('确定要删除？', function (index) {
                for (var i = 0; i < data.length; i++) {
                    $.ajax({
                        url: "/page/teacher/delete",
                        data: {tno: data[i].tno},
                        method: "Delete",
                        success: function (data) {
                            if (data.status) {
                                layer.msg("删除成功", {time: 1500});

                            } else {
                                layer.msg("删除失败", {time: 1500});
                            }
                        },
                        error: function (data) {
                            layer.msg("Error", {time: 1500});
                        }
                    });
                }

                table.reload("currentTableId", {
                    url: '/page/teacher/getAll'
                });

                layer.close(index);
            });
        }

        // layer.alert(JSON.stringify(data));
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {

    });

    // 监听工具条
    table.on('tool(currentTableFilter)', function (obj) {
        if (obj.event === 'edit') {
            var index = layer.open({
                title: '编辑用户',
                type: 2,
                shade: 0.2,
                maxmin:true,
                shadeClose: true,
                area: ['100%', '100%'],
                content: '/page/teacher/edit.html?tno=' + obj.data.tno +
                    "&name=" + obj.data.name + "&openid=" + obj.data.openid +
                    "&clazz=" + obj.data.clazz,
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
            return false;
        } else if (obj.event === 'delete') {
            layer.confirm('确定要删除？', function (index) {
                $.ajax({
                    url: "/page/teacher/delete",
                    data: {tno: obj.data.tno},
                    method: "Delete",
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (data) {
                        layer.alert("删除失败", {title:"提示"});
                    }
                });
                obj.del();
                layer.msg("删除成功", {time: 1500});
                layer.close(index);
            });
        }
    });

});