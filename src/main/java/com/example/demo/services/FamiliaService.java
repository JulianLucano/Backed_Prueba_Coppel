package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Familia;
import com.example.demo.repositories.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired(required=false)
	private FamiliaRepository familiaRepository;
	
	public List<Familia> getFamiliasPorClase(int idClase){
		return familiaRepository.getFamiliasPorClase(idClase);
	}
}
