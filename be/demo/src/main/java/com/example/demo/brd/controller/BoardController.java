package com.example.demo.brd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.brd.domain.Board;
import com.example.demo.brd.service.BoardServiceImpl;
import com.example.demo.cmm.controller.AbstractController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/board")
public class BoardController extends AbstractController<Board> {
	final BoardServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<Integer> save(@RequestBody Board t) {
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Integer> delete(@RequestBody Board t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Board> getOne(@PathVariable int id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Board>> findById(@PathVariable int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable int id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Board>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Board>> findByTitle(@PathVariable String title) {
		return ResponseEntity.ok(service.findByTitle(title));
	}
	@GetMapping("/writtenDate/{writtenDate}")
	public ResponseEntity<List<Board>> findByWrittenDate(@PathVariable String writtenDate) {
		return ResponseEntity.ok(service.findByWrittenDate(writtenDate));
	}
}