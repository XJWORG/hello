drop database if exists shop;
/*创建数据库，并设置编码*/
create database shop default character set utf8;

use shop;
/*删除管理员表*/
drop table if exists account;
/*删除商品类别表*/
drop table if exists category;

/*============================*/
/*      Table：管理员表结构                       */
/*============================*/
create table account
(
    /* 管理员编号，自动增长 */
    id int primary key not null auto_increment,
    /* 管理员登录名 */
    login varchar(20),
    /* 管理员姓名 */
    name varchar(20),
    /* 管理员密码 */
    pass varchar(20)
);

/*============================*/
/*     Table：商品类别表结构                      */
/*============================*/
create table category
(
   /* 类别编号，自动增长 */
   id  int primary key not null auto_increment,
   /* 类别名称 */
   type varchar(20),
   /* 类别是否为热点类别，热点类别才有可能显示在首页*/
   hot  bool default false,
   /* 外键，此类别由哪位管理员管理 */
   account_id int,
   constraint aid_FK foreign key(account_id) references account(id)
);

/*=============================*/
/* Table: 商品表结构            */
/*=============================*/
create table product
(
   /* 商品编号,自动增长 */
   id                  int primary key not null auto_increment,
   /* 商品名称 */
   name                varchar(20),
   /* 商品价格 */
   price               decimal(8,2),
   /* 商品图片 */
   pic                 varchar(200),
   /* 商品简单介绍 */
   remark              longtext,
   /* 商品详细介绍 */
   xremark             longtext,
   /* 商品生产日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   commend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   open                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   constraint cid_FK foreign key(cid) references category(id)
);