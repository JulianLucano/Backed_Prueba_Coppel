package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Departamento;
import com.example.demo.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Value("${spring.datasource.username}")
	private String userName;

	@Autowired
	private DepartamentoRepository deptoRepository;
	
	public List<Departamento> getDepartamentos() {
		System.out.println("USERNAME"+userName);
		return deptoRepository.getDepartamentos();
	}
	
}
