package com.example.demo.cmm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public abstract class AbstractController<T> {
	public abstract ResponseEntity<Integer> save(T t);
	public abstract ResponseEntity<Integer> delete(T t);
	public abstract ResponseEntity<Integer> count();
	public abstract ResponseEntity<T> getOne(int id);
	public abstract ResponseEntity<Optional<T>> findById(int id);
	public abstract ResponseEntity<Boolean> existsById(int id);
	public abstract ResponseEntity<List<T>> findAll();

}
