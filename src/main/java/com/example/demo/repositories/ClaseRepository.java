package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitys.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Integer>{

	@Query(value="{call getClasesPorDepto(:idDeptoIn)}", nativeQuery=true)
	List<Clase> getClasesPorDepto(@Param("idDeptoIn") int idDepto);
}
