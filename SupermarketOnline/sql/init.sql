use SuperMarketOnline;

/* 清除数据 */
truncate table TbConfig;
truncate table TbToken;
truncate table TbTokenInfo;

truncate table TbAdminUser;
truncate table TbType;
truncate table TbSubType;

/*token过期时间配置*/
insert into TbConfig(configKey,configValue) values('token.timeout','30');
/*默认后台管理用户*/
insert into TbAdminUser(username,password,nickname) values('admin','admin-pwd','内置管理源');

/*查询*/
select configKey,configValue,lastupdate from TbConfig;
select token,lastupdate from TbToken;
select token,infokey,info,lastupdate from TbTokenInfo;

select auid,username,password,nickname,isEnable,lastupdate from TbAdminUser;
select tid,typeName,typeInfo,isEnable,lastupdate from TbType;
select stid,tid,subName,subInfo,isEnable,lastupdate from TbSubType;
