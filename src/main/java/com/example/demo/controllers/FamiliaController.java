package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Familia;
import com.example.demo.services.FamiliaService;

@RestController
@RequestMapping("/familias")
public class FamiliaController {

	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping("/{clase}")
	private ResponseEntity<List<Familia>> getFamiliasByClase(@PathVariable("clase") int idClase){
		return new ResponseEntity<>(familiaService.getFamiliasPorClase(idClase), HttpStatus.OK);
	}
}
