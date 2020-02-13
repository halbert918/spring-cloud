# sharding-jdbc  
1.分表  
2.分库  
3.分库分表  
4.广播表（公共表，同一请求回处理所有的分库中公共表）  

# sharding-proxy
数据库代理端，提供封装了数据库二进制协议的服务端版本，用于完成对异构语言的支持。 
目前先提供MySQL/PostgreSQL版本，它可以使用任何兼容MySQL/PostgreSQL协议的访问客户端(如：MySQL Command Client, MySQL Workbench, Navicat等)操作数据，对DBA更加友好。   

1.向应用程序完全透明，可直接当做MySQL/PostgreSQL使用。   
2.适用于任何兼容MySQL/PostgreSQL协议的的客户端。  

