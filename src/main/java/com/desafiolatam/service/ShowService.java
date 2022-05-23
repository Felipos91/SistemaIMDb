package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Show;
import com.desafiolatam.repositories.ShowRepository;

@Service
public class ShowService {

	@Autowired
	ShowRepository showRepository;


	public Show findbyName(String name) {
		return showRepository.findByName(name);
	}


	public void save(Show showSave) {
		showRepository.save(showSave);
	}


	public List<Show> findAll() {
		
		return showRepository.findAll();
	}


	public Show findbyId(Long id) {
			return showRepository.findById(id).get();
	}


	public void deleteById(Long id) {
		showRepository.deleteById(id);
		
	}


	
	
	
}
