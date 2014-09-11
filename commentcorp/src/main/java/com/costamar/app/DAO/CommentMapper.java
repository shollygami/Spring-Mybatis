package com.costamar.app.DAO;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper {

	@Select("SELECT count(*) as count FROM commentcorp.user where login = #{0} and pass = #{1}")
	@Result(column = "count", property = "count")
	Integer valiatorLogin2(String login, String pass);
	
	
}
