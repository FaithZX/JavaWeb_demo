<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		1.导入springJDBC的架包
		2.新建配置文件  bean.xml
		3.告诉springmvc  我有了bean.xml配置文件   在web.xml中配置
			<!-- springJDBC 配置 -->
			  &lt;context-param&gt;
			  	&lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
			  	&lt;param-value&gt;classpath:bean.xml&lt;/param-value&gt;
			  &lt;/context-param&gt;
			  &lt;listener&gt;
			  	&lt;listener-class&gt;org.springframework.web.context.ContextLoaderListener&lt;/listener-class&gt;
			  &lt;/listener&gt;
		4.配置 bean.xml文件  进行数据库连接
			&lt;!-- 开启注解模式 -->
			&lt;context:annotation-config>&lt;/context:annotation-config>
			
			&lt;!-- 开启包扫描 -->
			&lt;context:component-scan base-package="com.service.impl">&lt;/context:component-scan>
		
			&lt;!-- 读取数据库配置文件 -->
			&lt;context:property-placeholder location="classpath:jdbc.properties"/>
			
			&lt;!-- 配置数据源 -->
			&lt;bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
				&lt;property name="driverClassName" value="${driver}">&lt;/property>
				&lt;property name="url" value="${url}">&lt;/property>
				&lt;property name="username" value="${username}">&lt;/property>
				&lt;property name="password" value="${password}">&lt;/property>
			&lt;/bean>
			
			&lt;!-- 配置事物管理 -->
			&lt;bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
				&lt;property name="dataSource" ref="dataSource">&lt;/property>
			&lt;/bean>
			
			&lt;!-- 开启注解驱动 -->
			&lt;tx:annotation-driven transaction-manager="transactionManager"/>
		5.编写	jdbc.properties 文件  （数据库连接方式）
			driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/test"
			username="root"
			password="root"
		6.编写MVC分层模式   
		7.注解
			1).dao层需要继承JdbcDaoSupport 需要传入dataSource 到父类中
			@Resource 
			public final void setJdbcDaoDataSource(DataSource dataSource) {
				super.setDataSource(dataSource);
			}
			
			2).@Resource  获取数据源dataSource   同时也可用于dao层的注入上
			@Resource
			private UserDao userdao;
			
			3).@Service 主要用于service的实现类上
			@Service
			public class UserServiceImpl implements UserService {}
			
			4).@Autowired 用户注入service注入
			@Autowired
			private UserService userService;
		8.@Transactional 开启事物   需要commit就打上这个注解
			如果需要回滚  必须要按照以下写法  抛出异常
			@Transactional
			@Override
			public int saveUser(User user) {
				try {
					return userdao.saveUser(user);
				} catch (Exception e) {
					// 抛出异常 用于报错回滚
					throw new RuntimeException();
				}
			}
			
		9.插入数据时返回主键
			@Override
			public int saveUserReturnKey(User user) {
				System.out.println(user.toString());
				// 接受插入数据是返回的主键值
				KeyHolder key = new GeneratedKeyHolder();
				// 往数据库插入数据并且返回主键值
				this.getJdbcTemplate().update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// 做数据库持久化   插入数据
						PreparedStatement prepareStatement = con.prepareStatement("insert into user (username,password,age,birth) values (?,?,?,?)", new String[] {"user_id"});
						//给占位符赋值  数字表示第几个占位符
						prepareStatement.setString(1,user.getUsername() );
						prepareStatement.setString(2,user.getPassword());
						prepareStatement.setInt(3,user.getAge());
						prepareStatement.setDate(4,new Date(999999));
						return prepareStatement;
					}
				},key);
					//返回主键   因为KeyHolder key是一个对象  所以需要从中取出 key 并转为int类型
				return key.getKey().intValue();
			}
				
		10.查询表中多条数据，返回List集合
			@SuppressWarnings("unchecked")
			@Override
			public List<User> getAllUser() {
				//新建list集合接受所有的用户信息
				List<User> userList = new ArrayList<User>();
				// 做数据库持久化  并且用 userList 接受查询出来数据
				userList = this.getJdbcTemplate().query("select * from user ", new RowMapper() {
					//  类似循环  所有的数据在ResultSet rs 对象中取，  也可以根据行数取int rowNum
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						//新建user对象   从数据库取到的数据保存user的属性中
						User user = new User();
						//  rs.getString(2)   getString是要取的数据的类型   2是属性在行的第几列
						user.setUsername(rs.getString(2));
						user.setPassword(rs.getString(3));
						user.setAge(rs.getInt(4));
						user.setBirth(rs.getDate(5));
						//  返回user对象    SpringJDBC会自动将user   添加到  userList 中
						return user;
					}
				});
				return userList;
			}
			
	</pre>
	<a href="addUserView">新增用户 </a>
</body>
</html>