use information_schema;
drop database if exists SuperMarketOnline;
create database SuperMarketOnline default charset utf8 collate utf8_general_ci;
use SuperMarketOnline;

/*系统配置表*/
create table TbConfig
(
  configKey varchar(50) primary key comment '配置键名，主键',
  configValue varchar(2000) not null comment '配置键值',
  lastupdate timestamp comment '配置最后更新时间'
);

/* 用户Token追踪表 */
create table TbToken
(
  token varchar(50) primary key comment '令牌值，自然主键',
  lastupdate timestamp comment '令牌环最后更新时间'
);

/* Token附加信息表 */
create table TbTokenInfo
(
  token varchar(50) comment '令牌值',
  infokey varchar(50) comment '令牌附加信息key',
  info varchar(2000) comment '令牌附加信息',
  lastupdate timestamp comment '令牌环最后更新时间',
  constraint pkTbTokenInfo primary key(token,infokey)
);

/* 后台管理员用户 */
create table TbAdminUser
(
  auid int auto_increment primary key comment '主键',
  username varchar(20) unique not null comment '用户名',
  password varchar(20) not null comment '密码',
  nickname varchar(50) not null comment '昵称',
  isEnable enum('y','n') default 'y' comment '是否启用，y:默认，启用，n:停用',
  lastupdate timestamp default now() comment '最后更新时间'
);

/* 商品大分类 */
create table TbType
(
  tid int auto_increment primary key comment '主键',
  typeName varchar(8) unique not null comment '分类名称',
  typeInfo varchar(200) not null comment '分类描述',
  isEnable enum('y','n') default 'y' comment '是否启用，y:默认，启用，n:停用',
  lastupdate timestamp default now() comment '最后更新时间'
);

/* 商品小分类 */
create table TbSubType
(
  stid int auto_increment primary key comment '主键',
  tid int not null comment '外键，所属大类',
  subName varchar(8) not null comment '分类名称',
  subInfo varchar(200) not null comment '分类描述',
  isEnable enum('y','n') default 'y' comment '是否启用，y:默认，启用，n:停用',
  lastupdate timestamp default now() comment '最后更新时间',
  constraint uniqueTbSubType unique(tid,subName)
);

