package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Articulo;
import com.example.demo.services.ArticuloService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/articulos")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping("/articulo/{sku}")
	public ResponseEntity<Articulo> getArticuloBySku(@PathVariable("sku") Integer sku){
		return new ResponseEntity<Articulo>(articuloService.getArticuloBySku(sku), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo articulo){
		return new ResponseEntity<>(articuloService.save(articulo), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Articulo> updateArticulo(@RequestBody Articulo articulo){
		articuloService.actualizarArticulo(articulo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Void> addArticulo(@RequestBody Articulo articulo){
		articuloService.addArticulo(articulo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{sku}")
	public ResponseEntity<Void> deleteArticulo(@PathVariable("sku") Integer sku){
		articuloService.deleteArticuloBySku(sku);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
