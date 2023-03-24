package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer>{

	@Query(value="{call getFamiliasPorClase(:idClaseIn)}", nativeQuery=true)
	List<Familia> getFamiliasPorClase(@Param("idClaseIn") int idClase);
}
