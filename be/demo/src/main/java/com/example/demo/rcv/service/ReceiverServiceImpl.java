package com.example.demo.rcv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.rcv.domain.Receiver;
import com.example.demo.rcv.repository.ReceiverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceiverServiceImpl extends AbstractService<Receiver> 
								implements ReceiverService{
	private final ReceiverRepository repo;

	@Override public long save(Receiver t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Receiver getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Receiver> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Receiver> findAll() {return repo.findAll();}
	@Override public long delete(Receiver t) {
		repo.delete(t); 
		return (getOne(t.getRcvNo())==null) ? 1 : 0;
	}
}