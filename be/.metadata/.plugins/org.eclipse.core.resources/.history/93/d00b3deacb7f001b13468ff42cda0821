package com.example.demo.usr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.usr.domain.User;
import com.example.demo.usr.repository.UserRepository;
import com.example.demo.cmm.service.AbstractService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User> 
								implements UserService{
	private final UserRepository repo;

	@Override public int save(User t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public int count() {return (int) repo.count();}
	@Override public User getOne(int id) {return repo.getOne(id);}
	@Override public Optional<User> findById(int id) {return repo.findById(id);}
	@Override public boolean existsById(int id) {return repo.existsById(id);}
	@Override public List<User> findAll() {return repo.findAll();}
	@Override public int delete(User t) {
		repo.delete(t); 
		return (getOne(t.getUsrNo())==null) ? 1 : 0;
	}
}