package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Departamento;
import com.example.demo.services.DepartamentoService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins= {"https://test-copp-fe122.web.app"})
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService deptoService;
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<Departamento>> getDepartamentos(){
		return new ResponseEntity<>(deptoService.getDepartamentos(), HttpStatus.OK);
	}
}
