package com.costamar.app.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.costamar.app.bean.Account;

public interface AccountMapper {

	
	@Select("select accountID,name from Users where status=1")
	@Results( value = {
		@Result(column="accountID", property="AccountNumber"),
		@Result(column="name", property="accountName")
	})
	List<Account> getAccount();
}
