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

	@Override public long save(User t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public User getOne(long id) {return repo.getOne(id);}
	@Override public Optional<User> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<User> findAll() {return repo.findAll();}
	@Override public long delete(User t) {
		repo.delete(t); 
		return (getOne(t.getUsrNo())==null) ? 1 : 0;
	}
}