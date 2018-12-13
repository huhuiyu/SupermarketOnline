use SuperMarketOnline;

/* 清除数据 */
truncate table TbConfig;
truncate table TbToken;
truncate table TbTokenInfo;

/*token过期时间配置*/
insert into TbConfig(configKey,configValue) values('token.timeout','30');

/*查询*/
select configKey,configValue,lastupdate from TbConfig;
select token,lastupdate from TbToken;
select token,infokey,info,lastupdate from TbTokenInfo;
