package com.example.demo.usr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.demo.usr.domain.User;

interface UserCustomRepository{
	
}

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>,
UserCustomRepository{
	  public Optional<User> findByUsrEmail(String usrEmail);
	  // public Optional<User> findByUseridOrEmail(String usrid, String usrEmail);
	  // public List<User> findByUserNumIn(List<Long> usrNo);
	  // public Optional<User> findByUserid(String usrid);
	  // public Boolean existsByUserid(String usrid);
	  public Boolean existsByUsrEmail(String usrEmail);
	
	@Query(value="update User u set u.usr_pwd = :usrPwd,"
			+ " u.usr_phone = :usrPhone"
			+ " where u.usr_no = :usrNo", nativeQuery = true)
	public int update(@Param("usrPwd") String usrPwd, 
						@Param("usrPhone") String usrPhone, 
						@Param("usrNo") long usrNo);
	public List<User> findByUsrEmailAndUsrName(String usrName, String usrEmail);

}



