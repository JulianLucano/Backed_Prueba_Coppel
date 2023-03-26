package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	@Query(value="{call getDepartamentos()}")
	List<Departamento> getDepartamentos();
}
