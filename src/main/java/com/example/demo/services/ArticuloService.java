package com.example.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entitys.Articulo;
import com.example.demo.repositories.ArticuloRepository;

@Service
public class ArticuloService {

	@Autowired
	private ArticuloRepository articuloRepository;
	
	public Articulo getArticuloBySku(Integer sku) {
		return articuloRepository.buscarPorSku(sku).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						String.format("Articulo con sku %d no encontrado", sku)));
	}
	
	public void addArticulo(Articulo articulo) {
		Optional<Articulo> art = articuloRepository.findBySku(articulo.getSku());
		if(art.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, String.format("Ya existe un articulo con sku %d", articulo.getSku()));
		}else {
			if(articulo.getStock() >= articulo.getCantidad()) {
				articuloRepository.addArticulo(
						articulo.getSku(),
						articulo.getArticulo(),
						articulo.getMarca(),
						articulo.getModelo(),
						articulo.getDepartamento().getId(),
						articulo.getClase().getId(),
						articulo.getFamilia().getId(),
						articulo.getFechaAlta(),
						articulo.getStock(),
						articulo.getCantidad(),
						articulo.getDescontinuado(),
						articulo.getFechaBaja()
						);
				
			}else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("La cantidad debe ser menor al stock"));
			}
		}
		
	}
	
	public void actualizarArticulo(Articulo articulo) {
		Optional<Articulo> art = articuloRepository.findBySku(articulo.getSku());
		if(art.isPresent()) {
			if(articulo.getCantidad() > articulo.getStock()) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("La cantidad debe ser menor al stock"));
			}
			
		  articuloRepository.updateArticulo(
					articulo.getSku(),
					articulo.getArticulo(),
			        articulo.getMarca(),
					articulo.getModelo(),
					articulo.getDepartamento().getId(),
					articulo.getClase().getId(),
					articulo.getFamilia().getId(),
					articulo.getFechaAlta(),
					articulo.getStock(),
					articulo.getCantidad(),
					articulo.getDescontinuado(),
					articulo.getFechaBaja());
			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Articulo con sku %d no existe", articulo.getSku()));
		}
		
	}
	
	public Articulo save(Articulo articulo) {
		return articuloRepository.save(articulo);
	}
	
    public void deleteArticuloBySku(int sku) {
    	Optional<Articulo> articulo = articuloRepository.findBySku(sku);
    	if(articulo.isPresent()) {
    		articuloRepository.borrarArticuloBySku(sku);
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Articulo con sku %d no existe", sku));
    	}
	}
	
}
