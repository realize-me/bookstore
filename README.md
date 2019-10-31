# bookstore
传智书城 Java Web项目练习

### **数据库创建**

数据库名称 itcast_bookstore

```mysql
CREATE DATABASE itcast_bookstore;
```



1. MySQL数据库的创建语句

   user 表

   ```mysql
   CREATE TABLE `user` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `username` varchar(20) DEFAULT NULL,
     `password` varchar(20) DEFAULT NULL,
     `gender` varchar(2) DEFAULT NULL,
     `email` varchar(50) DEFAULT NULL,
     `telephone` varchar(20) DEFAULT NULL,
     `introduce` varchar(100) DEFAULT NULL,
     `activeCode` varchar(50) DEFAULT NULL,
     `state` int(11) DEFAULT '0',
     `role` varchar(10) DEFAULT '普通用户',
     `registTime` datetime DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
   ```

   

   products 表

   ```mysql
   CREATE TABLE `products` (
     `id` varchar(100) NOT NULL,
     `name` varchar(40) DEFAULT NULL,
     `price` double DEFAULT NULL,
     `categroy` varchar(40) DEFAULT NULL,
     `pnum` int(11) DEFAULT NULL,
     `imgurl` varchar(100) DEFAULT NULL,
     `description` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   ```

   

   orders 表

   ```mysql
   CREATE TABLE `orders` (
     `id` varchar(100) NOT NULL,
     `money` double DEFAULT NULL,
     `receiverAddress` varchar(255) DEFAULT NULL,
     `receiverName` varchar(20) DEFAULT NULL,
     `receiverPhone` varchar(20) DEFAULT NULL,
     `payState` int(11) DEFAULT '0',
     `orderTime` datetime DEFAULT CURRENT_TIMESTAMP,
     `user_id` int(11) DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `user_id` (`user_id`),
     CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   ```

   

   orderitems 表

   ```mysql
   CREATE TABLE `orderitem` (
     `order_id` varchar(100) NOT NULL,
     `product_id` varchar(100) NOT NULL,
     `buynum` int(11) DEFAULT NULL,
     PRIMARY KEY (`order_id`,`product_id`),
     KEY `product_id` (`product_id`),
     CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
     CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   ```

   

   notice 表

   ```mysql
   CREATE TABLE `notice` (
     `n_id` int(11) NOT NULL AUTO_INCREMENT,
     `title` varchar(10) DEFAULT NULL,
     `details` varchar(255) DEFAULT NULL,
     `n_time` varchar(18) DEFAULT NULL,
     PRIMARY KEY (`n_id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   ```

   

### **功能使用**

**前台**：

1. 显示全部商品目录

   进入首页

   http://localhost:8080/bookstore/client/index.jsp 

   然后点击全部商品目录

   

   或者直接在地址栏输入

    http://localhost:8080/bookstore/ShowProductByPage 

2. 显示某一类商品

   进入首页后点击各类别

   或者直接在浏览器地址中输入

    [http://localhost:8080/bookstore/ShowProductByPage?category=%E7%A7%91%E6%8A%80](http://localhost:8080/bookstore/ShowProductByPage?category=科技) 

   category 的参数为中文字符

3. 添加购物车

   在商品展示页面下，某个商品条目上点击   “加入购物车”

   

   或者在浏览器地址栏输入，id后面为商品的 id

    http://localhost:8080/bookstore/AddCartServlet?id=2 

4. 用户注册

   在首页点击 “新账户注册”

   或者直接在浏览器地址输入

    http://localhost:8080/bookstore/client/register.jsp

5. 用户登陆

   在浏览器地址输入

    http://localhost:8080/bookstore/client/login.jsp 

6. 生成账单

   首先登陆，然后添加购物车

   进入购物车后点击结账

   填写收货地址和收件地址和收件人后提交

   订单自动保存到数据库

   

**后台：**

​		**准备工作：**在tomcat项目目录以外的地方新建一个目录A，然后修改 tomcat 中 conf 目录下的 server.xml文件

```xml
<!--在Host标签之间加入以下代码-->
<Context path="/TempFolder" docBase="目录A的绝对地址"></Context>
```

目录A用来存放商品的图片。



​		**商品管理**

1. 商品的增加

    http://localhost:8080/bookstore/manager/product_add.jsp 

2. 显示商品列表

    http://localhost:8080/bookstore/ProductListServlet 

3. 修改商品

   先进入商品列表，然后点击 编辑

   或者直接访问：

    http://localhost:8080/bookstore/FindProductById?id=5d3bd27b-aaf7-49f0-97ce-9c244ded8b1e&type=admin 

   id=商品的id编号

   type=admin，表示从后台访问

4. 删除商品

   先进入商品列表，然后点击  删除

   或者直接访问：

    http://localhost:8080/bookstore/DeleteProductServlet?id=c95212da-d9fc-4dae-ad51-9061868e2ffb 

   id=商品的id编号