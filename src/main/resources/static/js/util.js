function encrypted(data) {
    var encrypt = new JSEncrypt();
    var pubkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAisSlRSu7+ecgLdpYU7b5uRN8/6kpWjwR\n" +
        "TTcnz6lpyh6lE709sU16Cyw2K5YGv5oyL3cY190nWwdaoOhxUloNpb6K11NOdh6fPWaNxS7B33qw\n" +
        "cttWpNUd5f/32v2ndsJXAVJOVpNYJrq04EX61hmaeGjImo+0pGVxBAMp2fLFcVaWvno8I31fyMxS\n" +
        "vMkd/qisLy1XzwhKUScUuVJ7pWqDEaIoef6OHdJTX6NAB0lIaHRY+1ilPWr6bTf0+1etZn8TCz0k\n" +
        "jTZkkAV4ZXgZaAWDFyyhHIRjC/UQ7UF7D3LqFvIUwWmFR2EJthpRhpJ2FSjC7M3CEL1rZPcReoqq\n" +
        "eGH0DQIDAQAB";
    encrypt.setPublicKey(pubkey);
    return encrypt.encrypt(data);
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}
