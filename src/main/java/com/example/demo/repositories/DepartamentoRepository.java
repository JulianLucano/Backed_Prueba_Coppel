package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entitys.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	@Query(value="{call getDepartamentos()}", nativeQuery=true)
	List<Departamento> getDepartamentos();
}
