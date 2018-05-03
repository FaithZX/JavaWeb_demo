package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entity.User;
import com.entity2.IdCard;
import com.entity2.Person;
import com.entity3.Department;
import com.entity3.Employee;
import com.entity4.Group;

public interface UserDao {

	@Insert("insert into user (username,password,age,birth) values (#{username},#{password},#{age},#{birth})")
	@Options(useGeneratedKeys=true,keyProperty="user_id")
	public void addUser(User user);
	
	/**
	 * 如果参数是对象模式   那么只要 #{username} 和对象中的属性能匹配的上就自动去找
	 * @param user
	 */
	@Delete("delete from user where username = #{username}")
	public void deleteUser(User user);
	
	@Update("update user set username=#{username},password=#{password},age=#{age},birth=#{birth} where user_id = #{user_id}")
	public void updateUser(User user);
	
	@Select("select * from user")
	public List<User> getUserAll();
	
	/**
	 * 分页  #{minNum} 从多少条开始 
	 * #{maxNum}查询多少条  这一页的数量
	 */
	@Select("select * from user limit #{minNum},#{maxNum}")
	public List<User> userList(@Param(value="minNum") int minNum,
								@Param(value="maxNum") int maxNum);
	
	
	@Select("select * from user where username like #{username} limit #{minNum},#{maxNum}")
	public List<User> userList2(@Param(value="username") String username ,@Param(value="minNum") int minNum,
								@Param(value="maxNum") int maxNum);
	
	
	
	/**
	 * 一对一
	 * @param id
	 * @return
	 */
	@Select("select * from person where person_id = #{id}")
	@Results({
			@Result(id = true,column="person_id",property="personId"),
			@Result(column="username",property="username"),
			@Result(column="age",property="age"),
			@Result(column="birth",property="birth"),
			@Result(column="card_id",property="idCard", one=@One(select="getIdCard"))
	})
	public Person getPerson(@Param(value="id") int id);
	
	
	@Select("select * from idcard where card_id = #{card_id}")
	@Results({
		@Result(id = true,column="card_id",property="card_id"),
		@Result(column="card_num",property="cardNum"),
	})
	public IdCard getIdCard();
	
	
	/**
	 * 一对多     @Result(property="empSet",column="depId", many=@Many(select="getEmp"))
	 * 多的  property="empSet"(private Set<Employee> empSet = new HashSet<Employee>();) 要和本表的id主键对上
	 * @param id
	 * @return
	 */
	@Select("select * from department where depId = #{id}")
	@Results({
			@Result(id = true,column="depId",property="depId"),
			@Result(column="depName",property="depName"),
			@Result(property="empSet",column="depId", many=@Many(select="getEmp"))
	})
	public Department getDep(@Param(value="id") int id);
	
	@Select("select * from employee where depId = #{depId}")
	@Results({
		@Result(id = true,column="empId",property="empId"),
		@Result(column="empName",property="empName"),
	})
	public List<Employee> getEmp();
	
	
	/**
	 * 多对多
	 * @param id
	 * @return
	 */	
	/*@Select("select * from groups where groupId = #{id}")
	@Results({
			@Result(id = true,column="groupId",property="groupId"),
			@Result(column="groupName",property="groupName"),
			@Result(property="userSet",column="groupId", many=@Many(select="selectUsers"))
	})
	public List<Group> groupList(@Param(value="id") int id);
	
	@Select("select * from user2 where userId in (select userId from group_user where groupId = #{id})")
	public List<com.entity4.User> selectUsers(@Param(value="id")int id);
	
	@Select("select * from user2 where userId = #{id}")
	@Results({
			@Result(id = true,column="userId",property="userId"),
			@Result(column="userName",property="userName"),
			@Result(property="groupSet",column="userId",many=@Many(select="selectGroups"))
	})
	public List<com.entity4.User> userList3(@Param(value="id") int id);
	
	@Select("select * from groups where groupId in(select groupId from group_user where userId = #{id})")
	public List<Group> selectGroups(@Param(value="id") int id);*/
	
	@Select("select * from groups where groupId = #{id}")
	@Results({
		@Result(id=true,column="groupId",property="groupId"),
		@Result(column="groupName",property="groupName"),
		@Result(column="groupId",property="userSet",many=@Many(select="selectUsers"))
	})
	public List<Group> getGroupList(@Param(value="id") int id);
	
	@Select("select * from user2 where userId in (select userId from group_user where groupId=#{id})")
	public List<com.entity4.User> selectUsers();
	
	
	
}
