package com.sqlBuilder;
import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.entity.User;

import net.sf.cglib.beans.BeanGenerator;

@SuppressWarnings("unused")
public class UserSql {

	/**
	 * 根据id查询user对象   
	 * Map<String, Object> param  中 key  是形参   value是实参
	 * @param id
	 * @return
	 */
	public String getUserByIdSql(Map<String, Object> param) {
		BEGIN();
		SELECT("*");
		FROM("user");
		if(!param.get("id").toString().equals("0")) {
			WHERE("user_id=#{id}");
		}
		return SQL();
	}
	
	/**
	 * 查询所有的对象
	 * @return
	 */
	public String getUserListSql() {
		BEGIN();
		SELECT("*");
		FROM("user");
		return SQL();
	}
	
	
	public String getUserSql(User user) {
		BEGIN();
		//username as name  中的  as  后面跟的是什么名字  那么对象中的属性就要叫什么  ，才能注入
		//SELECT("username as name ,age as a,password as pw");
		SELECT("username,age,password");
		FROM("user");
		if(null != user.getUsername() && !user.getUsername().equals("")) {
			WHERE("username like #{username}");
		}
		if(user.getUser_id() != 0) {
			WHERE("user_id = #{user_id}");
		}
		return SQL();
	}
	
	
	/**
	 * mybatis推荐的方式
	 * @return
	 */
	public String addUserSql(){
		return new SQL() {
			{
				INSERT_INTO("user");
				VALUES("username,password,age,birth", "#{username},#{password},#{age},#{birth}");
			}
		}.toString();
	}
	
	public String updateUserSql(User user) {
		return new SQL() {
			{
				UPDATE("user");
				if(!user.getUsername().equals("")) {
					SET("username=#{username}");
				}
				SET("age=#{age}");
				SET("password = #{password}");
				WHERE("user_id=#{user_id}");
			}
		}.toString();
	}
	
	
}
