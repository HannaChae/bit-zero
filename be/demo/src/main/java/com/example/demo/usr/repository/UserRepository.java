package com.example.demo.usr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.usr.domain.User;

interface IUserRepository{
	
}

public interface UserRepository extends JpaRepository<User, Integer>,
									IUserRepository{
	
	@Query("update User set usr_pwd = :#{user.usrPwd},"
			+ " usr_phone = :#{user.usrPhone}"
			+ " where usr_no = :#{user.usrNo}")
	public int update(@Param("user") User t);
	public List<User> findByUsrEmailAndUsrName(String usrName, String usrEmail);

}



