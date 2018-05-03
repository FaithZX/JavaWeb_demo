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
	 * xml���ע��ӳ�� ���־û�
	 * getDep ��Ҫ��DepartmentMapper.xml�����ļ��е�id <resultMap type="Department" id="getDep"> 
	 * ���������ӿڵ�ʱ��  �ǲ���Ҫ Mapper.xml �ļ���  ������Ҫ��configuration.xml�ļ���  ֱ��ָ�����Ӧ�Ľӿ��� <mapper class="com.dao.DepartmentDao"/>
	 * �����xml����  ����xml��ע������һ���  �Ǿ;���Ҫ��configuration.xml�ļ�������<mapper resource="com/dao/DepartmentMapper.xml" />  
	 * 		������ DepartmentMapper.xml�ļ�����Ҫָ�����Ӧ�Ľӿ���  <mapper namespace="com.dao.DepartmentDao">
	 *
	 * @param id
	 * @return
	 */
	@Select("select * from department d inner join employee e on d.depId = e.depId where d.depId= #{id}")
	@ResultMap("getDep") //  ȡ����DepartmentMapper.xml�����ļ��� ResultMap ��id
	public Department getDepById(@Param("id")int id);
	
}
