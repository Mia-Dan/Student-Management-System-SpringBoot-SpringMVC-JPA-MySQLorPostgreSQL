package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Short gender; //性别 , 1 男, 2 女
    private String image; //图像url
    private Short job; //职位 , 1 班主任 , 2 讲师 , 3 学工主管 , 4 教研主管 , 5 咨询师
    private LocalDate entrydate; //入职日期
    private Integer deptId; //部门ID
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}

//    Creating a new SqlSession
//        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@447df732] was not registered for synchronization because synchronization is not active
//        JDBC Connection [HikariProxyConnection@496539939 wrapping com.mysql.cj.jdbc.ConnectionImpl@10483a1d] will not be managed by Spring
//        ==>  Preparing: insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)values (?,?,?,?,?,?,?,?,?)
//        ==> Parameters: A(String), AA(String), 2(Short), (String), 1(Short), 2023-12-24(LocalDate), 4(Integer), 2023-12-25T20:58:13.433(LocalDateTime), 2023-12-25T20:58:13.433(LocalDateTime)
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@447df732]
//        2023-12-25 20:58:13.580 ERROR 20700 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.dao.DataIntegrityViolationException:
//        ### Error updating database.  Cause: java.sql.SQLException: Field 'id' doesn't have a default value
//        ### The error may exist in com/example/mapper/EmpMapper.java (best guess)
//        ### The error may involve com.example.mapper.EmpMapper.save-Inline
//        ### The error occurred while setting parameters
//        ### SQL: insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)values (?,?,?,?,?,?,?,?,?)
//        ### Cause: java.sql.SQLException: Field 'id' doesn't have a default value
//        ; Field 'id' doesn't have a default value; nested exception is java.sql.SQLException: Field 'id' doesn't have a default value] with root cause
//
//        java.sql.SQLException: Field 'id' doesn't have a default value
//        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129) ~[mysql-connector-j-8.0.31.jar:8.0.31]
//        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.0.31.jar:8.0.31]
//        at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:916) ~[mysql-connector-j-8.0.31.jar:8.0.31]
//        at com.mysql.cj.jdbc.ClientPreparedStatement.execute(ClientPreparedStatement.java:354) ~[mysql-connector-j-8.0.31.jar:8.0.31]
//        at com.zaxxer.hikari.pool.ProxyPreparedStatement.execute(ProxyPreparedStatement.java:44) ~[HikariCP-4.0.3.jar:na]
//        at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.execute(HikariProxyPreparedStatement.java) ~[HikariCP-4.0.3.jar:na]
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_371]
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_371]
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_371]
//        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_371]
//        at org.apache.ibatis.logging.jdbc.PreparedStatementLogger.invoke(PreparedStatementLogger.java:59) ~[mybatis-3.5.11.jar:3.5.11]
//        at com.sun.proxy.$Proxy122.execute(Unknown Source) ~[na:na]
//        at org.apache.ibatis.executor.statement.PreparedStatementHandler.update(PreparedStatementHandler.java:47) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.executor.statement.RoutingStatementHandler.update(RoutingStatementHandler.java:74) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.executor.SimpleExecutor.doUpdate(SimpleExecutor.java:50) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.executor.BaseExecutor.update(BaseExecutor.java:117) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.executor.CachingExecutor.update(CachingExecutor.java:76) ~[mybatis-3.5.11.jar:3.5.11]
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_371]
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_371]
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_371]
//        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_371]
//        at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:64) ~[mybatis-3.5.11.jar:3.5.11]
//        at com.sun.proxy.$Proxy121.update(Unknown Source) ~[na:na]
//        at org.apache.ibatis.session.defaults.DefaultSqlSession.update(DefaultSqlSession.java:194) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.session.defaults.DefaultSqlSession.insert(DefaultSqlSession.java:181) ~[mybatis-3.5.11.jar:3.5.11]
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_371]
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_371]
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_371]
//        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_371]
//        at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:425) ~[mybatis-spring-2.1.0.jar:2.1.0]
//        at com.sun.proxy.$Proxy106.insert(Unknown Source) ~[na:na]
//        at org.mybatis.spring.SqlSessionTemplate.insert(SqlSessionTemplate.java:272) ~[mybatis-spring-2.1.0.jar:2.1.0]
//        at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:62) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:145) ~[mybatis-3.5.11.jar:3.5.11]
//        at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:86) ~[mybatis-3.5.11.jar:3.5.11]
//        at com.sun.proxy.$Proxy109.save(Unknown Source) ~[na:na]
//        at com.example.service.impl.EmpServiceImpl.save(EmpServiceImpl.java:46) ~[classes/:na]
//        at com.example.controller.EmpController.save(EmpController.java:41) ~[classes/:na]
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_371]
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_371]
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_371]
//        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_371]
//        at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1071) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:964) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at javax.servlet.http.HttpServlet.service(HttpServlet.java:696) ~[tomcat-embed-core-9.0.69.jar:4.0.FR]
//        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.24.jar:5.3.24]
//        at javax.servlet.http.HttpServlet.service(HttpServlet.java:779) ~[tomcat-embed-core-9.0.69.jar:4.0.FR]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:177) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:891) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1784) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.69.jar:9.0.69]
//        at java.lang.Thread.run(Thread.java:750) [na:1.8.0_371]
//
