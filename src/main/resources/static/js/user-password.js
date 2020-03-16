layui.use(['form','layuimini'], function () {
    var form = layui.form,
        layer = layui.layer,
        layuimini = layui.layuimini,
        $ = layui.jquery;

    var user = JSON.parse(getCookie("user"));

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        var password = encrypted(data.field.new_password);
        var oldPassword = encrypted(data.field.old_password);

        if (String(data.field.new_password).length < 6) {
            layer.alert("密码太短", {title: '提示'});
            return false;
        }

        if (data.field.new_password != data.field.again_password) {
            layer.alert("两次输入的密码不同", {title: '提示'});
            return false;
        }

        $.ajax({
            url: "/user/changePassword",
            data: {uid: user.uid, oldPassword: oldPassword, password: password},
            type: "POST",
            success: function (data) {
                if (data.status) {
                    layer.alert("修改成功", { title: '提示' },
                        function () {
                            // layer.close(index);
                            layuimini.closeCurrentTab();
                        });
                } else {
                    layer.alert("修改失败", { title: '提示' });
                }
            },
            error: function (data) {
                layer.alert("修改失败", { title: '提示' });
            }
        });
        return false;
    });
});
