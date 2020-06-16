package com.uca.capas.Labo7.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.Labo7.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
	
	public List<Estudiante> findByNombre(String nombre) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String apellido) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "SELECT * FROM public.estudiante")
	public List<Estudiante> showAll() throws DataAccessException;
	
	@Query(nativeQuery = true, value = "SELECT * FROM public.estudiante WHERE nombre = :nombre")
	public List<Estudiante> showByName(String nombre) throws DataAccessException;
		
}
