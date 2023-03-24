package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Departamento;
import com.example.demo.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired(required=false)
	private DepartamentoRepository deptoRepository;
	
	public List<Departamento> getDepartamentos() {
		return deptoRepository.getDepartamentos();
	}
	
}
