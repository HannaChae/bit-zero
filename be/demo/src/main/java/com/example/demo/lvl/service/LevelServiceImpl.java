package com.example.demo.lvl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.lvl.domain.Level;
import com.example.demo.lvl.repository.LevelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl extends AbstractService<Level> 
								implements LevelService{
	private final LevelRepository repo;

	@Override public long save(Level t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Level getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Level> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Level> findAll() {return repo.findAll();}
	@Override public long delete(Level t) {
		repo.delete(t); 
		return (getOne(t.getLevel())==null) ? 1 : 0;
	}
}