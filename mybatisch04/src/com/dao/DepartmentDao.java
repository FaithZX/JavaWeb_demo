package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.entity3.Department;

public interface DepartmentDao {

	
	/**
	 * xml结合注解映射 做持久化
	 * getDep 需要和DepartmentMapper.xml配置文件中的id <resultMap type="Department" id="getDep"> 
	 * 如果是面向接口的时候  是不需要 Mapper.xml 文件的  所以需要在configuration.xml文件中  直接指向相对应的接口类 <mapper class="com.dao.DepartmentDao"/>
	 * 如果是xml配置  或者xml和注解结合在一起的  那就就需要在configuration.xml文件中配置<mapper resource="com/dao/DepartmentMapper.xml" />  
	 * 		并且在 DepartmentMapper.xml文件中需要指向相对应的接口类  <mapper namespace="com.dao.DepartmentDao">
	 *
	 * @param id
	 * @return
	 */
	@Select("select * from department d inner join employee e on d.depId = e.depId where d.depId= #{id}")
	@ResultMap("getDep") //  取的是DepartmentMapper.xml配置文件中 ResultMap 的id
	public Department getDepById(@Param("id")int id);
	
}
