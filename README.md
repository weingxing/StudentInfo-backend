# 学生管理系统——后端
学生管理系统后端，基于SpringBoot实现，项目正在完善中，开发环境：MySQL 5.5 + Java 8  + IDEA，
使用opeid（同一微信号在不同的小程序中有不同的openid）作为用户身份认证，一定程度上确保数据安全。

目前仅实现了基本功能，维护数据还需要手动使用sql来维护，欢迎各位大佬来添砖加瓦~


## Todo-List

- [x] 完成基本功能，可上线使用
- [x] 完善后端其他功能
- [ ] <del>使用Redis或Ehcache做缓存，减轻数据库压力</del>
- [ ] 开发管理页面或桌面版管理工具，方便添加、修改数据



## 部署说明

项目为微信小程序后端，需要搭配 [学生管理系统前端](https://github.com/weingxing/StudentInfo-fronted) 使用，克隆项目到本地，导入IDEA，修改数据库连接地址、用户名、密码等信息，导入数据库文件到数据库，数据库studentinfo.sql文件位于 **src/sql** 目录，修改src\main\java\com\oxygen\studentinfo\util\WechatUtil.java 中的APP_ID和SECRET (第59行和第60行)为你的微信小程序APP_ID和SECRET，源码中使用 "XXXXXXX" 代替，不修改将无法正常使用 /login 接口获取openid。运行mvn中的package命令，将项目打包为jar文件，可直接上传到服务器，通过

```shell
nohup java -jar 打成的jar文件名  >temp.txt &
// 这种方法会把日志文件输入到你指定的文件中(temp.txt)，没有则会自动创建。进程会在后台运行。
```

命令运行，也可以修改pom.xml文件，打成war包，利用Tomcat部署。



为减轻服务器压力，可使用阿里云OOS等作为图床，项目中图片地址为后台根据学号生成并插入数据库，数据库中保存的是图片的地址，可修改**InfoController**中的**addInfo**方法，修改插入数据库的内容。

请在使用微信小程序绑定工号和姓名前，向数据库中提前导入待绑定的工号和姓名，不要导入openid字段，默认为Null即可，绑定时会先查询工号和姓名是否存在，数据存在且openid为空，可以绑定，否则提示 **没有权限**

## 数据安全

因为微信小程序为前后端分离，为确保后端数据安全，目前采取的方法是每次请求接口都要带上openid，如果数据库中存在openid，则返回数据，否则返回 "Access Denied"。
