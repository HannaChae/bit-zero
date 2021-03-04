package com.example.demo.usr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.demo.usr.domain.User;

interface IUserRepository{
	
}

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>,
									IUserRepository{
	
	@Query(value="update User set usr_pwd = :usrPwd,"
			+ " usr_phone = :usrPhone"
			+ " where usr_no = :usrNo", nativeQuery = true)
	public int update(@Param("usrPwd") String usrPwd, 
						@Param("usrPhone") String usrPhone, 
						@Param("usrNo") int usrNo);
	public List<User> findByUsrEmailAndUsrName(String usrName, String usrEmail);

}



