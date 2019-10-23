# bookstore
传智书城 Java Web项目练习

**数据库创建**

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

   