layui.use(['form', 'tableSelect'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$,
        tableSelect = layui.tableSelect;
    var clazz = null;

    var url =  document.URL;
    url = url.replace(/\/[^\/]+\/[^\/]+$/,"");
    // console.log(url);

    // 监听页面渲染
    $(document).ready(function () {
        var tno = getQueryString("tno"),
            name = getQueryString("name"),
            openid = getQueryString("openid"),
            clazz = getQueryString("clazz");

        $("#tno").val(tno);
        $("#name").val(name);
        $("#clazz").val(clazz);
        if (openid !== "null")
            $("#openid").val(openid);
    });

    // 选择表单
    tableSelect.render({
        elem: '#clazz',
        checkedKey: 'id',
        table: {
            url: url+'/clazz/getAll',
            cols: [[
                { type: 'radio' },
                { field: 'id', title: 'ID' },
                { field: 'name', title: '班级' },
                { field: 'grade', title: '年级' }
            ]]
        },
        done: function (elem, data){
            $("#clazz").val(data.data[0]['name']);
            clazz = data.data[0]['id']
        }
    })

    // 监听清除openid
    $("#clear_openid").on("click", function () {
        $("#openid").val("");
    });

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        data.field["clazzId"] = clazz;
        // console.log(data.field);

        $.ajax({
            url: "/page/teacher/update",
            data: data.field,
            method: "Put",
            success: function (data) {
                if (data.status)
                    layer.msg("修改成功", {time: 1500}, function () {
                        var iframeIndex = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(iframeIndex);
                        parent.location.reload();
                    });
                else
                    layer.msg("修改失败", {time: 1500});
            },
            error: function (data) {
                layer.msg("Error", {time: 1500});
            }
        });

        return false;
    });
});
