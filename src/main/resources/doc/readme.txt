1. 代码结构说明
src
--main
  --java
    --com
      --mc
        --config
        --constant
        --controller
        --enumeration
        --filter
        --mapper
        --model
        --properties
        --service
        --system
        --util
        --vo
  --resources
    --doc
    --mapper

2. config说明
DataSourceConfig：数据源及实例化相关配置，支持单/多数据源配置。
FileConfig：文件上传下载相关配置。
FileConfig：过滤器优先级配置。
MybatisConfig：Mybatis相关配置。
QkMapperConfig：简化SQL操作工具。
RedisConfig：redis相关配置。
Swagger2Config：接口文档说明swagger相关配置。
ThreadPoolConfig：JDK线程池相关参数配置。
TransactionConfig：service层事务处理，以方法命名进行自动事务处理。
WebMvcConfig：mvc相关配置。

3. system说明
AopController：处理controller层的aop内容。
AopService：处理service层的aop内容。
McBusinessException：业务异常封装。
McLog：日志封装。
MCResult：结果格式封装。

4. 系统说明
1）主要为springboot 1.5.9.RELEASE + mybatis 1.3.1 + mysql 5.7 + redis 3.2.100，其他内容见pom.xml
2）支持多数据源配置。
3）支持配置化文件上传和下载。
4）支持token及权限配置化管理。
5）独立的MC基础架构封装内容。
6）支持swagger接口阅读，不建议。
7）以service方法命名的方式支持事务。
8）支持QK工具操作SQL。
9）RESTFUL风格
10）支持多种结构redis操作封装。
11）支持mybatis文件自动生成。
12）支持邮件发送功能。
13）数据结构可支持一人多角色，考虑到一对多用途较少，程序目前仅实现一人一角色。

5. Springboot 版本+ jdk 版本 + Maven 版本的对应关系
Spring boot 版本	Spring Framework	jdk 版本	maven 版本
1.2.0 版本之前	 	                                6	            3.0
1.2.0	                    4.1.3+	                    6	            3.2+
1.2.1	                    4.1.3+		                7	        	3.2+
1.2.3	                    4.1.5+		                7		        3.2+
1.3.4	                    4.2.6+	                	7		        3.2+
1.3.6		                4.2.7+	                	7	        	3.2+
1.3.7		                4.2.7+	                	7	        	3.2+
1.3.8		                4.2.8+	                	7	        	3.2+
1.4.0		                4.3.2+	                	7		        3.2+
1.4.1		                4.3.3	                 	    7		        3.2+
1.4.2	                	4.3.4	                	    7		        3.2+
1.4.3		                4.3.5		                    7		        3.2+
1.4.4		                4.3.6	                	    7		        3.2+
1.4.5		                4.3.7	                	    7	        	3.2+
1.4.6		                4.3.8	                	    7	        	3.2+
1.4.7	                	4.3.9		                    7	        	3.2+
1.5.0		                4.3.6		                    7		        3.2+
1.5.2	                	4.3.7		                    7		        3.2+
1.5.3	                	4.3.8	                	    7	        	3.2+
1.5.4	                	4.3.9	                	    7	        	3.2+
1.5.5	                	4.3.10		                7		        3.2+
1.5.7		                4.3.11		                7	        	3.2+
1.5.8		                4.3.12		                7		        3.2+
1.5.9		                4.3.13		                7	        	3.2+
2.0.0		                5.0.2	                        8  	        3.2+