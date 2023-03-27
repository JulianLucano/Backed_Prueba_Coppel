package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Clase;
import com.example.demo.services.ClaseService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/clases")
public class ClaseController {

	@Autowired
	private ClaseService claseService;
	
	@GetMapping("/{depto}")
	public ResponseEntity<List<Clase>> getClasesPorDepto(@PathVariable("depto") int idDepto){
		return new ResponseEntity<>(claseService.getClasesPorDepto(idDepto), HttpStatus.OK);
	}
	
}
