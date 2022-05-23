package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{

	Show findByName(String name);
	
}
