layui.use(['form'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$;
    var clazz = null;

    // 监听页面渲染
    $(document).ready(function () {
        var id = getQueryString("id"),
            name = getQueryString("name"),
            grade = getQueryString("grade");

        $("#id").val(id);
        $("#name").val(name);
        $("#grade").val(grade);
    });

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        // console.log(data.field);
        $.ajax({
            url: "/page/clazz/update",
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
