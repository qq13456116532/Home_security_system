---

---

# Home_security_system
使用SSM的家用安防系统的设计与实现

by the way，如果需要代问GPT4，联系我。

# 开始 

以下是在你的本地机器上安装和运行项目的步骤：

下载本项目，执行db下的sql，使用IDEA打开，配置SSM：

![](/images/Snipaste_2023-06-11_21-47-12.png)

然后启动，访问 http://localhost:8080/ssm35n6k/admin/dist/index.html#/index  就是后台管理，管理员账号：admin

管理员密码：admin

访问http://localhost:8080/ssm35n6k/front/dist/index.html#/index/home 就是前台页面

#  预先准备

Java8以上，IDEA，MySQL8.0

如果需要修改前端那么node10-14

# 使用

![](/images/Snipaste_2023-06-11_21-35-36.png)

![](/images/Snipaste_2023-06-11_21-35-57.png)

![Snipaste_2023-06-11_21-36-11](/images/Snipaste_2023-06-11_21-36-11.png)

![Snipaste_2023-06-11_21-36-17](/images/Snipaste_2023-06-11_21-36-17.png)

![Snipaste_2023-06-11_21-42-59](/images/Snipaste_2023-06-11_21-42-59.png)

![Snipaste_2023-06-11_21-43-08](/images/Snipaste_2023-06-11_21-43-08.png)

![Snipaste_2023-06-11_21-43-16](/images/Snipaste_2023-06-11_21-43-16.png)

![Snipaste_2023-06-11_21-43-26](/images/Snipaste_2023-06-11_21-43-26.png)

![Snipaste_2023-06-11_21-43-32](/images/Snipaste_2023-06-11_21-43-32.png)

![Snipaste_2023-06-11_21-43-37](/images/Snipaste_2023-06-11_21-43-37.png)



# 贡献

1. Fork 这个项目
2. 创建你的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交你的改动 (`git commit -m 'Add some AmazingFeature'`)
4. 将你的改动推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开一个 Pull Request



# 修改

如果你需要修改后端代码，那么直接修改修改就可以了，如果你需要修改前端，那么你会发现都是压缩代码。

所以你需要先将![image-20230611220603256](/images/image-20230611220603256.png)



这个front文件夹都取出来使用hbuilderx或者vscode打开，然后

node版本要求：10-14

全局执行命令：
安装cnpm

npm uninstall -g cnpm

npm install cnpm@7.1.0 -g --registry=https://registry.npm.taobao.org



安装webpack: 

cnpm install webpack -g 

安装vue-cli脚手架工具:

cnpm install -g vue-cli 



然后修改对应代码之后使用 npm build 生成的dist重新复制到webapp里面，重新启动就修改好了。

#  许可证

 GPL















