# javaweb-project
一个功能简单的web项目，项目基于servlet+jsp，数据库为MySQL，，没有使用框架。前端用bootstrap功能较为简单登录注册，进入主界面对信息增删改查

项目所费精力主要在于几个校验模块

想要一起学习小伙伴可以加群686631375，学海途中与君共勉

/*******************************************     2018.12.08 补充     ********************************************/

用SSM框架改版的项目已经上传，项目地址为: https://github.com/yonyong/SSM_test.git

登录界面


![image](https://github.com/yonyong/javaweb-project/blob/master/image/login.jpg)


注册界面


![image](https://github.com/yonyong/javaweb-project/blob/master/image/register.jpg)


注册界面（在手机验证码输入错误后会出现图形验证码模块，只有图形验证码输入正确才可以继续发送手机验证码）


![image](https://github.com/yonyong/javaweb-project/blob/master/image/register2.jpg)


游客登录信息展示界面


![image](https://github.com/yonyong/javaweb-project/blob/master/image/info.jpg)


编辑信息界面


![image](https://github.com/yonyong/javaweb-project/blob/master/image/edit.jpg)


增加信息界面


![image](https://github.com/yonyong/javaweb-project/blob/master/image/add.jpg)


技术要点：

注册模块

除了图片给出的规则外还需满足以下要求：

1）	手机验证码有效期为60s，超过有效期需要重新获取；

2）	同一个手机号每分钟只能获取一次验证码；

3）	如果手机验证码输入出错，则需要添加图形验证码，只有图形验证码填写正确，才能获取手机验证码；

4）	密码需要进行MD5编码，存入数据库；

5）	注册成功后自动跳转到登录页面；

6）	手机验证码只需要模拟生成，不需要发送到手机。


登录模块

1）	密码连续输错3次后，2分钟内将不能再次登录；

2）	可以酌情增加密码找回功能；     （这个模块没有再做，原理基本一样）

3）	登录成功后跳转到消息列表页面；

