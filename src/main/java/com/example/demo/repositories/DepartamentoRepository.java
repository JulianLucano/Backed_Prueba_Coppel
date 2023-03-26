package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Departamento;

import jakarta.transaction.Transactional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	/*@Query(value="{call getDepartamentos()}", nativeQuery=true)
	List<Departamento> getDepartamentos();*/
	
	@Modifying
	@Procedure(name = "getDepartamentos")
	@Transactional
	List<Departamento> getDepartamentos();
}
