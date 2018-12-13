# SupermarketOnline

- 后台项目依赖
  - 在临时下载目录里面打开`Git Bash Here`
  - 执行`git clone git@github.com:huhuiyu/springboot-mybatis-base.git SupermarketOnline`
  - 将里面的项目名称修改为`SupermarketOnline`
  - 编辑项目里面的`.project`文件，将里面的项目名称修改为`SupermarketOnline`
  - 编辑项目里面的`settings.gradle`文件，将里面的项目名称修改为`SupermarketOnline`
  - 将项目复制到当前项目中
  - 将项目`import`到`eclipse`中
  - 将 package 名称重构为项目自己的 package 名称
  - 将 BaseAop 类中的 controller 切面修改正确
  - 将 sql 文件中的数据库名称更改为项目的数据库名称
  - 将 mybatis-config.xml 中的 package 名称修改正确
  - 将所有的 mapper 的 xml 文件中的 package 名称修改正确
  - 将 application.yml 文件中的数据库连接修改正确
  - 将 run 目录中的脚本文件中的路径和项目名称修改正确
  - 将项目 clean，build
  - 启动项目并测试 url，第一次需要获取 token，后面都要使用第一次获取的 token
    - `http://127.0.0.1:14000/?token=250c7d66-536a-4043-9b87-4da639c5ec8e&echo=123`
    - `http://127.0.0.1:14000/util/validate.jpg?token=250c7d66-536a-4043-9b87-4da639c5ec8e`
    - `http://127.0.0.1:14000/test/checkImageCode?token=250c7d66-536a-4043-9b87-4da639c5ec8e&imageCode=ehx1x`
- 前台项目依赖
  - 在临时下载目录里面打开`Git Bash Here`
  - 执行`git clone git@github.com:huhuiyu/angularjs-base.git SupermarketOnlineStatic`
  - 删除`.git`和`docs`目录以及所有`.md`文件后复制到当前项目
  - 访问[angulars-base](https://github.com/huhuiyu/angularjs-base)项目获取项目初始化说明
  