### 某签到APP自动签到系统

为解决学生忘记签到，开发了此系统。

注意！！！此系统仅支持签到！

### 食用方法

由于时间紧，再加上各种事情，没有写地图选点，地图选点为签到点，右上角有一个坐标，按顺序填写即可。
http://api.map.baidu.com/lbsapi/getpoint/index.html

会员管理里：
①用户列表→添加用户→使用手机号登录今日校园。
②签到列表→添加签到→经纬度等信息填写，注意选择自己的(之后会开发有登录系统，只显示自己的)，还有是否在范围内，别忘记上传照片（如果学校不要求，无需上传照片）。

### 注意事项

因某些原因，本项目已隐去关键信息，有需要可以加QQ群交流（完全交流，不提供盈利服务）：1042143347。

欢迎开发者加入！

此外，带附加信息的并没有进行适配，有兴趣开发者可以加群交流。

注意！！！本项目仅作为个人学习OKHttp4以及Quartz、Orika等技术所编写的项目！！！纯练手，有很多不足之处。

如果喜欢，请给个Star！！！

### 技术选型

【前端】
OK ADMIN
LayUI
jQuery

【后端】
Spring Boot（后端脚手架）
Mybatis（数据库持久化）
Mybatis Plus（数据库持久化助手）
Orika（深拷贝）
Quartz（定时任务）
Fastjson（JSON解析）
AliyunOSS（OSS）
OKHttp4（HTTP客户端）

【数据库】
MySQL

【服务容器】
阿里云云开发平台产物（基于Serverless的SAE，通过阿里云的云效，进行ROS自动编排，部署到SAE中的Docker中，http://workbench.aliyun.com）
Tomcat
