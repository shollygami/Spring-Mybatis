package com.costamar.app.DAO;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("SELECT count(*) as count FROM commentcorp.user where login = #{0} and pass = #{1}")
	@Result(column = "count", property = "count")
	Integer valiatorLogin(String login, String pass);
	
}	