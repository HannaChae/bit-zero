package com.example.demo.lvl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.lvl.domain.Level;
import com.example.demo.lvl.repository.LevelCustomRepository;

interface LevelCustomRepository{
	
}
public interface LevelRepository extends JpaRepository<Level, Long>,
LevelCustomRepository{

}
