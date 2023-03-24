package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Clase;
import com.example.demo.repositories.ClaseRepository;

@Service
public class ClaseService {

	@Autowired(required=false)
	private ClaseRepository claseRepository;
	
	public List<Clase> getClasesPorDepto(int idDepto) {
		return claseRepository.getClasesPorDepto(idDepto);
	}
}
