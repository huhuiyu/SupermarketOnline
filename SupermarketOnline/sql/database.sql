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
