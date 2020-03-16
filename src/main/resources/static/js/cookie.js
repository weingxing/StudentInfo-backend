/**
 * 添加cookie
 * @param name cookie名字
 * @param value 值
 */
function setCookie(name, value, Days)
{
    if(Days == null|| Days == ''){
        Days = 30;
    }

    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

/**
 * 获取cookie
 * @param name cookie名称
 * @returns cookie的值
 */
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]);
    return null;
}

/**
 * 删除cookie
 * @param name cookie名字
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) {
        // 这里删除操作其实是将expires过期时间设置为当前时间，使cookie立即过期
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }
}
