package com.example.demo.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitys.Articulo;

import jakarta.transaction.Transactional;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
	
	public Optional<Articulo> findBySku(int sku);

	@Query(value="{call buscarPorSku(:skuIn)}", nativeQuery=true)
	Optional<Articulo> buscarPorSku(@Param("skuIn") Integer sku);
	
	@Modifying
	@Query(value="{call createArticulo(:skuIn, :articuloIn, :marcaIn, :modeloIn, :id_departamentoIn, :id_claseIn, :id_familiaIn, :fecha_altaIn, :stockIn, :cantidadIn, :descontinuadoIn, :fecha_bajaIn)}", nativeQuery=true)
	@Transactional
	void addArticulo(
			@Param("skuIn") int sku,
			@Param("articuloIn") String articulo,
			@Param("marcaIn") String marca,
			@Param("modeloIn") String modelo,
			@Param("id_departamentoIn") int idDepto,
			@Param("id_claseIn") int idClase,
			@Param("id_familiaIn") int idFamilia,
			@Param("fecha_altaIn") Date fecha_alta,
			@Param("stockIn") int stock,
			@Param("cantidadIn") int cantidad,
			@Param("descontinuadoIn") int descontinuado,
			@Param("fecha_bajaIn") Date fecha_baja
			);
	
	@Modifying
	@Query(value="{call actualizarArticulo(:skuIn, :articuloIn, :marcaIn, :modeloIn, :id_departamentoIn, :id_claseIn, :id_familiaIn, :fecha_altaIn, :stockIn, :cantidadIn, :descontinuadoIn, :fecha_bajaIn)}", nativeQuery=true)
	@Transactional
	void updateArticulo(
			@Param("skuIn") Integer sku,
			@Param("articuloIn") String articulo,
			@Param("marcaIn") String marca,
			@Param("modeloIn") String modelo,
			@Param("id_departamentoIn") Integer idDepto,
			@Param("id_claseIn") Integer idClase,
			@Param("id_familiaIn") Integer idFamilia,
			@Param("fecha_altaIn") Date fecha_alta,
			@Param("stockIn") Integer stock,
			@Param("cantidadIn") Integer cantidad,
			@Param("descontinuadoIn") Integer descontinuado,
			@Param("fecha_bajaIn") Date fecha_baja
			);
	
	@Modifying
	@Query(value="{call deleteArticuloPorSku(:skuIn)}", nativeQuery=true)
	@Transactional
	void borrarArticuloBySku(@Param("skuIn") int sku);


}
