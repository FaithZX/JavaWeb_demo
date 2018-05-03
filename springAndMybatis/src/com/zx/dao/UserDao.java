package com.zx.dao;

import org.apache.ibatis.annotations.Select;

public interface UserDao {
	
	@Select("select count(*) from user")
	public int getUserCount();
	
	
}
